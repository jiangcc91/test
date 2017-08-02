package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.domain.BaseDict;
import cn.itcast.mapper.BaseDictMapper;
import cn.itcast.service.BaseDictService;
@Service
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictMapper baseDictMapper;
	@Override
	public List<BaseDict> getPreList(String source) {
	
		return baseDictMapper.getPreList(source);
	}

}
