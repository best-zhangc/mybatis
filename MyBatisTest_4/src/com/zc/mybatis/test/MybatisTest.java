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
	 * ���ͼ��
	 */
	public static void addBook() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
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
	 *  @return
	 * ���ͼ��
	 * ��ת���������
	 */
	public static void addBookWithConverter() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(reader);
			SqlSession  session = sqlSession.openSession();
		//String  stament = "com.zc.mybaits.bookMapper.addBook";
		Book book = new Book(5,"java���ļ���I",88,false);
		BookMapper bookMapper = session.getMapper(BookMapper.class);
		bookMapper.addBookWithConverter(book);
		session.commit();//�ύ����
		System.out.println("��ӳɹ�ͼ��");
		session.close();
	}
	
	
	/**
	 * @return
	 * ɾ��ͼ��
	 */
	public static void deleteBookById() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
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
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(reader);
		SqlSession  session = sqlSession.openSession();
		//�޸ĵĲ���
		Book book = new  Book();
		//�޸��Ǳ���
		book.setBookId(4);
		//�޸�Ϊʲô��
		book.setBookName("javaEE��ҵ����վ����");
		book.setBookPrice(248);
		
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
				Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				BookMapper  bookMapper = session.getMapper(BookMapper.class) ;
				Book book = bookMapper.queryBookById(1) ;//�ӿ��еķ��� �Զ��ҵ�SQL���
				
				/*��namespace+"select id="queryBookById" 
				String statment = "com.zc.mybaits.bookMapper.queryBookById";
				Book book = session.selectOne(statment,1)*/
						
						
				System.out.println(book);
				session.close();
	}
	
	/**
	 *  @return
	 * ��ѯ����ѧ��ByName(����)
	 * 
	 */
	public  static void queryBookBybookName() throws IOException {
				//���������ļ� Ϊ�˷������ݿ�
				Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				BookMapper  bookMapper = session.getMapper(BookMapper.class) ;
				Book book = bookMapper.queryBookBybookName("javaEE��ҵ����վ����") ;//�ӿ��еķ��� �Զ��ҵ�SQL���
				System.out.println(book);
				session.close();
	}
	
	/**
	 *  @return
	 * ��ѯ����ѧ��
	 * ʹ��ת����
	 */
	public  static void queryBookByIdWithConverter() throws IOException {
				//���������ļ� Ϊ�˷������ݿ�
				Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				BookMapper  bookMapper = session.getMapper(BookMapper.class) ;
				Book book = bookMapper.queryBookByIdWithConverter(2) ;//�ӿ��еķ��� �Զ��ҵ�SQL���		
				System.out.println(book);
				session.close();
	}
	
	/**
	 *  @return
	 * ��ѯȫ��ѧ��
	 */
	public  static void queryAllBook() throws IOException {
		//���������ļ� Ϊ�˷������ݿ�
				Reader reader = Resources.getResourceAsReader("conf.xml");
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
	/**
	 * ��ѯȫ�� ���Ҹ��ݼ۸�bookPrice������
	 * @return
	 * 
	 */
	public  static void queryBookOrderByBookColumn() throws IOException {
		//���������ļ� Ϊ�˷������ݿ�
				Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				BookMapper bookMapper = session.getMapper(BookMapper.class);
				List<Book> list = bookMapper.queryBookOrderByBookColumn("bookPrice");
				System.out.println(list);
				session.close();
	}
	
	/**
	 * ����������۸���в�ѯ
	 * @return
	 * 
	 */
	public  static void queryBookBybookPriceOrbookName() throws IOException {
		//���������ļ� Ϊ�˷������ݿ�
				Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				BookMapper bookMapper = session.getMapper(BookMapper.class);
				Book book = new Book();
				book.setBookName("��");
				book.setBookPrice(88);
				List<Book> list = bookMapper.queryBookBybookPriceOrbookName(book);
				System.out.println(list);
				session.close();
	}

	/**
	 * ����������۸���в�ѯ
	 * @return
	 * 
	 */
	public  static void queryBookByExplain() throws IOException {
		//���������ļ� Ϊ�˷������ݿ�
				Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				BookMapper bookMapper = session.getMapper(BookMapper.class);
				/*Explain explain = new Explain();
				explain.setBookCategory("����");
				explain.setBookDescription("���");
				List<Book> book = bookMapper.queryBookByExplain(explain);*/
				Book book1 = new Book();
				Explain explain = new Explain();
				explain.setBookCategory("����");
				explain.setBookDescription("���");
				book1.setExplain(explain);
				List<Book>  book= bookMapper.queryBookByExplain(book1);
				System.out.println(book);
				session.close();
	}

	
	
	public static void main(String[] args) throws IOException {
		
		//addBookWithConverter(); // ��� (��������ת����)
		//queryBookByIdWithConverter(); //��Id ��ѯ (��������ת����)
		//queryBookById();  //��Id ��ѯ 
		//queryBookBybookName(); //��Name ��ѯ
		//addBook(); //���ͼ��
		//deleteBookById(); // ɾ��ͼ��
		//queryAllBook(); // ��ѯȫ��ͼ��
		//updateBookById(); //�޸�ͼ��
		//queryBookOrderByBookColumn(); //���ݼ۸��������
		//queryBookBybookPriceOrbookName();//����������۸���в�ѯ
		queryBookByExplain();
	}

}
