package iih.ei.std.cr_technology.v1.s.bp.qry;

import java.util.List;

import iih.bd.base.utils.SqlUtils;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class PivasFindDgdtItemNewQry implements ITransQry {
    private List<String> code_ors;
	
	public PivasFindDgdtItemNewQry(List<String> code_ors) {
		this.code_ors = code_ors;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam Param = new SqlParam();
		Param.addParam(Context.get().getOrgId());
		Param.addParam(Context.get().getDeptId());
		return Param;
	}

	@Override
	public String getQrySQLStr() {
		return this._getQrySQLStr();
	}
	
	private String _getQrySQLStr() {
		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append(" select ");
		SqlStr.append(" dt.id_dgipap, ");
		SqlStr.append(" dt.id_dgipde, ");
		SqlStr.append(" dt.id_dgipdt, ");
		SqlStr.append(" dt.code_dgipap, ");
		SqlStr.append(" dt.id_or_pr_srv, ");
		SqlStr.append(" ap.id_dep_ap, ");
		SqlStr.append(" ap.sd_dgap, ");
		SqlStr.append(" dt.en_opap, ");
		SqlStr.append(" dt.en_opde, ");
		SqlStr.append(" dt.note, ");
		SqlStr.append(" dt.id_ent, ");
		SqlStr.append(" dt.id_pat, ");
		SqlStr.append(" pi_pat.name name_pat, ");
		SqlStr.append(" dt.quan_ap, ");
		SqlStr.append(" dt.price, ");
		SqlStr.append(" dt.note, ");
		SqlStr.append(" nvl(dt.fg_invalid, 'N') fg_invalid, ");
		SqlStr.append(" dt.id_or, ");
		SqlStr.append(" dt.id_orsrv, ");
		SqlStr.append(" dt.id_srv, ");
		SqlStr.append(" dt.name_srv, ");
		SqlStr.append(" ci_order.code_or, ");
		SqlStr.append(" ci_order.fg_long, ");
		SqlStr.append(" dt.id_mm, ");
		SqlStr.append(" dt.id_pkgu_ap, ");
		SqlStr.append(" dt.id_pkgu_base, ");
		SqlStr.append(" dt.id_pkgu_cur, ");
		SqlStr.append(" dt.Factor, ");
		SqlStr.append(" dt.dt_mp_plan, ");
		SqlStr.append(" prsrv.eu_su, ");
		SqlStr.append(" en_ent.fg_ip, ");
		SqlStr.append(" dt.ds, ");
		SqlStr.append(" dt.sv ");
		SqlStr.append(" from ");
		SqlStr.append(" mp_dg_ip_apde_dt dt ");
		SqlStr.append(" inner join mp_dg_ip_ap ap ");
		SqlStr.append(" on dt.id_dgipap = ap.id_dgipap ");
		SqlStr.append(" inner join mp_or_pr_srv prsrv ");
		SqlStr.append(" on dt.id_or_pr_srv = prsrv.id_or_pr_srv ");
		SqlStr.append(" inner join ci_order ");
		SqlStr.append(" on prsrv.id_or = ci_order.id_or ");
		SqlStr.append(" inner join en_ent ");
		SqlStr.append(" on dt.id_ent = en_ent.id_ent ");
		SqlStr.append(" left join pi_pat ");
		SqlStr.append(" on dt.id_pat = pi_pat.id_pat ");
		SqlStr.append(" where ap.id_org = ? ");
		SqlStr.append(" and ap.id_dep_wh = ? ");
		SqlStr.append(" and dt.quan_ap >= 0 ");
		SqlStr.append(" and " + SqlUtils.getInSqlByBigIds("ci_order.code_or", code_ors.toArray(new String[0])));
		SqlStr.append(" order by ci_order.code_or, dt.dt_mp_plan ");
		
		return SqlStr.toString();
	}
}
