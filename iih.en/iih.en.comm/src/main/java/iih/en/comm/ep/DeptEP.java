package iih.en.comm.ep;

import iih.en.comm.validator.EnValidator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 基础数据--部门EP
 * 
 * @author renying
 * @since 2017-4-7
 *
 */
public class DeptEP {

	/**
	 * 基础数据--部门EP
	 * 
	 * @author renying
	 * @since 2017-4-7
	 *
	 */
	public Map<String, DeptDO> getDeptMap(List<String> depIdList)  throws BizException{
		if (EnValidator.isEmpty(depIdList))
			return new HashMap<String, DeptDO>();
		IDeptRService rservice = ServiceFinder.find(IDeptRService.class);
		DeptDO[] deptdo = rservice.findByIds(depIdList.toArray(new String[0]), FBoolean.FALSE);
		
		 Map<String, DeptDO> depMap = new HashMap<String,DeptDO>();
		 for(DeptDO dept:deptdo){
			 if(depMap.containsKey(dept.getId_dep()))
				 continue;
			 depMap.put(dept.getId_dep(), dept);
		 }
		 return depMap;
	}
	/**
	 * 基础数据--部门EP
	 * @param depIdSet
	 * @author ltf
	 * @throws BizException
	 */
	public Map<String, DeptDO> getDeptMapSet(Set<String> depIdSet) throws BizException{
		if(depIdSet.size()==0 || depIdSet.isEmpty())
			return new HashMap<String, DeptDO>();
		IDeptRService rservice = ServiceFinder.find(IDeptRService.class);
		DeptDO[] deptdo = rservice.findByIds(depIdSet.toArray(new String[0]), FBoolean.FALSE);
		Map<String, DeptDO> depMap = new HashMap<String,DeptDO>();
		 for(DeptDO dept:deptdo){
			 if(depMap.containsKey(dept.getId_dep()))
				 continue;
			 depMap.put(dept.getId_dep(), dept);
		 }
		 return depMap;
	}
	/**
	 * 根据code获取科室
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public DeptDO getDeptByCode(String code) throws BizException{
		if(EnValidator.isEmpty(code))
			return null;
		IDeptRService rservice = ServiceFinder.find(IDeptRService.class);
		DeptDO[] depts = rservice.findByAttrValString(DeptDO.CODE, code);
		return EnValidator.isEmpty(depts) ? null : depts[0];
	}
	/**
	 * 根据id获取科室 zhangpp
	 * @param depId
	 * @return
	 * @throws BizException
	 */
	public DeptDO getDeptById(String depId) throws BizException{
		if(EnValidator.isEmpty(depId)){
			return null;
		}
		IDeptRService rservice = ServiceFinder.find(IDeptRService.class);
		return rservice.findById(depId);
	}
}
