package com.first.mapper;

import com.first.entity.CreditFormMap;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * 会员积分
 *
 * @ClassName: CreditMapper
 * @Description:
 * @Author: zhaoh
 * @CreateDate: 2018/11/29 17:22
 * @UpdateDate: 2018/11/29 17:22
 * @Version: 1.0
 */
public interface CreditMapper {

    CreditFormMap findUserCredit(@Param("userId") String userId);
    List<CreditFormMap>  findCredit(HashMap searchMap);

    void addCredit(CreditFormMap creditFormMap);

    void editCredit(HashMap searchMap);

    List<CreditFormMap> findCreditRecord(HashMap searchMap);

    void addCreditRecord(HashMap searchMap);

    List<CreditFormMap> findCreditOperation(HashMap searchMap);

    void editCreditOperation(CreditFormMap creditFormMap);

    int  findFollowCredit(@Param("userId") String userId);
}
