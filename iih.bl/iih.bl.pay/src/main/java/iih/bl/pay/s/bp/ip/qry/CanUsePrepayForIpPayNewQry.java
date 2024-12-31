package iih.bl.pay.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CanUsePrepayForIpPayNewQry implements ITransQry {

	String entId;

	public CanUsePrepayForIpPayNewQry(String entId) {
		this.entId = entId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(this.entId);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("select                                             ");
		sql.append("  pre.id_paypat,                                   ");
		sql.append("  pre.id_pat,                                      ");
		sql.append("  pre.id_ent,                                      ");
		sql.append(" pre.id_pm, ");
		sql.append("  pre.sd_pm,                                       ");
		sql.append("  pm.name name_pm,                                         ");
		sql.append("  pre.paymodenode,                                 ");
		sql.append("  pre.amt,                                         ");
		sql.append("  pre.code_rep,                                    ");
		sql.append("  pre.sd_paytp,                                    ");
		sql.append("  pre.id_paytp                                     ");
		sql.append("  from bl_prepay_pat pre                           ");
		sql.append("  left join bd_pri_pm pm on pm.id_pm=pre.id_pm     ");
		sql.append(" where fg_canc = 'N'                               ");
		sql.append("   and fg_rep_return = 'N'                         ");
		sql.append("   and eu_direct = 1                               ");
		sql.append("   and id_ent = ?                                  ");
		
		return sql.toString();
	}

}
