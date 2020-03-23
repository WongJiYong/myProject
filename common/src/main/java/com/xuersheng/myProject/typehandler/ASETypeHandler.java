package com.xuersheng.myProject.typehandler;

import com.xuersheng.myProject.exception.AlgorithmException;
import com.xuersheng.myProject.util.AESUtils;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.sql.*;
import java.util.Base64;


public class ASETypeHandler extends org.apache.ibatis.type.BaseTypeHandler<String> {

    @Value("${ASE.KEY}")
    private String key;

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        try {
            byte[] bytes = AESUtils.encryptText(parameter, key);
            String s = Base64.getEncoder().encodeToString(bytes);
            ps.setString(i, s);
        } catch (AlgorithmException e) {
            logger.error("加密异常", e);
            throw new SQLException("加密异常");
        }
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String col = rs.getString(columnName);
        if (col == null) {
            return null;
        }
        byte[] bytes = Base64.getDecoder().decode(col);
        try {
            return AESUtils.decryptText(bytes, key);
        } catch (AlgorithmException e) {
            logger.error("解密异常", e);
            throw new SQLException("解密异常");
        }
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String col = rs.getString(columnIndex);
        if (col == null) {
            return null;
        }
        byte[] bytes = Base64.getDecoder().decode(col);
        try {
            return AESUtils.decryptText(bytes, key);
        } catch (AlgorithmException e) {
            logger.error("解密异常", e);
            throw new SQLException("解密异常");
        }
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        throw new UnsupportedOperationException("不支持的操作");
    }

}
