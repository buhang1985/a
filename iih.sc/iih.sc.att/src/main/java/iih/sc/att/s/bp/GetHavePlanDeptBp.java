package iih.sc.att.s.bp;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 获取存在考勤计划的部门
 * 
 * @author ccj
 *
 */
public class GetHavePlanDeptBp {
	/**
	 * 获取存在考勤计划的部门
	 * 
	 * @return 部门arrays
	 * @throws BizException
	 */
	public DeptDO[] exec() throws BizException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from bd_dep where ");
		sb.append("id_dep in (select distinct id_dep from sc_task_pl where fg_active='2' ");
		String orgSql = EnvContextUtil.processEnvContext("", new DeptDO(), "");
		sb.append(" and " + orgSql);
		
		sb.append("	 ) ");
		List<DeptDO> list = (List<DeptDO>) new DAFacade().execQuery(
				sb.toString(), new BeanListHandler(DeptDO.class));
		if (list == null || list.size() == 0)
			return null;
		return list.toArray(new DeptDO[list.size()]);
	}
}
