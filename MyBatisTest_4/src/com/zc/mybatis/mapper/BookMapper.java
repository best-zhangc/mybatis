package com.zc.mybatis.mapper;

import java.util.List;

import com.zc.mybatis.Book;
import com.zc.mybatis.Explain;

//����Mybaits�Ľӿ�
public interface BookMapper {
	/**
	 *	1.��������mapper.xml�ļ���ǩ�е�Idֵ��ͬ
	 * 2.���������������mapper.xml�ļ���ǩ�е�parameterType(parameterType="int") ����һ��
	 * 3.�����ķ���ֵ��mapper.xml�ļ���ǩ�е�resultType����һ��
	 */
	//���
	void  addBook(Book book) ;
	//ɾ��
	void deleteBookById(int bookId);
	//�޸�
	void updateBookById(Book book);
	//��Id��ѯ
	Book queryBookById(int bookId);
	//��������
	 Book queryBookBybookName(String bookName);
	//��ѯȫ��
	List<Book> queryAllBook();
	//��ѯȫ�� ���Ҹ�����������
	List<Book> queryBookOrderByBookColumn(String column);
	// ����������۸��ѯ
	List<Book> queryBookBybookPriceOrbookName(Book book);
	//�������ͻ����ѯ 
	List<Book> queryBookByExplain(Book explain);
	//ʹ����ת������
	Book queryBookByIdWithConverter(int bookId);
	//���
	void  addBookWithConverter(Book book) ;
}
