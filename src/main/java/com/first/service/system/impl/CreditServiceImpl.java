/**
 *
 */
package com.first.service.system.impl;

import com.first.entity.CreditFormMap;
import com.first.mapper.CreditMapper;
import com.first.service.system.CreditService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

    @Override
    public CreditFormMap findUserCredit(String userId) {

        return creditMapper.findUserCredit(userId);
    }

    @Override
    public  List<CreditFormMap> findCredit(HashMap searchMap) {
        return creditMapper.findCredit(searchMap);
    }

    @Override
    public void addCredit(CreditFormMap creditFormMap) {
        creditMapper.addCredit(creditFormMap);
    }

    @Override
    public void editCredit(HashMap searchMap) {
        creditMapper.editCredit(searchMap);
    }

    @Override
    public List<CreditFormMap> findCreditRecord(HashMap searchMap) {
        return creditMapper.findCreditRecord(searchMap);
    }

    @Override
    public void addCreditRecord(HashMap searchMap) {
        creditMapper.addCreditRecord(searchMap);
    }



    @Override
    public List<CreditFormMap> findCreditOperation(HashMap searchMap) {
        return creditMapper.findCreditOperation(searchMap);
    }

    @Override
    public void editCreditOperation(CreditFormMap creditFormMap) {

    }
    @Override

    public void editUserCredit(HashMap searchMap) {
        if (searchMap.get("type")==null){
            List<CreditFormMap> creditFormMap = findCreditOperation(searchMap);  //查看操作类型
            if (creditFormMap.size() != 0) {
                CreditFormMap a = creditFormMap.get(0);
                System.err.println(a);
                searchMap.putAll(a);
                searchMap.put("createDate",new Date());
                addCreditRecord(searchMap);
                editCredit(searchMap);
            } else {
                searchMap.put("createDate",new Date());
                addCreditRecord(searchMap);
                editCredit(searchMap);
            }
        }else if(searchMap.get("type").equals("1")){
            searchMap.put("createDate",new Date());
            addCreditRecord(searchMap);
            editCredit(searchMap);
        }

    }

    @Override
    public int findFollowCredit(String userId) {
        return creditMapper.findFollowCredit(userId);
    }

}
	


	



