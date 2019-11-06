package com.zc.mybatis.converter;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
//BaseTypeHandler<java���ͣ�Boolean��>
public class BooleanAndIntConverter extends BaseTypeHandler<Boolean>{

	//JAVA(BOOLEAN)-DB(INT)
	/**
	 * PS:PreparedStatement����
	 * i:PreparedStatement�������������ֵ
	 * parameter��javaֵ
	 * jdbcType:jdbc ���������ݿ�����
	 * 
	 */
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
		if (parameter) {
			//1
			ps.setInt(i, 1);
		} else {
			//0
			ps.setInt(i, 0);
		}
	}
	
	/**
	 * boolean--->int
	 * ͨ�����������ݿ�ֵ
	 */
	@Override
	public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
		int bookSell = rs.getInt(columnName);
		/*if (bookSell==1) {
			return true;
		} else {
			return false;
		}*/
		return bookSell==1?true:false;
	}
	
	/**
	 * boolean--->int
	 * ͨ���±������ݿ�ֵ
	 */
	@Override
	public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		int bookSell = rs.getInt(columnIndex);
		
		return bookSell== 1 ? true:false;
	}

	/**
	 * boolean--->int
	 * ͨ���洢���������ݿ�ֵ
	 */
	@Override
	public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		int bookSell = cs.getInt(columnIndex);
		
		return bookSell== 1 ? true:false;
	}


}
