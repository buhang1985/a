package iih.sc.att.s.bp.qry;

import iih.sc.att.sctaskexec.d.SctaskexecDO;
import iih.sc.att.sctaskexec.refs.Sctaskexec;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 
 * @author
 * @created by renying
 */
public class GetExecDeptBP {
	/**
	 * 获取考勤科室记录树
	 * 
	 * @return
	 * @throws BizException
	 */
	public DeptDO[] exec() throws BizException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from bd_dep where ");
		sb.append("id_dep in (SELECT id_dept from sc_task_exec where Eu_task_status <> '-1'");
		String orgSql = EnvContextUtil.processEnvContext("", new SctaskexecDO(), "");
		sb.append(" and " + orgSql);
		sb.append("	) ");
		List<DeptDO> list = (List<DeptDO>) new DAFacade().execQuery(sb.toString(), new BeanListHandler(DeptDO.class));
		if (list == null || list.size() == 0)
			return null;
		return list.toArray(new DeptDO[list.size()]);
	}

}
