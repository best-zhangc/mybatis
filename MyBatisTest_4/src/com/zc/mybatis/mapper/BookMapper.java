package com.zc.mybatis.mapper;

import java.util.List;

import com.zc.mybatis.Book;
import com.zc.mybatis.Explain;

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
	//按书名查
	 Book queryBookBybookName(String bookName);
	//查询全部
	List<Book> queryAllBook();
	//查询全部 并且根据书名排序
	List<Book> queryBookOrderByBookColumn(String column);
	// 根据书名或价格查询
	List<Book> queryBookBybookPriceOrbookName(Book book);
	//根据类型或简介查询 
	List<Book> queryBookByExplain(Book explain);
	//使用了转换器查
	Book queryBookByIdWithConverter(int bookId);
	//添加
	void  addBookWithConverter(Book book) ;
}
