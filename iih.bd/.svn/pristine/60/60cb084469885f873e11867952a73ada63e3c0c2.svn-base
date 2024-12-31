package iih.bd.fc.s.bp;

import iih.bd.fc.mdwfor.d.MdWfOrDO;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import xap.mw.core.data.BizException;

/*
 * 获得执医嘱流向行科室信息操作BP
 */
public class GetExDept8WfOrArguBP {
	/**
	 * 获得执医嘱流向行科室信息
	 * @param wforinfo
	 * @return
	 * @throws BizException
	 */
	public OrWfExDeptDTO exec(MdWfOrDO wforinfo) throws BizException{
		if(wforinfo==null)return null;
		OrWfExDeptDTO rtn=new OrWfExDeptDTO();
		rtn.setId_org(wforinfo.getId_org());
		rtn.setCode_org(wforinfo.getOrg_code());
		rtn.setName_org(wforinfo.getOrg_name());
		rtn.setId_dept(wforinfo.getId_dept());
		rtn.setCode_dept(wforinfo.getDept_code());
		rtn.setName_dept(wforinfo.getDept_name());
		
		return rtn;
	}

}
