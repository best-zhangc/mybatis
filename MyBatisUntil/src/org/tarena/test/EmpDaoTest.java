package org.tarena.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.dao.EmpDao;
import org.tarena.entity.Condition;
import org.tarena.entity.Emp;

public class EmpDaoTest {
	
	private String conf;

	@Test
	public void testFindAll() {
		conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		EmpDao empdao = ac.getBean("empDao" , EmpDao.class);
		List<Emp> list = empdao.findAll();
		for (Emp emp : list) {
			System.out.println(emp.getEmpno() +"  " + emp.getEname());	
		}
	}
	@Test
	public void testFindByDeptno() {
		conf = "applicationContext.xml" ;
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		EmpDao empDao = ac.getBean("empDao", EmpDao.class);
		Condition cond = new Condition();
		cond.setDeptno(10);
		List<Emp> list = empDao.findByDeptno(cond) ;
		for (Emp emp : list) {
			System.out.println(emp.getDeptno() +"  " + emp.getEname());
		}
	}
	
	@Test
	public void testFindBySal() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		Condition cond = new Condition();
		cond.setSal(6000.1);
		List<Emp> list = empDao.findBySal(cond);
		for (Emp emp : list) {
			System.out.println(emp.getEname()+" " + emp.getSal());
		}
	}
	
	@Test
	public void testFindByDeptAndSal() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		Condition cond = new Condition();
		cond.setDeptno(10);
		cond.setSal(6000.0);
		List<Emp> list = empDao.findByDeptAndSal(cond);
		for (Emp emp : list) {
			System.out.println(emp.getDeptno()+" "+emp.getEname() +" " + emp.getSal());	
		}
	}
	
	@Test
	public void testUpdate() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmpDao dao = ctx.getBean("empDao", EmpDao.class) ;
		Emp emp = new Emp();
		emp.setEmpno(10);
		emp.setEname("赵云");
		dao.update(emp);
		 System.out.println(emp.getDeptno() +" " + emp.getEname());
	}
	
	/**
	 * trim元素
	 * 查询
	 * @author zhangchao
	 */
	@Test
	public void testFindByDeptAndSal2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		Condition cond = new Condition();
		cond.setDeptno(10);
		cond.setSal(6000.0);
		List<Emp> list = empDao.findByDeptAndSal(cond);
		for (Emp emp : list) {
			System.out.println(emp.getDeptno() + " " + emp.getEname());
		}
	}
	
	/**
	 * 	trim元素
	 * 更新
	 * @author zhangchao
	 */
	@Test 
	public void testUpdate2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		Emp emp = new Emp();
		emp.setEmpno(7);
		emp.setEname("张良");
		emp.setAge(55);
		empDao.update2(emp);
		System.out.println(emp.getEname() + " " + emp.getAge());
	}
	
	/**
	 * 根据id查询员工
	 * @author zhangchao
	 */
	@Test
	public void testFindByIds() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(3);
		ids.add(6);
		ids.add(10) ;
		Condition cond = new Condition();
		cond.setEmpnos(ids);
		List<Emp> list = empDao.findByIds(cond);
		for (Emp emp : list) {
			System.out.println(emp.getEmpno() + " " +emp.getEname());
			
		}
		
	}
}
