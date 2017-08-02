package com.itheima.service;

import com.itheima.domain.Customer;
import com.itheima.domain.QueryVo;
import com.itheima.utils.Page;

public interface CustomerService {

	Page<Customer> getCustomerBy(QueryVo queryVo);

	Customer getCustomer(Long id);

	void updateCustomer(Customer customer);

	void deleteCustomer(Long id);


}
