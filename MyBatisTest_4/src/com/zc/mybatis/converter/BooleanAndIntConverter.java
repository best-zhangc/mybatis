package com.zc.mybatis.converter;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
//BaseTypeHandler<java类型（Boolean）>
public class BooleanAndIntConverter extends BaseTypeHandler<Boolean>{

	//JAVA(BOOLEAN)-DB(INT)
	/**
	 * PS:PreparedStatement对象
	 * i:PreparedStatement对象操作参数的值
	 * parameter：java值
	 * jdbcType:jdbc 操作的数据库类型
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
	 * 通过列名拿数据库值
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
	 * 通过下标拿数据库值
	 */
	@Override
	public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		int bookSell = rs.getInt(columnIndex);
		
		return bookSell== 1 ? true:false;
	}

	/**
	 * boolean--->int
	 * 通过存储过程拿数据库值
	 */
	@Override
	public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		int bookSell = cs.getInt(columnIndex);
		
		return bookSell== 1 ? true:false;
	}


}
