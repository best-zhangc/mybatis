package org.tarena.dao;

import java.util.List;

import org.tarena.annotation.MyBatisRepository;
import org.tarena.entity.Condition;
import org.tarena.entity.Emp;
@MyBatisRepository
public interface EmpDao {
	public List<Emp> findAll() ;
	List<Emp> findByDeptno(Condition cond) ;
	List<Emp> findBySal(Condition cond) ;
	List<Emp> findByDeptAndSal(Condition cond);
	void update(Emp emp);
	List<Emp> findByDeptAndSal2(Condition cond);
	void update2(Emp emp) ;
	List<Emp> findByIds(Condition cond);
	
}
