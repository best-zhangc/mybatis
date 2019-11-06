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
	 * ���ѧ��
	 */
	public static void addBook() throws IOException {
		Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(reader);
			SqlSession  session = sqlSession.openSession();
		String  stament = "com.zc.mybaits.bookMapper.addBook";
		Book book = new Book(2,"java�������",269);
		int count = session.insert(stament, book);
		session.commit();//�ύ����
		System.out.println("���"+count+"��ͼ��");
		session.close();
	}
	
	/*
	 * ��ѯ����ѧ��
	 * 
	 * */
	public  static void queryBookById() throws IOException {
		//���������ļ� Ϊ�˷������ݿ�
				Reader reader = Resources.getResourceAsReader("config.xml");
				SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				//��namespace+"select id="queryBookById" 
				String statment = "com.zc.mybaits.bookMapper.queryBookById";
				Book book = session.selectOne(statment,1);
				System.out.println(book);
				session.close();
	}
	/*
	 * ��ѯȫ��ѧ��
	 */
	public  static void queryAllBook() throws IOException {
		//���������ļ� Ϊ�˷������ݿ�
				Reader reader = Resources.getResourceAsReader("config.xml");
				SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				//��namespace+"select id="queryBookById" 
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
