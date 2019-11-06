package com.zc.mybatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zc.mybatis.Book;
import com.zc.mybatis.Explain;
import com.zc.mybatis.mapper.BookMapper;

public class MybatisTest {
	/**
	 *  @return
	 * 添加图书
	 */
	public static void addBook() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
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
	 *  @return
	 * 添加图书
	 * 带转换器的添加
	 */
	public static void addBookWithConverter() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(reader);
			SqlSession  session = sqlSession.openSession();
		//String  stament = "com.zc.mybaits.bookMapper.addBook";
		Book book = new Book(5,"java核心技术I",88,false);
		BookMapper bookMapper = session.getMapper(BookMapper.class);
		bookMapper.addBookWithConverter(book);
		session.commit();//提交事务
		System.out.println("添加成功图书");
		session.close();
	}
	
	
	/**
	 * @return
	 * 删除图书
	 */
	public static void deleteBookById() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
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
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(reader);
		SqlSession  session = sqlSession.openSession();
		//修改的参数
		Book book = new  Book();
		//修改那本书
		book.setBookId(4);
		//修改为什么样
		book.setBookName("javaEE企业级网站开发");
		book.setBookPrice(248);
		
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
				Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				BookMapper  bookMapper = session.getMapper(BookMapper.class) ;
				Book book = bookMapper.queryBookById(1) ;//接口中的方法 自动找到SQL语句
				
				/*传namespace+"select id="queryBookById" 
				String statment = "com.zc.mybaits.bookMapper.queryBookById";
				Book book = session.selectOne(statment,1)*/
						
						
				System.out.println(book);
				session.close();
	}
	
	/**
	 *  @return
	 * 查询单个学生ByName(书名)
	 * 
	 */
	public  static void queryBookBybookName() throws IOException {
				//加载配置文件 为了访问数据库
				Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				BookMapper  bookMapper = session.getMapper(BookMapper.class) ;
				Book book = bookMapper.queryBookBybookName("javaEE企业级网站开发") ;//接口中的方法 自动找到SQL语句
				System.out.println(book);
				session.close();
	}
	
	/**
	 *  @return
	 * 查询单个学生
	 * 使用转换器
	 */
	public  static void queryBookByIdWithConverter() throws IOException {
				//加载配置文件 为了访问数据库
				Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				BookMapper  bookMapper = session.getMapper(BookMapper.class) ;
				Book book = bookMapper.queryBookByIdWithConverter(2) ;//接口中的方法 自动找到SQL语句		
				System.out.println(book);
				session.close();
	}
	
	/**
	 *  @return
	 * 查询全部学生
	 */
	public  static void queryAllBook() throws IOException {
		//加载配置文件 为了访问数据库
				Reader reader = Resources.getResourceAsReader("conf.xml");
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
	/**
	 * 查询全部 并且根据价格（bookPrice）排序
	 * @return
	 * 
	 */
	public  static void queryBookOrderByBookColumn() throws IOException {
		//加载配置文件 为了访问数据库
				Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				BookMapper bookMapper = session.getMapper(BookMapper.class);
				List<Book> list = bookMapper.queryBookOrderByBookColumn("bookPrice");
				System.out.println(list);
				session.close();
	}
	
	/**
	 * 根据书名或价格进行查询
	 * @return
	 * 
	 */
	public  static void queryBookBybookPriceOrbookName() throws IOException {
		//加载配置文件 为了访问数据库
				Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				BookMapper bookMapper = session.getMapper(BookMapper.class);
				Book book = new Book();
				book.setBookName("语");
				book.setBookPrice(88);
				List<Book> list = bookMapper.queryBookBybookPriceOrbookName(book);
				System.out.println(list);
				session.close();
	}

	/**
	 * 根据书名或价格进行查询
	 * @return
	 * 
	 */
	public  static void queryBookByExplain() throws IOException {
		//加载配置文件 为了访问数据库
				Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				BookMapper bookMapper = session.getMapper(BookMapper.class);
				/*Explain explain = new Explain();
				explain.setBookCategory("技术");
				explain.setBookDescription("编程");
				List<Book> book = bookMapper.queryBookByExplain(explain);*/
				Book book1 = new Book();
				Explain explain = new Explain();
				explain.setBookCategory("技术");
				explain.setBookDescription("编程");
				book1.setExplain(explain);
				List<Book>  book= bookMapper.queryBookByExplain(book1);
				System.out.println(book);
				session.close();
	}

	
	
	public static void main(String[] args) throws IOException {
		
		//addBookWithConverter(); // 添加 (加了类型转换器)
		//queryBookByIdWithConverter(); //按Id 查询 (加了类型转换器)
		//queryBookById();  //按Id 查询 
		//queryBookBybookName(); //按Name 查询
		//addBook(); //添加图书
		//deleteBookById(); // 删除图书
		//queryAllBook(); // 查询全部图书
		//updateBookById(); //修改图书
		//queryBookOrderByBookColumn(); //根据价格进行排序
		//queryBookBybookPriceOrbookName();//根据书名或价格进行查询
		queryBookByExplain();
	}

}
