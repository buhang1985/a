package iih.nm.nqm.bp.qry;

import org.apache.commons.lang3.StringUtils;

import xap.sys.jdbc.kernel.SqlParam;

public class GetNqmChkListQry{

	private String dt_b;
	private String dt_e;
	private String id_nqm_lvl;
	private String id_dep;
	
	public GetNqmChkListQry(String dt_b,String dt_e,String id_dep,String id_nqm_lvl){
		this.dt_b = dt_b;
		this.dt_e = dt_e;
		this.id_dep = id_dep;
		this.id_nqm_lvl = id_nqm_lvl;
	}
	
	public String getQrySQLStr() {
		StringBuffer stb = new StringBuffer();
		stb.append("select t1.code_nqm_cs as codeNqmCs,");
		stb.append("nqmcs.name as csName,");
		stb.append("t1.id_nqm_cstmpl as csTmplId,");
		stb.append("t1.id_dep as depId,");
		stb.append("dep.name as depName,");
		stb.append("t1.score_cs as csTotalScore,");
		stb.append("t1.score_chk   as chkScore");
		stb.append(" from nm_nqm_chk t1");
		stb.append(" inner join bd_dep dep on t1.id_dep = dep.id_dep");
		stb.append(" inner join nm_nqm_cs nqmcs on t1.id_nqm_cs = nqmcs.id_nqm_cs");
		stb.append(" where 1 = 1");
		if(!StringUtils.isEmpty(this.id_dep)){
			stb.append(" and t1.id_dep = '" + id_dep + "'");
		}
		if(!StringUtils.isEmpty(this.id_nqm_lvl)){
			stb.append(" and id_chk_lvl = '" + id_nqm_lvl + "'");
		}
		stb.append(" and t1.dt_chk >= '" + dt_b +"'");
		stb.append(" and t1.dt_chk < '" + dt_e +"'");
		return stb.toString();
	}

}
