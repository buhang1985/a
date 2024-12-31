package iih.ei.std.s.v1.bp.mp.pivas;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

public class InitContextBp {
	
	public void exec(String deptCode) throws BizException {
		DeptDO dept = findDeptByCode(deptCode);

		Context.get().setGroupId(dept.getId_grp());
		Context.get().setOrgId(dept.getId_org());
		Context.get().setDeptId(dept.getId_dep());
	}

	private DeptDO findDeptByCode(String deptCode) throws BizException {

		if (StringUtils.isEmpty(deptCode)) {
			throw new BizException("科室编码不允许为空。");
		}

		IDeptRService deptRService = ServiceFinder.find(IDeptRService.class);
		DeptDO[] depts = deptRService.findByAttrValString(DeptDO.CODE, deptCode);
		if (depts == null || depts.length <= 0) {
			String msg = String.format("根据科室编码\"%s\"未获取到科室信息。", deptCode);
			throw new BizException(msg);
		}
		if (depts.length != 1) {
			String msg = String.format("根据科室编码\"%s\"获取到多个科室信息。", deptCode);
			throw new BizException(msg);
		}
		return depts[0];
	}
	
	/**
	 * 获取收费人员
	 * 
	 * @throws BizException
	 */
	public String getPsndocDO(String operCode) throws BizException {
		if(StringUtils.isBlank(operCode))
			return Context.get().getStuffId();
		IPsndocMDORService docRSrv = ServiceFinder.find(IPsndocMDORService.class);
		String whrStr = String.format("id_psndoc = '%s' or code = '%s'", operCode, operCode);
		PsnDocDO[] psnDO = docRSrv.find(whrStr, "", FBoolean.TRUE);
		if(psnDO == null || psnDO.length <= 0)
			return Context.get().getStuffId();
		Context.get().setStuffId(psnDO[0].getId_psndoc());
		return psnDO[0].getId_psndoc();
	}
}
