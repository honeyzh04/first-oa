package com.first.mapper;

import com.first.entity.CustomerFormMap;
import com.first.entity.ExtendFormMap;
import com.first.entity.TeamAwardFormMap;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 客户操作
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年5月3日
   @version 1.00
 */
public interface CustomerMapper {
	
	/**
	 * 添加客户
	 * @param formMap
	 * @throws Exception
	 */
	public void addEntity(Object formMap) throws Exception;
	/**
	 * 添加到访客户
	 * @param formMap
	 * @throws Exception
	 */
	public void addVisit(Object formMap) throws Exception;
	/**
	 * 添加成交到访客户
	 * @param formMap
	 * @throws Exception
	 */
	public void addVisit1(Object formMap) throws Exception;

	/**
	 * 房发现客户具体来源
	 * @param formMap
	 * @throws Exception
	 */
	public void addSource(Object formMap) throws Exception;

	/**
	 * 添加成交
	 * @param formMap
	 * @throws Exception
	 */
	public void addDeal(Object formMap) throws Exception;
	/**
	 * 添加客户跟进信息
	 * @param formMap
	 * @throws Exception
	 */
	public void addFollow(Object formMap) throws Exception;
	/**
	 * 添加客户跟进信息至永久表
	 * @param formMap
	 * @throws Exception
	 */
	public void addLFollow(Object formMap) throws Exception;
	/**
	 * 添加客户扩展表
	 * @param formMap
	 * @throws Exception
	 */
	public void addExtend(Object formMap) throws Exception;
	/**
	 * 添加客户统计
	 * @param formMap
	 * @throws Exception
	 */
	public void addCu(Object formMap) throws Exception;

	/**
	 * 查看客户
	 * @param searchMapMap
	 * @return
	 */
	public List<CustomerFormMap> findCustomerPage( Map searchMapMap);
	/**
	 * 查看部门客户
	 * @param searchMapMap
	 * @return
	 */
	public List<CustomerFormMap> finddCustomerPage( Map searchMapMap);

	/**
	 * 查看所有客户
	 * @param searchMapMap
	 * @return
	 */
	public List<CustomerFormMap> findaCustomerPage( Map searchMapMap);

	/**
	 * 部门资源池查询客户
	 * @param searchMap
	 * @return
	 */
	public List<CustomerFormMap> findcCustomerPage( Map searchMap);

	/**
	 * 公司资源池查询客户
	 * @param searchMap
	 * @return
	 */
	public List<CustomerFormMap> findcAllPage( Map searchMap);
	/**
	 * 查询传入客户ID用户信息
	 * @param id
	 * @return
	 */
	public CustomerFormMap findbyeditUI(@Param("id")String id );
	/**
	 * 查询传入客户ID用户信息
	 * @param id
	 * @return
	 */
	public CustomerFormMap findbydiscardtUI(@Param("id")String id );


	/**
	 *转让客户
	 * @param formMap
	 * @throws Exception
	 */
	public void discardEntity(CustomerFormMap formMap) throws Exception;
	/**
	 * 客户跟进
	 * @param formMap
	 * @throws Exception
	 */
	public void editEntity(CustomerFormMap formMap) throws Exception;
	/**
	 * 客户删除
	 * @param id
	 */
	public void deleteEntity(@Param("id")String id ) ;
	public void deleteFollow(@Param("id")String id ) ;
	public void deletExtend(@Param("id")String id ) ;
	public void deletePreparation(@Param("id")String id ) ;
	

