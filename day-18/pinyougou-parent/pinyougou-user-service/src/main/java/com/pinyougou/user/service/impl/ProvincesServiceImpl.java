package com.pinyougou.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.TbProvincesMapper;
import com.pinyougou.pojo.TbProvinces;
import com.pinyougou.user.service.ProvincesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ProvincesServiceImpl implements ProvincesService {

	@Autowired
	private TbProvincesMapper provincesMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public Map findAllMap() {
		List<TbProvinces> tbProvinces = provincesMapper.selectByExample(null);
		Map map = new HashMap<String ,String>();
		for (TbProvinces province : tbProvinces) {
			String provinceid = province.getProvinceid();
			String province1 = province.getProvince();
			map.put(provinceid,province1);
		}
		return map;
	}

	/**
	 * 查询全部
	 */
	@Override
	public List<TbProvinces> findAll() {
		List<TbProvinces> tbProvinces = provincesMapper.selectByExample(null);
		return tbProvinces;
	}

	/**
	 * 按分页查询
	 *//*
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbProvinces> page=   (Page<TbProvinces>) provincesMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	*//**
	 * 增加
	 *//*
	@Override
	public void add(TbProvinces provinces) {
		provincesMapper.insert(provinces);		
	}

	
	*//**
	 * 修改
	 *//*
	@Override
	public void update(TbProvinces provinces){
		provincesMapper.updateByPrimaryKey(provinces);
	}	
	


*//**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 *//*

	@Override
	public TbProvinces findOne(Long id){
		int i = id.intValue();
		return provincesMapper.selectByPrimaryKey(i);
	}


	*//**
	 * 批量删除
	 *//*
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			int i = id.intValue();
			provincesMapper.deleteByPrimaryKey(i);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbProvinces provinces, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbProvincesExample example=new TbProvincesExample();
		Criteria criteria = example.createCriteria();
		
		if(provinces!=null){			
						if(provinces.getProvinceid()!=null && provinces.getProvinceid().length()>0){
				criteria.andProvinceidLike("%"+provinces.getProvinceid()+"%");
			}
			if(provinces.getProvince()!=null && provinces.getProvince().length()>0){
				criteria.andProvinceLike("%"+provinces.getProvince()+"%");
			}
	
		}
		
		Page<TbProvinces> page= (Page<TbProvinces>)provincesMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}*/
	
}
