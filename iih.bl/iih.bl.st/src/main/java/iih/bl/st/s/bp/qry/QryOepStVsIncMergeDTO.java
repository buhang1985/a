package iih.bl.st.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获得患者指定时间段内的的结算与发票信息（汇总）
 * 
 * @author liwq
 *
 */
public class QryOepStVsIncMergeDTO implements ITransQry{


	String id_pat;
	String dt_b;
	String dt_e;
	String codest;
	String incno;
	String id_stoep;
	String eu_direct;
	String fg_canc;

	/*
	 * 获取退款调入时的相关收款数据
	 */
	public QryOepStVsIncMergeDTO(String id_pat, String dt_b, String dt_e) {

		this.id_pat = id_pat;
		this.dt_b = dt_b;
		this.dt_e = dt_e;
		this.eu_direct = "1";
		this.fg_canc = "N";
	}

	/*
	 * 获取退款导入时的相关收款数据录入结算号 与发票号 返回对应的数据
	 */
	public QryOepStVsIncMergeDTO(String id_pat, String codest, String incno, String nullKey) {
		this.id_pat = id_pat;
		this.codest = codest;
		this.incno = incno;
		this.eu_direct = "1";
		this.fg_canc = "N";
	}

//	/*
//	 * 获取相关异常数据 导入
//	 */
//	public QryOepStVsIncMergeDTO(String id_stoep) {
//		this.id_stoep = id_stoep;
//	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (id_pat != null)
			param.addParam(this.id_pat);
		if (dt_b != null)
			param.addParam(this.dt_b);
		if (dt_e != null)
			param.addParam(this.dt_e);
		if (codest != null)
			param.addParam(this.codest);
		if (incno != null)
			param.addParam(this.incno);
//		if (id_stoep != null)
//			param.addParam(this.id_stoep);
		if (eu_direct != null)
			param.addParam(this.eu_direct);
		if (fg_canc != null)
			param.addParam(this.fg_canc);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" select st.id_stoep,inc.id_incoep,st.dt_st,st.code_st,st.id_hp,st.id_patca, ");
		sql.append("case when inc.fg_ec_inc ='Y'then inc.incno else '' end as incno,");
		sql.append("case when inc.fg_ec_inc ='Y'then incp.incno else inc.incno end as p_incno,");
		sql.append(" to_char(wm_concat(distinct payitm.id_pm)) id_pm, to_char(wm_concat(distinct pm.name)) name_pm,sum(payitm.amt*payitm.eu_direct) amt ");
		sql.append(" from bl_st_oep st");
		sql.append(" inner join bl_inc_oep inc on st.id_stoep=inc.id_stoep");
		sql.append(" inner join bl_pay_itm_pat_oep payitm on payitm.id_paypatoep=st.id_paypatoep");		
		sql.append(" inner join bd_pri_pm pm on payitm.id_pm=pm.id_pm");	
		sql.append(" left join bl_inc_oep_paper incp on incp.id_incoep = inc.id_incoep ");
		sql.append(" where st.id_stoep in (select id_stoep from bl_cg_itm_oep where eu_srctp <> 1 and id_stoep=st.id_stoep) ");
		if (id_pat != null)
			sql.append(" AND st.ID_PAT=?");
		if (dt_b != null)
			sql.append(" AND st.DT_ST >= TO_CHAR(?)");
		if (dt_e != null)
			sql.append(" AND st.DT_ST <= TO_CHAR(?)");
		if (codest != null)
			sql.append(" AND st.Code_st=?");
		if (incno != null)
			sql.append(" AND inc.INCNO=?");
//		if (id_stoep != null)
//			sql.append(" AND st.ID_STOEP=?");
		if (eu_direct != null)
			sql.append(" AND st.EU_DIRECT=?");
		if (fg_canc != null)
			sql.append(" AND st.FG_CANC =?");
		
		sql.append(" group by st.id_hp,st.id_patca,st.id_stoep,inc.id_incoep, st.dt_st,st.code_st,case when inc.fg_ec_inc ='Y'then inc.incno else '' end,case when inc.fg_ec_inc ='Y'then incp.incno else inc.incno end "); 
        sql.append(" ORDER BY st.DT_ST DESC, case when inc.fg_ec_inc ='Y'then inc.incno else '' end ASC");
		return sql.toString();

	}

}
