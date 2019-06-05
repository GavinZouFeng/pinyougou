package com.pinyougou.user.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbAreasMapper;
import com.pinyougou.pojo.TbAreas;
import com.pinyougou.pojo.TbAreasExample;
import com.pinyougou.pojo.TbAreasExample.Criteria;
import com.pinyougou.user.service.AreasService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class AreasServiceImpl implements AreasService {

	@Autowired
	private TbAreasMapper areasMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbAreas> findAll(String id) {
        System.out.println(id);
		TbAreasExample example = new TbAreasExample();
		Criteria criteria = example.createCriteria();
		criteria.andCityidEqualTo(id);
		return areasMapper.selectByExample(example);
	}

    @Override
    public Map<String, String> findTownMap() {
        List<TbAreas> tbAreas = areasMapper.selectByExample(null);
        Map map = new HashMap();
        for (TbAreas tbArea : tbAreas) {
            map.put(tbArea.getAreaid(),tbArea.getArea());
        }
        return map;
    }

    /**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbAreas> page=   (Page<TbAreas>) areasMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbAreas areas) {
		areasMapper.insert(areas);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbAreas areas){
		areasMapper.updateByPrimaryKey(areas);
	}	
	



	
	
		@Override
	public PageResult findPage(TbAreas areas, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbAreasExample example=new TbAreasExample();
		Criteria criteria = example.createCriteria();
		
		if(areas!=null){			
						if(areas.getAreaid()!=null && areas.getAreaid().length()>0){
				criteria.andAreaidLike("%"+areas.getAreaid()+"%");
			}
			if(areas.getArea()!=null && areas.getArea().length()>0){
				criteria.andAreaLike("%"+areas.getArea()+"%");
			}
			if(areas.getCityid()!=null && areas.getCityid().length()>0){
				criteria.andCityidLike("%"+areas.getCityid()+"%");
			}
	
		}
		
		Page<TbAreas> page= (Page<TbAreas>)areasMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
