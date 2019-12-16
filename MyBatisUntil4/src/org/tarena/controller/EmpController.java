package org.tarena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 目标功能
 * @author zhangchao
 *
 */
@Controller
@RequestMapping("/emp/")
public class EmpController {
	
	/**
	 * 查询
	 */
	@RequestMapping("findEmp.do")
	public String find() {
		//模拟员工数据
		System.out.println("查询员工数据 ， 发送至列表页面");
		
		//异常
		//Integer.valueOf("abc") ;
		return "emp/list.jsp";
	}
}