	/**
	 *添加客户报备信息
	 * @param formMap
	 * @throws Exception
	 */
	public void addpreEntity(Object formMap) throws Exception;
	/**
	 *定时客户调入部门公共池
	 *
	 * @throws Exception
	 */
	public void autobDiscard() throws Exception;
	/**
	 *定时客户调入公司公共池
	 *
	 * @throws Exception
	 */
	public void autoaDiscard() throws Exception;
	/**
	 *昨日跟进
	 *
	 * @throws Exception
	 */
	public void auto0Discard() throws Exception;
	/**
	 *一日未跟
	 *
	 * @throws Exception
	 */
	public void auto1Discard() throws Exception;
	/**
	 *2日未跟
	 *
	 * @throws Exception
	 */
	public void auto2Discard() throws Exception;
	/**
	 *3日未跟
	 *
	 * @throws Exception
	 */
	public void auto3Discard() throws Exception;
	/**
	 *4日未跟
	 *
	 * @throws Exception
	 */
	public void auto4Discard() throws Exception;
	/**
	 *5日未跟
	 *
	 * @throws Exception
	 */
	public void auto5Discard() throws Exception;
	/**
	 *6日未跟
	 *
	 * @throws Exception
	 */
	public void auto6Discard() throws Exception;
	/**
	 *6日未跟 共享客户
	 *
	 * @throws Exception
	 */
	public void auto6DiscardShare() throws Exception;

	/**
	 * 查询传入客户ID 扩展信息
	 * @param id
	 * @return
	 */
	public ExtendFormMap findbyExtend(@Param("id")String id );
	/**
	 * 客户扩展
	 * @param formMap
	 * @throws Exception
	 */
	public void editExtend(ExtendFormMap formMap) throws Exception;

	/**
	 * 房发现客户
	 * @param searchMapMap
	 * @return
	 */
	public List<CustomerFormMap> findffxCustomerPage( Map searchMapMap);
	/**
	 * 带访客户
	 * @param searchMapMap
	 * @return
	 */
	public List<CustomerFormMap> findvisitCustomerPage( Map searchMapMap);
    /**
     * 成交客户
     * @param searchMapMap
     * @return
     */
    public List<CustomerFormMap> finddealCustomerPage( Map searchMapMap);


	/**
	 * 项目匹配
	 * 
	   @author zhaoh
	 * @date 2018年8月2日
	   @version 1.00
	 * @param searchMapMap
	 * @return
	 */
	public List<CustomerFormMap> findcumatch( Map searchMapMap);
	/**
	 * 共享客户
	 * @param formMap
	 * @throws Exception
	 */
	public void shareEntity(CustomerFormMap formMap) throws Exception;
	/**
	 * 共享客户数据
	 * @param formMap
	 * @throws Exception
	 */
	public void share1Entity(CustomerFormMap formMap) throws Exception;
	/**
	 * 查看带访客户
	 * 
	   @author zhaoh
	 * @date 2018年8月15日
	   @version 1.00
	 * @param id
	 * @return
	 */
	public String findbyproject(@Param("id")String id );

	/**
	 * 项目匹配客户
	 * @param searchMapMap
	 * @return
	 */
	public List<CustomerFormMap> findMatchCustomer( Map searchMapMap);

    /**
     * 查看预约客户条数
     */

    CustomerFormMap  findNtrackDate( Map searchMapMap);

    /**
     * 查看预约客户
     * @param searchMapMap
     * @return
     */
    public List<CustomerFormMap>  findOrCustomer( Map searchMapMap);

	/**
	 * 查看指定客户
	 * @param id
	 * @return
	 */
	CustomerFormMap  findCustomer(@Param("id") String id);

    /**
     * 随机奖励客户
     * @param teamAwardFormMap
     * @return
     */
    public List<CustomerFormMap>  findAwardCustomer(TeamAwardFormMap teamAwardFormMap);

	public List<CustomerFormMap> getAwardCustomer(@Param("userId") String userId);

	public void modifCuEntity(Map forMap) throws Exception;

	/**
	 * 添加佣金分配
	 * @param formMap
	 * @throws Exception
	 */
	void addDealAllot(HashMap formMap) throws Exception;

	public  List<HashMap> finddealAllot(@Param("id")String id );

    public  List<HashMap> finddealUserAllot(@Param("id")String id );

     CustomerFormMap  addCumMtch(@Param("userId") String userId);

	/**
	 * 查看首录
	 * @param telephone
	 * @return
	 */
	CustomerFormMap  createUser(@Param("telephone") String telephone);

}
