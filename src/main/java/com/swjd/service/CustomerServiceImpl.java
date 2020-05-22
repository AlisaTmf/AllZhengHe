package com.swjd.service;

import com.swjd.bean.Customer;
import com.swjd.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//通过注解创建实现类的对象
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerMapper customerMapper;//注入对象（利用Spring容器）
    @Override
    public List<Customer> getList() {
        return customerMapper.getAll();
    }
}
