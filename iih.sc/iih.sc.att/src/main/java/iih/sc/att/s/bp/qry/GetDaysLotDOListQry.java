package iih.sc.att.s.bp.qry;

import iih.sc.att.sctaskexec.d.SctaskexecDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetDaysLotDOListQry implements ITransQry {

	private SctaskexecDO[] sctaskexecDOs;

	public GetDaysLotDOListQry(SctaskexecDO[] sctaskexecDOs) {
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
		sb.append("SELECT * FROM bd_dayslot WHERE ");
		sb.append(" id_dayslotca in (SELECT id_dateslotca FROM sc_task_pl WHERE 1=1");

		if (sctaskexecDOs != null && sctaskexecDOs.length != 0) {
			sb.append(" and Id_taskpl in (");
			for (int i = 0; i < sctaskexecDOs.length; i++) {
				sb.append("?");
				if ((i + 1) != sctaskexecDOs.length) {
					sb.append(",");
				}
			}
			sb.append(")");
		}
		sb.append(")");
		return sb.toString();
	}

}
