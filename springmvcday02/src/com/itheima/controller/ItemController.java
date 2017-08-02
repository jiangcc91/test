package com.itheima.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.itheima.domain.Items;
import com.itheima.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value={"list","list1"},method={RequestMethod.GET})
	public String getItemList(Model model){
		int i = 1/0;
		List<Items> list = itemService.getItemList();
		model.addAttribute("itemList", list);
		return "itemList";
		
	}
	@RequestMapping("itemEdit")
	public String itemEdit(Integer id,Model model){
		
		Items items = itemService.getItemById(id);
		
		model.addAttribute("item", items);
		return "editItem";
	}
	@RequestMapping("updateitem")
	public String updateitem(Items items , MultipartFile pictureFile) throws Exception{
		//获取文件名
		String originalFilename = pictureFile.getOriginalFilename();
		//获取拓展名
		String extFile = originalFilename.substring(originalFilename.lastIndexOf("."));
		String fileName = UUID.randomUUID()+extFile;
		
		items.setPic(fileName);
		
		//将文件保存到磁盘
		pictureFile.transferTo(new File("D:/temp/"+fileName));
		//保存到数据库
		itemService.updateItems(items);
		
		return "forward:list.action";
		
	}
}
