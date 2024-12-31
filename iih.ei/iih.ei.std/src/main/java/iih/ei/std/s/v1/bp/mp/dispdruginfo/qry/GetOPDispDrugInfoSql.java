package iih.ei.std.s.v1.bp.mp.dispdruginfo.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 
* @ClassName: GetOPDispDrugInfoSql
* @Description: 查询门诊发药明细
* @author zhy
* @date 2019年10月16日
*
 */
public class GetOPDispDrugInfoSql implements ITransQry{

	private String id_pres;
	
	public GetOPDispDrugInfoSql(String id_pres,String deptId) {
		super();
		this.id_pres = id_pres;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this.id_pres);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("  SELECT op.id_pres id_pres,						   ");
		sqlStr.append("    pat.name AS name_pat,						    ");
		sqlStr.append("    CASE sexdoc.code								   ");
		sqlStr.append("      WHEN '2'									    ");
		sqlStr.append("      THEN '女'									   ");
		sqlStr.append("      WHEN '1'									    ");
		sqlStr.append("      THEN '男'									   ");
		sqlStr.append("    END AS name_sex,							    ");
		sqlStr.append("    patca.name AS paymenttype,					    ");
		sqlStr.append("    pat.dt_birth AS age,									    ");
		sqlStr.append("    NVL(pat.tel, pat.mob) AS tel,					   ");
		sqlStr.append("    bddep.name dep_mp,						   ");
		sqlStr.append("    bdpsndoc.name emp_dp,						   ");
		sqlStr.append("    bdmm.code code_mm,						   ");
		sqlStr.append("    bdmm.name name_mm,						   ");
		sqlStr.append("    op.dt_dp ,									    ");
		sqlStr.append("    opdt.quan_pair_mp,							   ");
		sqlStr.append("    opdt.quan_pair_bk,							   ");
		sqlStr.append("    opdt.quan_mp,								   ");
		sqlStr.append("    opdt.quan_bk,								    ");
		sqlStr.append("    bdmeasdoc.name pkgu_cur,					   ");
		sqlStr.append("    opdt.price_pkgu_cur ,							   ");
		sqlStr.append("    opdt.amt_real ,								   ");
		sqlStr.append("    quesite.name quesite_act,					   ");
		sqlStr.append("    'payed' AS paymentstatus,						   ");
		sqlStr.append("    'his'   AS datasource,							   ");
		sqlStr.append("    'new'   AS processstatus						   ");
		sqlStr.append("  FROM mp_dg_op op							   ");
		sqlStr.append("  JOIN mp_dg_op_dt opdt						   ");
		sqlStr.append("  ON op.id_dgop = opdt.id_dgop					   ");
		sqlStr.append("  JOIN bd_mm bdmm							   ");
		sqlStr.append("  ON opdt.id_mm = bdmm.id_mm					   ");
		sqlStr.append("  JOIN bd_measdoc bdmeasdoc					    ");
		sqlStr.append("  ON bdmeasdoc.id_measdoc = opdt.id_pkgu_cur	   ");
		sqlStr.append("  JOIN pi_pat pat								   ");
		sqlStr.append("  ON op.id_pat = pat.id_pat						   ");
		sqlStr.append("  JOIN pi_pat_ca patca							   ");
		sqlStr.append("  ON pat.id_paticate = patca.id_patca				   ");
		sqlStr.append("  JOIN bd_udidoc sexdoc							   ");
		sqlStr.append("  ON sexdoc.id_udidoc = pat.id_sex				   ");
		sqlStr.append("  LEFT JOIN bd_dep bddep						    ");
		sqlStr.append("  ON bddep.id_dep = op.id_dep_mp				   ");
		sqlStr.append("  LEFT JOIN bd_psndoc bdpsndoc					    ");
		sqlStr.append("  ON bdpsndoc.id_psndoc = op.id_emp_dp		   ");
		sqlStr.append("  LEFT JOIN bd_que_site quesite					   ");
		sqlStr.append("  ON opdt.id_quesite_act = quesite.id_quesite		   ");
		sqlStr.append("  WHERE op.sd_mpdgtp = '13'						   ");
		sqlStr.append("  AND op.eu_su_mp != '9'						   ");
		sqlStr.append("  AND op.fg_cancbk = 'N'							   ");
		sqlStr.append("  AND op.id_pres = ?							    ");
		return sqlStr.toString();
	}

}
