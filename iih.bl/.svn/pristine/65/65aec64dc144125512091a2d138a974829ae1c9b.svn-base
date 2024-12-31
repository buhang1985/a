package iih.bl.st.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class QryOepStVsIncMergeUnCCDTO implements ITransQry{
	String id_pat;
	String dt_b;
	String dt_e;
	String eu_direct;

	/*
	 * 获取可拆票的发票数据
	 */
	public QryOepStVsIncMergeUnCCDTO(String id_pat, String dt_b, String dt_e) {

		this.id_pat = id_pat;
		this.dt_b = dt_b;
		this.dt_e = dt_e;
		this.eu_direct = "1";
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (id_pat != null)
			param.addParam(this.id_pat);
		if (dt_b != null)
			param.addParam(this.dt_b);
		if (dt_e != null)
			param.addParam(this.dt_e);
		if (eu_direct != null)
			param.addParam(this.eu_direct);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" select st.id_stoep,inc.id_incoep,st.dt_st,st.code_st,inc.incno,st.id_hp,st.id_patca, ");
		sql.append(" to_char(wm_concat(distinct payitm.id_pm)) id_pm, to_char(wm_concat(distinct pm.name)) name_pm,sum(payitm.amt*payitm.eu_direct) amt ");
		sql.append(" from bl_st_oep st");
		sql.append(" inner join bl_inc_oep inc on st.id_stoep=inc.id_stoep");
		sql.append(" inner join bl_pay_itm_pat_oep payitm on payitm.id_paypatoep=st.id_paypatoep");		
		sql.append(" inner join bd_pri_pm pm on payitm.id_pm=pm.id_pm");		
		sql.append(" where st.id_stoep in (select id_stoep from bl_cg_itm_oep where eu_srctp <> 1 and id_stoep=st.id_stoep) ");
		if (id_pat != null)
			sql.append(" AND st.ID_PAT=?");
		if (dt_b != null)
			sql.append(" AND st.DT_ST >= TO_CHAR(?)");
		if (dt_e != null)
			sql.append(" AND st.DT_ST <= TO_CHAR(?)");
		if (eu_direct != null)
			sql.append(" AND st.EU_DIRECT=?");
		
		sql.append(" AND inc.FG_CANC = 'N' and nvl(st.id_cc, '~') = '~' ");

		sql.append(" group by st.id_hp,st.id_patca,st.id_stoep,inc.id_incoep, st.dt_st,st.code_st,inc.incno "); 
        sql.append(" ORDER BY st.DT_ST DESC, inc.INCNO ASC");
		return sql.toString();

	}
}
