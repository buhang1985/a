package iih.sc.att.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetSctaskexecQry implements ITransQry {

	String id_period = "";
	String id_taskpl = "";

	public GetSctaskexecQry(String id_period, String id_taskpl) {
		// TODO 自动生成的构造函数存根
		this.id_period = id_period;
		this.id_taskpl = id_taskpl;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO 自动生成的方法存根
		SqlParam param = new SqlParam();
		if (this.id_period != null && this.id_period != "") {
			param.addParam(this.id_period);
		}
		if (this.id_taskpl != null && this.id_taskpl != "") {
			param.addParam(this.id_taskpl);
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM sc_task_exec WHERE ");
		sb.append(" 1=1");
		if (this.id_period != null && this.id_period != "")
			sb.append(" and id_period=?");
		if (this.id_taskpl != null && this.id_taskpl != "")
			sb.append(" and id_taskpl=?");
		return sb.toString();
	}

}
