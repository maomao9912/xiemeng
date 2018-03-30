package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.taotao.pojo.TbItem;
import com.taotao.service.Itemservice;

@Controller
//@RequestMapping("/item")
public class ItemController {
	@Autowired
	private Itemservice itemservice;
	
	@RequestMapping("/queryItems")
	public @ResponseBody ModelAndView  queryItems() throws Exception{
		TbItem tbItem=itemservice.selectByPrimaryKey(536563L);
		ModelAndView modelAndView  = new ModelAndView();
		modelAndView.addObject("tbItem", tbItem);
		modelAndView.setViewName("success");
		return modelAndView;
	}
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemId(@PathVariable Long itemId){
		TbItem tbItem=itemservice.selectByPrimaryKey(itemId);
		return tbItem;
	}
	
	
	
}
