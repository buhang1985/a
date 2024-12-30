package iih.sc.att.s.bp.qry;

import iih.sc.att.sctaskexec.d.SctaskexecDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据多个考勤计划编号获取考勤计划人员
 * 
 * @author yang.lu
 * 
 */
public class GetScTaskPlEmpDOListQry implements ITransQry {

	private SctaskexecDO[] sctaskexecDOs;

	public GetScTaskPlEmpDOListQry(SctaskexecDO[] sctaskexecDOs) {
		this.sctaskexecDOs = sctaskexecDOs;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO 自动生成的方法存根
		SqlParam param = new SqlParam();
		if (sctaskexecDOs != null && sctaskexecDOs.length != 0) {
			for (SctaskexecDO sctaskexecDO : sctaskexecDOs) {
				param.addParam(sctaskexecDO.getId_taskpl());
			}
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		// TODO 自动生成的方法存根
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT sc_task_pl_emp.*,sc_task_pl.ID_DATESLOTCA \"id_dateslotca\" FROM sc_task_pl_emp LEFT JOIN sc_task_pl on sc_task_pl_emp.ID_TASKPL=sc_task_pl.ID_TASKPL WHERE ");
		sb.append(" 1=1");
		if (sctaskexecDOs != null && sctaskexecDOs.length != 0) {
			sb.append(" and sc_task_pl_emp.Id_taskpl in (");
			for (int i = 0; i < sctaskexecDOs.length; i++) {
				sb.append("?");
				if ((i + 1) != sctaskexecDOs.length) {
					sb.append(",");
				}
			}
			sb.append(")");
		}
		return sb.toString();
	}

}
