package org.tarena.dao;


import org.tarena.annotation.MyBatisRepository;
import org.tarena.entity.Dept;
import org.tarena.entity.Emp;
@MyBatisRepository
public interface EmpDao {
	void save(Emp emp);
	//一对一 
	Emp findById(int empno	);
	Emp findById2(int empno) ;
}
