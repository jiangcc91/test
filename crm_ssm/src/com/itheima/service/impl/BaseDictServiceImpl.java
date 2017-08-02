package com.itheima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.domain.BaseDict;
import com.itheima.mapper.BaseDictMapper;
import com.itheima.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService {
	
	@Autowired
	private BaseDictMapper baseDictMapper;
	public List<BaseDict> getCustomerList(String source) {
		return baseDictMapper.getBaseDictListBy(source);
	}

}
