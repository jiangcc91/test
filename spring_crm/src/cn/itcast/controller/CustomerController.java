package cn.itcast.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.domain.BaseDict;
import cn.itcast.domain.Customer;
import cn.itcast.domain.QueryVo;
import cn.itcast.service.BaseDictService;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.Page;

@Controller
@RequestMapping("/customer")
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
	public String showList(Model model , QueryVo queryvo) throws Exception{
		
		//客户名称模糊查询 , 解决乱码问题
		if(queryvo.getCustName()!=null && !"".equals(queryvo.getCustName())){
			//String custName = new String(queryvo.getCustName().getBytes("iso-8859-1"),"utf-8");
			//queryvo.setCustName(custName);
		}
		
		List<BaseDict> sourceList = baseDictService.getPreList(source);
		List<BaseDict> industryList = baseDictService.getPreList(industry);
		List<BaseDict> levelList = baseDictService.getPreList(level);
		
		model.addAttribute("fromType", sourceList);
		model.addAttribute("industryType", industryList);
		model.addAttribute("levelType", levelList);
		
		Page<Customer> page = customerService.getCustomerList(queryvo);
		model.addAttribute("page", page);
		return "customer";
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public Customer editCustomer(Long id){
		Customer customer = customerService.getCustomer(id);
		return customer;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public String updateCustomer(Customer customer){
		
		customerService.updateCustomer(customer);
		return "ok";
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public String deleteCustomer(Long id){
		customerService.deleteCustomer(id);
		return "ok";
	}
}
