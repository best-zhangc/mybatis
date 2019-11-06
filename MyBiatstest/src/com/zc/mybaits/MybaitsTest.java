package com.zc.mybaits;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybaitsTest {
	/*
	 * 添加学生
	 */
	public static void addBook() throws IOException {
		Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(reader);
			SqlSession  session = sqlSession.openSession();
		String  stament = "com.zc.mybaits.bookMapper.addBook";
		Book book = new Book(2,"java语言设计",269);
		int count = session.insert(stament, book);
		session.commit();//提交事务
		System.out.println("添加"+count+"本图书");
		session.close();
	}
	
	/*
	 * 查询单个学生
	 * 
	 * */
	public  static void queryBookById() throws IOException {
		//加载配置文件 为了访问数据库
				Reader reader = Resources.getResourceAsReader("config.xml");
				SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				//传namespace+"select id="queryBookById" 
				String statment = "com.zc.mybaits.bookMapper.queryBookById";
				Book book = session.selectOne(statment,1);
				System.out.println(book);
				session.close();
	}
	/*
	 * 查询全部学生
	 */
	public  static void queryAllBook() throws IOException {
		//加载配置文件 为了访问数据库
				Reader reader = Resources.getResourceAsReader("config.xml");
				SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				//传namespace+"select id="queryBookById" 
				String statment = "com.zc.mybaits.bookMapper."+"queryAllBook";
				List<Book> book = session.selectList(statment);
				System.out.println(book);
				session.close();
	}
	public static void main(String[] args) throws IOException {
		//queryBookById();
		//	addBook();
		queryAllBook();
		
		
	}

}
