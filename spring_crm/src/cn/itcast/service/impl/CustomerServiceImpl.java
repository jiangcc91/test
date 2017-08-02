package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.domain.Customer;
import cn.itcast.domain.QueryVo;
import cn.itcast.mapper.CustomerMapper;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.Page;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	public Page<Customer> getCustomerList(QueryVo queryvo) {
		//计算queryvo start
		queryvo.setStart((queryvo.getPage()-1)*queryvo.getSize());
		
		List<Customer> list = customerMapper.getCustomerLst(queryvo);
		Page<Customer> page = new Page<>();
		page.setPage(queryvo.getPage());
		page.setRows(list);
		page.setSize(queryvo.getSize());
		page.setTotal(customerMapper.getCustomerCount(queryvo));
		return page;
	}

	@Override
	public Customer getCustomer(Long id) {
		
		return customerMapper.getCustomer(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerMapper.updateCustomer(customer);
		
	}

	@Override
	public void deleteCustomer(Long id) {
		customerMapper.deleteCustomer(id);
	}

}
