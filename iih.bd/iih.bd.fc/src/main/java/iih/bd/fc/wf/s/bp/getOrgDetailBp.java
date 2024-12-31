package iih.bd.fc.wf.s.bp;

import iih.bd.fc.wf.s.bp.qry.getOrgSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.orgfw.org.d.OrgDO;

public class getOrgDetailBp {

	/**
	 * 获取机构信息
	 * 
	 * @return
	 * @throws BizException
	 */
	public OrgDO exec(String Id_dep) throws BizException {

		// 1、校验
		if (StringUtil.isEmpty(Id_dep)) {
			return null;
		}

		// 2、获取部门
		DeptDO deptDO = getDepDO(Id_dep);

		// 3、获取机构
		OrgDO orgDO = getOrgDO(deptDO);

		return orgDO;
	}

	/**
	 * 获取部门DO
	 * 
	 * @param Id_dep
	 * @return
	 * @throws BizException
	 */
	private DeptDO getDepDO(String Id_dep) throws BizException {

		IDeptRService findService = ServiceFinder.find(IDeptRService.class);

		return findService.findById(Id_dep);
	}

	/**
	 * 获取机构
	 * 
	 * @param deptDO
	 * @return
	 * @throws BizException
	 */
	private OrgDO getOrgDO(DeptDO deptDO) throws BizException {

		if (deptDO != null && !StringUtil.isEmpty(deptDO.getId_org())) {

			getOrgSql Sql = new getOrgSql(deptDO.getId_org());

			OrgDO[] orgDOS = (OrgDO[]) AppFwUtil.getDORstWithDao(Sql, OrgDO.class);

			if (orgDOS != null && orgDOS.length > 0) {

				return orgDOS[0];
			}
		}
		return null;
	}
}
