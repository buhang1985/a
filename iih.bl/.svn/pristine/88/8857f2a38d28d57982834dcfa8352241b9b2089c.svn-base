package iih.bl.st.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获得住院患者指定时间段内的的结算与发票信息（汇总）
 * 
 * @author xb
 *
 */
public class QryIpStVsIncMergeDTO implements ITransQry {

	String id_pat;
	String id_ent;
	String dt_b;
	String dt_e;

	/*
	 * 获取退款调入时的相关收款数据
	 */
	public QryIpStVsIncMergeDTO(String id_pat, String id_ent, String dt_b, String dt_e) {

		this.id_pat = id_pat;
		this.id_ent = id_ent;
		this.dt_b = dt_b;
		this.dt_e = dt_e;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (id_pat != null)
			param.addParam(this.id_pat);
		if (id_ent != null)
			param.addParam(this.id_ent);
		if (dt_b != null)
			param.addParam(this.dt_b);
		if (dt_e != null)
			param.addParam(this.dt_e);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();

		boolean bParamsIsNull = true;
		sql.append("select st.id_stip id_stoep, ");
		sql.append("       inc.id_incip, ");
		sql.append("       st.dt_st, ");
		sql.append("       st.code_st, ");
		sql.append("       inc.incno, ");
		sql.append("       st.id_hp, ");
		sql.append("       st.id_patca, ");
		sql.append("       to_char(wm_concat(distinct payitm.id_pm)) id_pm, ");
		sql.append("       to_char(wm_concat(distinct pm.name)) name_pm, ");
		sql.append("       sum(payitm.amt * payitm.eu_direct) amt ");
		sql.append("  from bl_st_ip st ");
		sql.append(" inner join bl_inc_ip inc ");
		sql.append("    on st.id_stip = inc.id_stip ");
		sql.append(" inner join bl_pay_pat_ip pay ");
		sql.append("    on pay.id_stip = st.id_stip ");
		sql.append(" inner join bl_pay_itm_pat_ip payitm ");
		sql.append("    on payitm.id_paypatip = pay.id_paypatip ");
		sql.append(" inner join bd_pri_pm pm ");
		sql.append("    on payitm.id_pm = pm.id_pm ");
		sql.append(" where 1 = 1 ");

		if (id_pat != null) {
			sql.append(" AND st.ID_PAT=?");
			bParamsIsNull = false;
		}
		if (id_ent != null) {
			sql.append(" AND st.ID_ENT=?");
			bParamsIsNull = false;
		}
		if (dt_b != null) {
			sql.append(" AND st.DT_ST >= TO_CHAR(?)");
			bParamsIsNull = false;
		}
		if (dt_e != null) {
			sql.append(" AND st.DT_ST <= TO_CHAR(?)");
			bParamsIsNull = false;
		}
		
		sql.append(" AND inc.FG_CANC = 'N' and nvl(st.id_cc, '~') = '~'");

		if (bParamsIsNull) {
			// 如果没有有效参数传入，写入结果为假的条件，防止全表数据扫描
			sql.append(" AND 1=2 ");
		}

		sql.append(" AND st.EU_DIRECT='1'");
		sql.append(" AND st.FG_CANC ='N'");
		sql.append(" group by st.id_hp, ");
		sql.append("          st.id_patca, ");
		sql.append("          st.id_stip, ");
		sql.append("          inc.id_incip, ");
		sql.append("          st.dt_st, ");
		sql.append("          st.code_st, ");
		sql.append("          inc.incno ");
		sql.append(" ORDER BY st.DT_ST DESC, inc.INCNO ASC ");
		return sql.toString();

	}

}
