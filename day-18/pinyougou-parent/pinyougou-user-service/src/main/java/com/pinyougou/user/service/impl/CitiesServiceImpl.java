package com.pinyougou.user.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pinyougou.pojo.TbCitiesExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.TbCitiesMapper;
import com.pinyougou.pojo.TbCities;
import com.pinyougou.user.service.CitiesService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class CitiesServiceImpl implements CitiesService {

	@Autowired
	private TbCitiesMapper citiesMapper;

	/**
	 * 查询全部
	 */
	@Override
	public Map findAll() {
		List<TbCities> tbCities = citiesMapper.selectByExample(null);
		Map map = new HashMap();
		for (TbCities tbCity : tbCities) {
			map.put(tbCity.getCityid(),tbCity.getCity());
		}
		return map;
	}



	/*@Override
	public Map findOneMap(String id) {
		TbCitiesExample example = new TbCitiesExample();
		TbCitiesExample.Criteria criteria = example.createCriteria();
		criteria.andProvinceidEqualTo(id);
		List<TbCities> tbCities = citiesMapper.selectByExample(example);
		Map<String,String> map = new HashMap<>();
		for (TbCities tbCity : tbCities) {
			String cityid = tbCity.getCityid();
			String city = tbCity.getCity();
			map.put(cityid,city);
		}
		return map;
	}*/

	@Override
	public List<TbCities> findOne(String id) {
		TbCitiesExample example = new TbCitiesExample();
		TbCitiesExample.Criteria criteria = example.createCriteria();
		criteria.andProvinceidEqualTo(id);
		List<TbCities> tbCities = citiesMapper.selectByExample(example);
		return tbCities;
	}

	/*	*//**
	 * 按分页查询
	 *//*
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbCities> page=   (Page<TbCities>) citiesMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	*//**
	 * 增加
	 *//*
	@Override
	public void add(TbCities cities) {
		citiesMapper.insert(cities);		
	}

	
	*//**
	 * 修改
	 *//*
	@Override
	public void update(TbCities cities){
		citiesMapper.updateByPrimaryKey(cities);
	}	
	
	*//**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 *//*
	@Override
	public TbCities findOne(Long id){
		int i = id.intValue();
		return citiesMapper.selectByPrimaryKey(i);
	}

	*//**
	 * 批量删除
	 *//*
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			int i = id.intValue();
			citiesMapper.deleteByPrimaryKey(i);
		}		
	}*/
	
	
	/*@Override
	public PageResult findPage(TbCities cities, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbCitiesExample example=new TbCitiesExample();
		Criteria criteria = example.createCriteria();
		
		if(cities!=null){			
						if(cities.getCityid()!=null && cities.getCityid().length()>0){
				criteria.andCityidLike("%"+cities.getCityid()+"%");
			}
			if(cities.getCity()!=null && cities.getCity().length()>0){
				criteria.andCityLike("%"+cities.getCity()+"%");
			}
			if(cities.getProvinceid()!=null && cities.getProvinceid().length()>0){
				criteria.andProvinceidLike("%"+cities.getProvinceid()+"%");
			}
	
		}
		
		Page<TbCities> page= (Page<TbCities>)citiesMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}*/

}
