package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.service.Itemservice;

/*商品管理Service*/
@Service
public class ItemserviceImple implements Itemservice{
	
	@Autowired
	private TbItemMapper tbItemMapper;
	
	public TbItem selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		//TbItem item = tbItemMapper.selectByPrimaryKey(id);
		
		TbItemExample example = new TbItemExample();
		//添加查询条件
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		List<TbItem> list =tbItemMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			TbItem tbItem = list.get(0);
			return tbItem;
		}
		return null;
	}

}
