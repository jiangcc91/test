package com.itheima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.domain.Items;
import com.itheima.mapper.ItemsMapper;
import com.itheima.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<Items> getItemList() {
		return itemsMapper.selectByExample(null);
	}


	public Items getItemById(Integer id) {
		return itemsMapper.selectByPrimaryKey(id);
	}


	@Override
	public void saveItem(Items items) {
		itemsMapper.updateByPrimaryKeySelective(items);
	}
}
