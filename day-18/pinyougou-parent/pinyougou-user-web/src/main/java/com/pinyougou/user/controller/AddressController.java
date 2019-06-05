package com.pinyougou.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbAddress;
import com.pinyougou.user.service.AddressService;
import com.pinyougou.user.service.AreasService;
import entity.Result;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/addressController")
public class AddressController {

    @Reference
    private AddressService addressService;

    /**
     * 查询所有地址
     * @return
     */
    @RequestMapping("/findListByUserId")
    public List<TbAddress> findListByUserId(){
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        System.out.println("222  "+userId);
        List<TbAddress> listByUserId = addressService.findListByUserId(userId);
        for (TbAddress tbAddress : listByUserId) {
            String mobile = tbAddress.getMobile();
            String substring1 = mobile.substring(0,3);
            String substring2 = mobile.substring(7);
            tbAddress.setMobile(substring1+"****"+substring2);
            System.out.println(substring1+"****"+substring2);
        }
        return listByUserId;
    }

    @RequestMapping("/dele")
    public Result dele(Long id){
        Long[] ids = {id};
        try {
            addressService.delete(ids);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }

    }
    @RequestMapping("/add")
    public Result add(@RequestBody TbAddress address) {
        address.setIsDefault("0");
        address.setUserId(SecurityContextHolder.getContext().getAuthentication().getName());
        address.setCreateDate(new Date());
        try {
            addressService.add(address);
            return new Result(true,"增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"增加失败");
        }
    }

    @RequestMapping("/findOne")
    public TbAddress findOne( Long id) {
       return addressService.findOne(id);
    }


    @RequestMapping("/update")
    public Result update(@RequestBody TbAddress address){
        try {
            addressService.update(address);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }

    @RequestMapping("/updateDufault")
    public Result updateDufault(Long id,String status){
        TbAddress tbAddress = new TbAddress();
        tbAddress.setId(id);
        tbAddress.setIsDefault(status);
        try {
            addressService.updateDufault(tbAddress);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  new Result(false,"修改失败");
        }
    }


}
