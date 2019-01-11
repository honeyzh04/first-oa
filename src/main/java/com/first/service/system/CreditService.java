/**
 * 
 */
package com.first.service.system;

import com.first.entity.CreditFormMap;

import java.util.HashMap;
import java.util.List;

public interface CreditService {
   CreditFormMap findUserCredit(String userId);
   List<CreditFormMap> findCredit(HashMap searchMap);
   void addCredit(CreditFormMap creditFormMap);

   void editCredit(HashMap searchMap);

   List<CreditFormMap> findCreditRecord(HashMap searchMap);

   void addCreditRecord(HashMap searchMap);

   List<CreditFormMap> findCreditOperation(HashMap searchMap);

   void editCreditOperation(CreditFormMap creditFormMap);
   void  editUserCredit(HashMap searchMap);
  int  findFollowCredit(String userId);
}

