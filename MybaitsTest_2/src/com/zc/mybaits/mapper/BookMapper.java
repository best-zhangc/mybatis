package com.zc.mybaits.mapper;

import java.util.List;

import com.zc.mybaits.Book;

//操作Mybaits的接口
public interface BookMapper {
	/**
	 *	1.方法名和mapper.xml文件标签中的Id值相同
	 * 2.方法的输入参数和mapper.xml文件标签中的parameterType(parameterType="int") 类型一致
	 * 3.方法的返回值和mapper.xml文件标签中的resultType类型一致
	 */
	//添加
	void  addBook(Book book) ;
	//删除
	void deleteBookById(int bookId);
	//修改
	void updateBookById(Book book);
	//按Id查询
	Book queryBookById(int bookId);
	//查询全部
	List<Book> queryAllBook();
}
