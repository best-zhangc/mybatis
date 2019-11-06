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
	 * ���ѧ��
	 */
	public static void addBook() throws IOException {
		Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(reader);
			SqlSession  session = sqlSession.openSession();
		//String  stament = "com.zc.mybaits.bookMapper.addBook";
		Book book = new Book(5,"java���ļ���",88);
		BookMapper bookMapper = session.getMapper(BookMapper.class);
		bookMapper.addBook(book);
		//int count = session.insert(stament, book);
		session.commit();//�ύ����
		System.out.println("��ӳɹ�ͼ��");
		session.close();
	}
	
	/**
	 * @return
	 * ɾ��ͼ��
	 */
	public static void deleteBookById() throws IOException {
		Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(reader);
		SqlSession  session = sqlSession.openSession();
		BookMapper bookMapper = session.getMapper(BookMapper.class);
		bookMapper.deleteBookById(5);
		session.commit();//�ύ����
		System.out.println("ɾ���ɹ�");
		session.close();
	}
	
	
	/**
	 * @return
	 * �޸�ͼ��
	 */
	public static void updateBookById() throws IOException {
		Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(reader);
		SqlSession  session = sqlSession.openSession();
		//�޸ĵĲ���
		Book book = new  Book();
		//�޸��Ǳ���
		book.setBookId(4);
		//�޸�Ϊʲô��
		book.setBookName("javaEE��ҵ����վ����");
		book.setBookPrice(196);
		
		BookMapper bookMapper = session.getMapper(BookMapper.class);
		bookMapper.updateBookById(book);
		session.commit();//�ύ����
		System.out.println("�޸ĳɹ�");
		session.close();
	}
	
	
	/**
	 *  @return
	 * ��ѯ����ѧ��
	 * 
	 */
	public  static void queryBookById() throws IOException {
				//���������ļ� Ϊ�˷������ݿ�
				Reader reader = Resources.getResourceAsReader("config.xml");
				SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				BookMapper  bookMapper = session.getMapper(BookMapper.class) ;
				Book book = bookMapper.queryBookById(2) ;//�ӿ��еķ��� �Զ��ҵ�SQL���
				
				/*��namespace+"select id="queryBookById" 
				String statment = "com.zc.mybaits.bookMapper.queryBookById";
				Book book = session.selectOne(statment,1)*/
						
						
				System.out.println(book);
				session.close();
	}
	/**
	 *  @return
	 * ��ѯȫ��ѧ��
	 */
	public  static void queryAllBook() throws IOException {
		//���������ļ� Ϊ�˷������ݿ�
				Reader reader = Resources.getResourceAsReader("config.xml");
				SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				/*��namespace+"select id="queryBookById" 
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
