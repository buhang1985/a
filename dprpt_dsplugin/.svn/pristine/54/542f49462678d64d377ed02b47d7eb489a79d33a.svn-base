package iih.nm.nhr.wardprint.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取科室周排班分组数据
 * @author 王鹏
 *
 */
public class GetSchedSigrpQry implements ITransQry{

	private String id_dep;
	private String dt_monday;
	
	public GetSchedSigrpQry(String id_dep,String dt_monday) {
		this.id_dep = id_dep;
		this.dt_monday = dt_monday;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_dep);
		param.addParam(id_dep);
		param.addParam(dt_monday);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer stb = new StringBuffer();
		stb.append("select sigrp.id_nhr_sigrp,");
		stb.append("sigrp.name as name,");
		stb.append("sigrp.dt_week,");
		stb.append("sigrp.id_dep_nur,");
		stb.append("sigrp.sortno");
		stb.append(" from NM_NHR_SIGRP sigrp");
		stb.append(" where id_dep_nur = ?");
		stb.append(" and dt_week = (select MAX(DT_WEEK)");
		stb.append(" from NM_NHR_SIGRP");
		stb.append(" where id_dep_nur = ?");
		stb.append(" and dt_week <= ?)");
		stb.append(" order by sortno asc");
		return stb.toString();
	}
	
}
