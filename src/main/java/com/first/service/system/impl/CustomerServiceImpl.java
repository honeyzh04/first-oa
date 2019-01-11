/**
 *
 */
package com.first.service.system.impl;

import com.first.entity.CustomerFormMap;
import com.first.mapper.CustomerMapper;
import com.first.service.system.CustomerService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
     *
     * @ClassName:      CreditServiceImpl
     * @Description:
     * @Author:         zhaoh
     * @CreateDate:     2018/11/29 17:21
     * @UpdateDate:     2018/11/29 17:21
     * @Version:        1.0
     */
@Service
public class
CustomerServiceImpl implements CustomerService {
    @Inject
    private CustomerMapper customerMapper;
    @Override
    public CustomerFormMap createUser(String telephone) {
        return customerMapper.createUser(telephone);
    }
}
	


	



