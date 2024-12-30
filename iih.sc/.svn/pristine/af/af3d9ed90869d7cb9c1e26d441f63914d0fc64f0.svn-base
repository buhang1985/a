package iih.sc.sch.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetMtSchDetailDTOSql implements ITransQry {

	private String id_sch;

	public GetMtSchDetailDTOSql(String id_sch) {
		this.id_sch = id_sch;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(this.id_sch);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();

		sb.append(" select ");
		sb.append(" id_sch,");
		sb.append(" scpolcn,");
		sb.append(" quan_total,");
		sb.append(" quan_total_chkin,");
		sb.append(" quan_total_appt,");
		sb.append(" quan_total_used,");
		sb.append(" t_b_acpt,");
		sb.append(" t_e_acpt,");
		sb.append(" t_e_reg,");
		sb.append(" sugest_exmint,");
		sb.append(" sugest_num_tick,");
		sb.append(" sugest_num_mint,");
		sb.append(" srvslot,");
		sb.append(" fg_std_acpt ");
		sb.append(" from ");
		sb.append(" sc_sch ");
		sb.append(" WHERE ");
		sb.append(" id_sch=? ");

		return sb.toString();
	}

}
