package com.mybatis.encrypt.encryptdemo.handler;


import com.mybatis.encrypt.encryptdemo.utils.RC4Util;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;


@MappedTypes(String.class)
@MappedJdbcTypes({JdbcType.VARCHAR})
public class FieldEncryptHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String s, JdbcType jdbcType) throws SQLException {
        // 设置非空加密
        ps.setString(i, RC4Util.encryRC4String(s));
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // 获取非空的时候解密
        String columnValue = rs.getString(columnName);
        return RC4Util.decryRC4(columnValue);
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        // 获取非空的时候解密
        String columnValue = rs.getString(columnIndex);
        return RC4Util.decryRC4(columnValue);
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        // 获取非空的时候解密
        String columnValue = cs.getString(columnIndex);
        return RC4Util.decryRC4(columnValue);
    }
}
