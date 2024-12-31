package iih.nm.nqm.bp.qry;

import org.apache.commons.lang3.StringUtils;

import xap.sys.jdbc.kernel.SqlParam;

public class GetNqmImprovListQry{

	//查询开始时间
	private String dt_b;
	//查询结束时间
	private String dt_e;
	
	private String id_nqm_lvl;
	
	private String id_dep;
	
	public GetNqmImprovListQry(String dt_b,String dt_e,String id_nqm_lvl,String id_dep){
		this.dt_b = dt_b;
		this.dt_e = dt_e;
		this.id_nqm_lvl = id_nqm_lvl;
		this.id_dep = id_dep;
	}
	
	public String getQrySQLStr() {
		StringBuffer stb = new StringBuffer();
		stb.append("select t1.code_nqm_cs as codeNqmCs,");
		stb.append("t1.issue_smy as existProblem,");
		stb.append("t1.mend_meas as mendMeas");
		stb.append(" from nm_nqm_improv t1");
		stb.append(" where t1.dt_begin >= '" + dt_b + "'");
		stb.append(" and t1.dt_end < '" + dt_e + "'");	
		if(!StringUtils.isEmpty(id_nqm_lvl)){
			stb.append(" and t1.id_nqm_lvl = '" +id_nqm_lvl + "'");
		}
		if(!StringUtils.isEmpty(id_dep)){
			stb.append(" and t1.id_dep = '" + id_dep + "'");
		}
		return stb.toString();
	}

}
