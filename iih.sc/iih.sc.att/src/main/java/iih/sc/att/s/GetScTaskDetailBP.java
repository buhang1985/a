package iih.sc.att.s;

import java.util.List;

import iih.sc.att.sctaskexec.d.SctaskexecDO;
import iih.sc.att.sctaskexecemp.d.ScTaskExecEmpDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 获取考勤计划明细
 * 
 * @author yanglu
 * @created by renying
 */
public class GetScTaskDetailBP {

	/**
	 * 获取考勤计划明细
	 * 
	 * @param dt_b
	 * @param dt_e
	 * @param taskexecCode
	 * @param attplId
	 * @return
	 * @throws BizException
	 */
	public ScTaskExecEmpDO[] exec(String dt_b, String dt_e, String taskexecCode, String taskplId) throws BizException {
		if (!StringUtil.isEmptyWithTrim(dt_b) && !StringUtil.isEmptyWithTrim(dt_e) && !StringUtil.isEmptyWithTrim(taskplId)) {
			SqlParam param = new SqlParam();
			StringBuffer sb = new StringBuffer();
			sb.append(" SELECT daysl.name as name_dateslot,daysl.time_begin,daysl.time_end,psn.code as code_emp,psn.name as name_emp,TAEXE.EU_TASK_STATUS,emp.* FROM sc_task_exec_emp emp");
			sb.append(" INNER JOIN sc_task_exec TAEXE on TAEXE.id_taskexec=EMP.id_taskexec");
			sb.append(" INNER JOIN BD_PSNDOC psn on psn.id_psndoc=emp.id_emp");
			sb.append(" INNER JOIN bd_dayslot daysl on daysl.id_dayslot=emp.id_dateslot");
			sb.append(" INNER JOIN SC_TASK_PL pl on pl.id_dateslotca=daysl.id_dayslotca AND taexe.id_taskpl=pl.id_taskpl");
			sb.append(" WHERE emp.D_TASK>=? AND emp.D_TASK<=?");
			sb.append(" AND emp.ID_TASKEXEC IN (SELECT ID_TASKEXEC FROM SC_TASK_EXEC WHERE ?<=D_E AND ?>=D_B AND id_taskpl=? ");
			String orgSql = EnvContextUtil.processEnvContext("", new SctaskexecDO(), "");
			sb.append(" and " + orgSql);
					
			sb.append(")");
			param.addParam(dt_b);
			param.addParam(dt_e);
			param.addParam(dt_b);
			param.addParam(dt_e);
			param.addParam(taskplId);

			List<ScTaskExecEmpDO> list = (List<ScTaskExecEmpDO>) new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(ScTaskExecEmpDO.class));
			return list.toArray(new ScTaskExecEmpDO[list.size()]);
		}
		return null;
	}

}
