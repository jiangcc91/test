package com.itheima.service;

import java.util.List;

import com.itheima.domain.Items;

public interface ItemService {

	List<Items> getItemList();

	Items getItemById(Integer id);

	void updateItems(Items items);

}
