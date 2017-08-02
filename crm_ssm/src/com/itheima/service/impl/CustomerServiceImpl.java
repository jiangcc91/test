package com.itheima.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.domain.Customer;
import com.itheima.domain.QueryVo;
import com.itheima.mapper.CustomerMapper;
import com.itheima.service.CustomerService;
import com.itheima.utils.Page;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	public Page<Customer> getCustomerBy(QueryVo queryVo) {
		queryVo.setStart((queryVo.getPage()-1)*queryVo.getSize());
		Page<Customer> page = new Page<>();
		page.setPage(queryVo.getPage());
		page.setRows(customerMapper.getCustomerList(queryVo));
		page.setSize(queryVo.getSize());
		page.setTotal(customerMapper.getCustomerCount(queryVo));
		
		return page;
	}
	@Override
	public Customer getCustomer(Long id) {
		// TODO Auto-generated method stub
		return customerMapper.getCustomerBy(id);
	}
	@Override
	public void updateCustomer(Customer customer) {
		customerMapper.updateCustomerBy(customer);
		
	}
	@Override
	public void deleteCustomer(Long id) {
		customerMapper.deleteCustomerBy(id);
		
	}

	
}
