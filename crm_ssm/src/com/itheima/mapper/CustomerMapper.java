package com.itheima.mapper;

import com.itheima.domain.Customer;
import com.itheima.domain.CustomerExample;
import com.itheima.domain.QueryVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    int countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Long custId);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Long custId);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

	List<Customer> getCustomerList(QueryVo queryVo);

	int getCustomerCount(QueryVo queryVo);

	Customer getCustomerBy(Long id);

	void updateCustomerBy(Customer customer);

	void deleteCustomerBy(Long id);
}