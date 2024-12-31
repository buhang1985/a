package iih.nm.nhr.wardprint.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取给定科室和日期下排班分组人员
 * 
 * @author lijm
 *
 */
public class GetGrpPsnByDepAndDtSql implements ITransQry {

	private String id_dep_nur;
	private String dt_week;

	public GetGrpPsnByDepAndDtSql(String dt_week, String id_dep_nur) {
		this.dt_week = dt_week;
		this.id_dep_nur = id_dep_nur;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_dep_nur);
		param.addParam(dt_week);
		param.addParam(id_dep_nur);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("	select psn.id_nur, nur.name, nurlvl.name nameLvl				");
		sb.append("	from nm_nhr_sigrp_psn psn                                       ");
		sb.append("	left join nm_nur nur on nur.id_nur = psn.id_nur                 ");
		sb.append("	left join bd_udidoc nurlvl on nurlvl.id_udidoc = psn.id_nur_lvl");
		sb.append("	where psn.id_nhr_sigrp in                                       ");
		sb.append("		(                                                           ");
		sb.append("			select id_nhr_sigrp                                     ");
		sb.append("			from nm_nhr_sigrp grp                                   ");
		sb.append("			where grp.dt_week in                                     ");
		sb.append("				(select max(dt_week)                                ");
		sb.append("					from nm_nhr_sigrp                               ");
		sb.append("					where id_dep_nur = ?                            ");
		sb.append("					and dt_week <= ?                                ");
		sb.append("				)                                                   ");
		sb.append("			and grp.id_dep_nur = ? )                                ");
		sb.append("	order by psn.sortno asc                                         ");
		return sb.toString();
	}
}
