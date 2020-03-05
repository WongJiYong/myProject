package com.xuersheng.myProject.typehandler;

import com.xuersheng.myProject.exception.AlgorithmException;
import com.xuersheng.myProject.util.AESUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;


@MappedTypes(String.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class ASETypeHandler extends org.apache.ibatis.type.BaseTypeHandler {

    @Value("${ASE.KEY}")
    private String key;

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        if (parameter instanceof String) {
            try {
                byte[] bytes = AESUtils.encryptText((String) parameter, key);
                String s = Base64.getEncoder().encodeToString(bytes);
                ps.setString(i, s);
            } catch (AlgorithmException e) {
                logger.error("加密异常", e);
                throw new SQLException("加密异常");
            }
        } else {
            throw new SQLException("数据类型应为String. 不是" + parameter.getClass());
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
