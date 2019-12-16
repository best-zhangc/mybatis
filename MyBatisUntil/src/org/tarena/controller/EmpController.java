package org.tarena.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tarena.dao.EmpDao;
import org.tarena.entity.Emp;

@Controller
@RequestMapping("/emp/")
public class EmpController {
	@Resource
	private EmpDao empdao ;
	
	@RequestMapping("list.do")
	public String findAll(Model model) {
		List<Emp> list = empdao.findAll();
		model.addAttribute("emps", list);
		return "list";
		
	}
	
}
