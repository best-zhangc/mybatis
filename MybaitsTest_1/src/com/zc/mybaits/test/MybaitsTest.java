package com.zc.mybaits.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zc.mybaits.Book;
import com.zc.mybaits.mapper.BookMapper;

public class MybaitsTest {
	/**
	 *  @return
	 * 添加学生
	 */
	public static void addBook() throws IOException {
		Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(reader);
			SqlSession  session = sqlSession.openSession();
		//String  stament = "com.zc.mybaits.bookMapper.addBook";
		Book book = new Book(5,"java核心技术",88);
		BookMapper bookMapper = session.getMapper(BookMapper.class);
		bookMapper.addBook(book);
		//int count = session.insert(stament, book);
		session.commit();//提交事务
		System.out.println("添加成功图书");
		session.close();
	}
	
	/**
	 * @return
	 * 删除图书
	 */
	public static void deleteBookById() throws IOException {
		Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(reader);
		SqlSession  session = sqlSession.openSession();
		BookMapper bookMapper = session.getMapper(BookMapper.class);
		bookMapper.deleteBookById(5);
		session.commit();//提交事务
		System.out.println("删除成功");
		session.close();
	}
	
	
	/**
	 * @return
	 * 修改图书
	 */
	public static void updateBookById() throws IOException {
		Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(reader);
		SqlSession  session = sqlSession.openSession();
		//修改的参数
		Book book = new  Book();
		//修改那本书
		book.setBookId(4);
		//修改为什么样
		book.setBookName("javaEE企业级网站开发");
		book.setBookPrice(196);
		
		BookMapper bookMapper = session.getMapper(BookMapper.class);
		bookMapper.updateBookById(book);
		session.commit();//提交事务
		System.out.println("修改成功");
		session.close();
	}
	
	
	/**
	 *  @return
	 * 查询单个学生
	 * 
	 */
	public  static void queryBookById() throws IOException {
				//加载配置文件 为了访问数据库
				Reader reader = Resources.getResourceAsReader("config.xml");
				SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				BookMapper  bookMapper = session.getMapper(BookMapper.class) ;
				Book book = bookMapper.queryBookById(2) ;//接口中的方法 自动找到SQL语句
				
				/*传namespace+"select id="queryBookById" 
				String statment = "com.zc.mybaits.bookMapper.queryBookById";
				Book book = session.selectOne(statment,1)*/
						
						
				System.out.println(book);
				session.close();
	}
	/**
	 *  @return
	 * 查询全部学生
	 */
	public  static void queryAllBook() throws IOException {
		//加载配置文件 为了访问数据库
				Reader reader = Resources.getResourceAsReader("config.xml");
				SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				/*传namespace+"select id="queryBookById" 
				String statment = "com.zc.mybaits.bookMapper."+"queryAllBook";
				List<Book> book = session.selectList(statment);*/
				BookMapper bookMapper = session.getMapper(BookMapper.class);
				List<Book> list = bookMapper.queryAllBook();
				System.out.println(list);
				session.close();
	}
	public static void main(String[] args) throws IOException {
		/*queryBookById();
		addBook();
		*/
		/*deleteBookById();
		queryAllBook();*/
		updateBookById();
		queryAllBook();
		
	}

}
