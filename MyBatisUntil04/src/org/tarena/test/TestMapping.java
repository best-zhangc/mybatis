package org.tarena.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.controller.EmpController;
import org.tarena.dao.DeptDao;
import org.tarena.dao.EmpDao;
import org.tarena.entity.Dept;
import org.tarena.entity.Emp;

/**
 * 测试Mybatis关联映射
 * @author zhangchao
 *
 */
public class TestMapping {
	/**
	 * 主键映射  新增一条数据
	 */
	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class) ;
		Emp emp = new Emp();
		emp.setEname("xiaoqiao");
		emp.setSal(200.0);
		emp.setAge(22);
		emp.setDeptno(10);
		System.out.println("****=" + emp.getEmpno());
		empDao.save(emp);
		System.out.println(emp.getEmpno());
	}
	
	/**
	 * 多对一嵌套查询映射
	 * 根据Id查询一条员工数据 并查询他所在的部门
	 */
	@Test
	public void test2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		Emp e = empDao.findById(3);
		System.out.println(e.getEmpno()+" "+e.getEname() + "" +
		e.getDept().getDeptno() + " " + e.getDept().getDname());
		}
	
	/**
	 * 多对一嵌套结果映射
	 * 根据Id 查询一条员工数据 并查询他所在的部门
	 */
	@Test
	public void test3() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		Emp e = empDao.findById2(3);
		System.out.println(e.getEmpno() + " " + e.getEname()+" "+
		e.getDept().getDeptno() + " " + e.getDept().getDname());
	}
	
	/**
	 * 一对多嵌套查询映射
	 * 查询部门及部门下所有员工
	 */
	@Test
	public void test4() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DeptDao deptDao = ctx.getBean("deptDao", DeptDao.class);
		Dept d = deptDao.findById(10);
		System.out.println(
				d.getDeptno()+"   " +
				d.getDname()+"   " +
				d.getLoc());
		List<Emp> emps = d.getEmps();
		for (Emp e : emps) {
			System.out.println(
					e.getEmpno()+"   " +
					e.getEname()+"   " +
					e.getSal()+"   " +
					e.getAge());
		}
	}
	
	@Test
	public void test5() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DeptDao deptDao = ctx.getBean("deptDao", DeptDao.class);
		Dept d = deptDao.findById2(20);
		System.out.println(
				d.getDeptno() +" " +
				d.getDname() +" " +
				d.getLoc());
		List<Emp> emps = d.getEmps();
		for (Emp e : emps) {
			System.out.println(
					e.getEmpno() +" "+
					e.getEname() +" " +
					e.getAge());
		}
	}
	
	@Test
	public void test6() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmpController empController = ctx.getBean("empController", EmpController.class);
		empController.find();
	}
}
