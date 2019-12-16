package org.tarena.dao;

import org.tarena.annotation.MyBatisRepository;
import org.tarena.entity.Dept;

@MyBatisRepository
public interface DeptDao {
	//一对多
	Dept findById(int deptno) ;
	Dept findById2(int deptno);
}
