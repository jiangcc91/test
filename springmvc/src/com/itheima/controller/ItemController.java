package com.itheima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itheima.domain.Items;
import com.itheima.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("list")
	public String showItemList(Model model){
		List<Items> itemList = itemService.getItemList();
		model.addAttribute("itemList", itemList);
		return "itemList";
		
	}
	
	@RequestMapping("itemEdit")
	public String itemEdit(Integer id , Model model){
		Items item = itemService.getItemById(id);
		model.addAttribute("item", item);
		return "editItem";
		
	}
	
	@RequestMapping("updateitem")
	public String updateitem(Items items){
		itemService.saveItem(items);
		System.out.println(items);
		return "success";
	}
	
	

}
