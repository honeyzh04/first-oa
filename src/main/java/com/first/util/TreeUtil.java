package com.first.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.first.entity.DepartmentFormMap;

/**
 * 把一个list集合,里面的bean含有 parentId 转为树形式
 *
 */
public class TreeUtil {
	
    //获取管理部门
	static List<String> idss = new ArrayList<>();
	static List<String> idsa = new ArrayList<>();
	/**
	 * 递归获取本部门及下属部门
	 * 
	   @author zhaoh
	 * @date 2018年8月10日
	   @version 1.00
	 * @param menuList
	 * @param pid
	 * @return
	 */
    public static List<String> treeMenuList( List<DepartmentFormMap> menuList, int pid){  
    	  
        for(DepartmentFormMap mu: menuList){  
        	Object vlaues =mu.get("parentId");
        	String parentIds = vlaues.toString();
    		int parentId = Integer.parseInt(parentIds);
            //遍历出父id等于参数的id，add进子节点集合  
    	
    		  if(parentId==pid){  
                  //递归遍历下一级  
    			  Object vlaue =mu.get("id");
    	        	String ids = vlaue.toString();
    	    		int id = Integer.parseInt(ids);
    	    		System.err.println(id);
    	    		idss.add(ids);
    	    		
    	    		 
                  treeMenuList(menuList,id);  
                 
              }else {
            	  idsa.add("");
            	  }
    		  
        }  
        System.err.println(idss);
    return idss;  
    }  
	/**
	 * 根据父节点的ID获取所有子节点
	 * @param list 分类表
	 * @param typeId 传入的父节点ID
	 * @return String
	 */
	public List<TreeObject> getChildTreeObjects(List<TreeObject> list,int praentId) {
		List<TreeObject> returnList = new ArrayList<TreeObject>();
		for (Iterator<TreeObject> iterator = list.iterator(); iterator.hasNext();) {
			TreeObject t = (TreeObject) iterator.next();
			// 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
			if (t.getParentId().equals(praentId)) {
				recursionFn(list, t);
				returnList.add(t);
			}
		}
		return returnList;
	}
	
	/**
	 * 递归列表
	 * @param list
	 * @param t
	 */
	private void  recursionFn(List<TreeObject> list, TreeObject t) {
		List<TreeObject> childList = getChildList(list, t);// 得到子节点列表
		t.setChildren(childList);
		for (TreeObject tChild : childList) {
			if (hasChild(list, tChild)) {// 判断是否有子节点
				//returnList.add(TreeObject);
				Iterator<TreeObject> it = childList.iterator();
				while (it.hasNext()) {
					TreeObject n = (TreeObject) it.next();
					recursionFn(list, n);
				}
			}
		}
	}
	
	// 得到子节点列表
	private List<TreeObject> getChildList(List<TreeObject> list, TreeObject t) {
		
		List<TreeObject> tlist = new ArrayList<TreeObject>();
		Iterator<TreeObject> it = list.iterator();
		while (it.hasNext()) {
			TreeObject n = (TreeObject) it.next();
			if (n.getParentId().equals(t.getId())) {
				tlist.add(n);
			}
		}
		return tlist;
	} 
	List<TreeObject> returnList = new ArrayList<TreeObject>();
	/**
     * 根据父节点的ID获取所有子节点
     * @param list 分类表
     * @param typeId 传入的父节点ID
     * @param prefix 子节点前缀
     */
    public List<TreeObject> getChildTreeObjects(List<TreeObject> list, int typeId,String prefix){
        if(list == null) return null;
        for (Iterator<TreeObject> iterator = list.iterator(); iterator.hasNext();) {
            TreeObject node = (TreeObject) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (node.getParentId().equals(typeId)) {
                recursionFn(list, node,prefix);
            }
            // 二、遍历所有的父节点下的所有子节点
            /*if (node.getParentId()==0) {
                recursionFn(list, node);
            }*/
        }
        return returnList;
    }
     
    private void recursionFn(List<TreeObject> list, TreeObject node,String p) {
        List<TreeObject> childList = getChildList(list, node);// 得到子节点列表
        if (hasChild(list, node)) {// 判断是否有子节点
            returnList.add(node);
            Iterator<TreeObject> it = childList.iterator();
            while (it.hasNext()) {
                TreeObject n = (TreeObject) it.next();
                n.setName(p+n.getName());
                recursionFn(list, n,p+p);
            }
        } else {
            returnList.add(node);
        }
    }

	// 判断是否有子节点
	private boolean hasChild(List<TreeObject> list, TreeObject t) {
		return getChildList(list, t).size() > 0 ? true : false;
	}
	
	// 本地模拟数据测试
	public void main(String[] args) {
		/*long start = System.currentTimeMillis();
		List<TreeObject> TreeObjectList = new ArrayList<TreeObject>();
		
		TreeObjectUtil mt = new TreeObjectUtil();
		List<TreeObject> ns=mt.getChildTreeObjects(TreeObjectList,0);
		for (TreeObject m : ns) {
			System.out.println(m.getName());
			System.out.println(m.getChildren());
		}
		long end = System.currentTimeMillis();
		System.out.println("用时:" + (end - start) + "ms");*/
	}
	
}
