package iih.bd.fc.s.bp;

import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.pub.BdFcAppUtils;
import iih.bd.fc.pub.BdFcUtils;
import xap.mw.core.data.BizException;
import xap.sys.orgfw.dept.d.DeptDO;

/*
 * 根据部门Id计算出执行部门信息操作BP
 */
public class GetExDeptInfo8DepIdBP {
	/**
	 * 根据部门Id计算出执行部门信息
	 * @param id_dept
	 * @return
	 * @throws BizException
	 */
	public OrWfExDeptDTO exec(String id_dept) throws BizException{
		if(BdFcUtils.isEmpty(id_dept))return null;
		DeptDO do1=BdFcAppUtils.getDeptQryService().findById(id_dept);
		return dept2OrWfExDeptInfo(do1);
	}
	
	/**
	 * 创建流向科室信息
	 * @param do1
	 * @return
	 * @throws BizException
	 */
	private OrWfExDeptDTO dept2OrWfExDeptInfo(DeptDO do1) throws BizException{
		if(do1==null)return null;
		OrWfExDeptDTO rtn=new OrWfExDeptDTO();
		rtn.setId_org(do1.getId_org());
		rtn.setCode_org(do1.getOrg_code());
		rtn.setName_org(do1.getOrg_name());
		rtn.setId_dept(do1.getId_dep());
		rtn.setCode_dept(do1.getCode());
		rtn.setName_dept(do1.getName());
		
		return rtn;
	}
	
}
