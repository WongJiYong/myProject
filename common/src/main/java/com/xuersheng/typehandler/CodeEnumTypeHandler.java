package com.xuersheng.typehandler;

import com.xuersheng.enumm.BaseCodeEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CodeEnumTypeHandler<E extends Enum<?> & BaseCodeEnum> extends BaseTypeHandler<BaseCodeEnum> {

    private Class<E> type;

    public CodeEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, BaseCodeEnum parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setString(i, parameter.getCode());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String code = rs.getString(columnName);
        return rs.wasNull() ? null : codeOf(code);
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String code = rs.getString(columnIndex);
        return rs.wasNull() ? null : codeOf(code);
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String code = cs.getString(columnIndex);
        return cs.wasNull() ? null : codeOf(code);
    }

    private E codeOf(String code){
        try {
            E[] enumConstants = type.getEnumConstants();
            for (E e : enumConstants) {
                if (e.getCode().equals(code))
                    return e;
            }
            return null;
        } catch (Exception ex) {
            throw new IllegalArgumentException("Cannot convert " + code + " to " + type.getSimpleName() + " by code value.", ex);
        }
    }
}