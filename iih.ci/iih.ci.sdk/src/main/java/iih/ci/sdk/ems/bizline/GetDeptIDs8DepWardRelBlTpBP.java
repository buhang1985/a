package iih.ci.sdk.ems.bizline;

import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 根据科室与病区关系业务线类型
 * 获得病区或科室对应的部门主键集合信息操作BP
 * 这个内容最终应调整到BD资源模块中
 */
public class GetDeptIDs8DepWardRelBlTpBP {
	/**
	 * 根据科室与病区关系业务线类型
	 * 获得病区或科室对应的部门主键集合信息
	 * @param id_org
	 * @param id_dep_src
	 * @param issrcward
	 * @return
	 * @throws BizException
	 */
	public String[] exec(String id_org,String id_dep_src,FBoolean issrcward)  throws BizException{
		//有效性校验
		if(!validateCheck(id_org,id_dep_src))return null;
		
		//获得查询sql串
		String sql=BizLineHelper.getSqlPart4DeptWardRel(id_org,id_dep_src,issrcward);;
		
		//获得查询结果 sql
		String[] id_deps= new GetSingleFldValuesBP().exec(sql);	
		
		//返回值
		return id_deps;
	}
	
	/**
	 * 有效性校验
	 * @param id_org
	 * @param id_ward
	 * @return
	 */
	private boolean validateCheck(String id_org,String id_ward){
		if(ObjectUtils.isEmpty(id_org) || ObjectUtils.isEmpty(id_ward))return false;
		return true;
	}
}
