/**
 * 
 */
package com.first.service.system;

import com.first.entity.CustomerFormMap;
import org.apache.ibatis.annotations.Param;

public interface CustomerService {
   CustomerFormMap createUser(@Param("telephone") String telephone);
}

