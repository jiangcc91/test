package com.itheima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.domain.BaseDict;
import com.itheima.domain.Customer;
import com.itheima.domain.QueryVo;
import com.itheima.service.BaseDictService;
import com.itheima.service.CustomerService;
import com.itheima.utils.Page;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Value("${typecode.source}")
	private String source;
	@Value("${typecode.industry}")
	private String industry;
	@Value("${typecode.level}")
	private String level;
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BaseDictService baseDictService;
	
	@RequestMapping("list")
	public String showCustomerList(Model model,QueryVo queryVo){
		
		List<BaseDict> sourceList = baseDictService.getCustomerList(source);
		List<BaseDict> industryList = baseDictService.getCustomerList(industry);
		List<BaseDict> levelList = baseDictService.getCustomerList(level);
		model.addAttribute("fromType", sourceList);
		model.addAttribute("industryType", industryList);
		model.addAttribute("levelType", levelList);
		
		Page<Customer> page = customerService.getCustomerBy(queryVo);
		model.addAttribute("page", page);
		return "customer";
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public Customer edit(Long id,Model model){
		
		Customer customer = customerService.getCustomer(id);
		return customer;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public String update(Customer customer){
		
		customerService.updateCustomer(customer);
		return "ok";
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public String delete(Long id){
		
		customerService.deleteCustomer(id);
		return "ok";
	}
}
