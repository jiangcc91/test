package cn.itcast.mapper;

import java.util.List;

import cn.itcast.domain.Customer;
import cn.itcast.domain.QueryVo;

public interface CustomerMapper {

	List<Customer> getCustomerLst(QueryVo queryvo);

	int getCustomerCount(QueryVo queryvo);

	Customer getCustomer(Long id);

	void updateCustomer(Customer customer);

	void deleteCustomer(Long id);


}
