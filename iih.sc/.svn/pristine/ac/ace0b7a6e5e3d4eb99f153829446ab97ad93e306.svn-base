package iih.sc.att.s.bp.qry;

import java.util.List;

import iih.sc.att.sctaskexec.d.SctaskexecDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 获取考勤计划
 * 
 * @author
 * @created by renying
 */
public class GetScTaskPlBP {

	/**
	 * 获取考勤计划
	 * 
	 * @param dt_b
	 * @param dt_e
	 * @param taskexecId
	 * @return
	 * @throws BizException
	 */
	public SctaskexecDO exec(String dt_b, String dt_e, String taskplId) throws BizException {
		if (!StringUtil.isEmptyWithTrim(dt_b) && !StringUtil.isEmptyWithTrim(dt_e) && !StringUtil.isEmptyWithTrim(taskplId)) {
			SqlParam param = new SqlParam();
			StringBuffer sb = new StringBuffer();
			sb.append(" SELECT cuser.name name_emp_chk,puser.name name_emp_create,pl.name name_taskpl,scp.name name_period,SCP.d_b d_period_b,scp.d_e d_period_e,dep.name name_dept,scexe.*");
			sb.append(" FROM sc_task_exec scexe");
			sb.append(" INNER JOIN BD_DEP dep on DEP.ID_DEP=SCEXE.ID_DEPT");
			sb.append(" INNER JOIN bd_sctask_peri SCP ON SCP.id_SCTASKPERI=scexe.id_period");
			sb.append(" INNER JOIN sc_task_pl pl on pl.id_taskpl=scexe.id_taskpl");
			sb.append(" LEFT JOIN SYS_USER puser on puser.id_user=scexe.id_emp_creator");
			sb.append(" LEFT JOIN SYS_USER cuser on cuser.id_user=scexe.id_emp_chk");
			sb.append(" WHERE ROWNUM=1 AND (?<=scexe.D_E AND ?>scexe.D_B) AND scexe.id_taskpl=?");
			String orgSql = EnvContextUtil.processEnvContext("", new SctaskexecDO(), "scexe");
			sb.append(" and " + orgSql);
			sb.append("  ORDER BY scexe.D_B");
			param.addParam(dt_b);
			param.addParam(dt_e);
			param.addParam(taskplId);
			param.addParam(Context.get().getOrgId());
			param.addParam(Context.get().getGroupId());
			List<SctaskexecDO> list = (List<SctaskexecDO>) new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(SctaskexecDO.class));
			if (list.size() == 1)
				return list.get(0);
		}
		return null;
	}
}
