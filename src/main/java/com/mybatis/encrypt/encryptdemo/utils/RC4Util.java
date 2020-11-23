package com.mybatis.encrypt.encryptdemo.utils;

import java.io.UnsupportedEncodingException;

public class RC4Util {
    private static String default_key = "!@#$%^&*1234567890";

    public RC4Util() {
    }

    public static String encryRC4String(String data) {
        if (data == null) {
            return null;
        } else {
            try {
                return encryRC4String(data, default_key, "utf-8");
            } catch (UnsupportedEncodingException var2) {
                var2.printStackTrace();
                return null;
            }
        }
    }

    public static String encryRC4String(String data, String key) throws UnsupportedEncodingException {
        return encryRC4String(data, key, "utf-8");
    }

    public static String encryRC4String(String data, String key, String chartSet) throws UnsupportedEncodingException {
        return data != null && key != null ? bytesToHex(encryRC4Byte(data, key, chartSet)) : null;
    }

    public static byte[] encryRC4Byte(String data, String key, String chartSet) throws UnsupportedEncodingException {
        if (data != null && key != null) {
            byte[] bData;
            if (chartSet != null && !chartSet.isEmpty()) {
                bData = data.getBytes(chartSet);
                return RC4Base(bData, key);
            } else {
                bData = data.getBytes();
                return RC4Base(bData, key);
            }
        } else {
            return null;
        }
    }

    public static String decryRC4(String data) {
        if (data == null) {
            return null;
        } else {
            try {
                return new String(RC4Base(hexToByte(data), default_key), "utf-8");
            } catch (UnsupportedEncodingException var2) {
                var2.printStackTrace();
                return null;
            }
        }
    }

    public static String decryRC4(String data, String key, String chartSet) throws UnsupportedEncodingException {
        return data != null && key != null ? new String(RC4Base(hexToByte(data), key), chartSet) : null;
    }

    private static byte[] initKey(String aKey) {
        byte[] bkey = aKey.getBytes();
        byte[] state = new byte[256];

        int index1;
        for(index1 = 0; index1 < 256; ++index1) {
            state[index1] = (byte)index1;
        }

        index1 = 0;
        int index2 = 0;
        if (bkey.length == 0) {
            return null;
        } else {
            for(int i = 0; i < 256; ++i) {
                index2 = (bkey[index1] & 255) + (state[i] & 255) + index2 & 255;
                byte tmp = state[i];
                state[i] = state[index2];
                state[index2] = tmp;
                index1 = (index1 + 1) % bkey.length;
            }

            return state;
        }
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < bytes.length; ++i) {
            String hex = Integer.toHexString(bytes[i] & 255);
            if (hex.length() < 2) {
                sb.append(0);
            }

            sb.append(hex);
        }

        return sb.toString();
    }

    public static byte[] hexToByte(String inHex) {
        int hexlen = inHex.length();
        byte[] result;
        if (hexlen % 2 == 1) {
            ++hexlen;
            result = new byte[hexlen / 2];
            inHex = "0" + inHex;
        } else {
            result = new byte[hexlen / 2];
        }

        int j = 0;

        for(int i = 0; i < hexlen; i += 2) {
            result[j] = (byte)Integer.parseInt(inHex.substring(i, i + 2), 16);
            ++j;
        }

        return result;
    }

    private static byte[] RC4Base(byte[] input, String mKkey) {
        int x = 0;
        int y = 0;
        byte[] key = initKey(mKkey);
        byte[] result = new byte[input.length];

        for(int i = 0; i < input.length; ++i) {
            x = x + 1 & 255;
            y = (key[x] & 255) + y & 255;
            byte tmp = key[x];
            key[x] = key[y];
            key[y] = tmp;
            int xorIndex = (key[x] & 255) + (key[y] & 255) & 255;
            result[i] = (byte)(input[i] ^ key[xorIndex]);
        }

        return result;
    }
}
