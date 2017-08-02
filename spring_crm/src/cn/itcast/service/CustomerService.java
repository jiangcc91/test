package cn.itcast.service;

import cn.itcast.domain.Customer;
import cn.itcast.domain.QueryVo;
import cn.itcast.utils.Page;

public interface CustomerService {

	Page<Customer> getCustomerList(QueryVo queryvo);

	Customer getCustomer(Long id);

	void updateCustomer(Customer customer);

	void deleteCustomer(Long id);

}
