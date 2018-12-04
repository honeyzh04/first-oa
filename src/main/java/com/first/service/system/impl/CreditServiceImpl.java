/**
 *
 */
package com.first.service.system.impl;

import com.first.mapper.CreditMapper;
import com.first.service.system.CreditService;
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
public class CreditServiceImpl implements CreditService {
    @Inject
    private CreditMapper creditMapper;

}
	


	



