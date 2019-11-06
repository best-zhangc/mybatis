package com.zc.mybaits.mapper;

import java.util.List;

import com.zc.mybaits.Book;

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
	//��ѯȫ��
	List<Book> queryAllBook();
}
