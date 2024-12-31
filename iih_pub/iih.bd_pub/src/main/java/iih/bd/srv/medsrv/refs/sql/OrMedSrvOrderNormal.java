package iih.bd.srv.medsrv.refs.sql;

import java.util.List;

import xap.mw.core.data.Context;

public class OrMedSrvOrderNormal extends OrMedSrvOrderBase {

	@Override
	public String getMySqlStr(String code_entp, String id_hp, String inputstr,
			String id_pripat, List<String> whereList) {
		StringBuilder formatsql = new StringBuilder();
		formatsql.append("select distinct * from (").append("select ")
				.append(" bd_srv.name as name_srv,'' as des_pri,bd_srv.Des as des,")
				.append(" bd_srv.Name,bd_srv.Code,bd_srv.Id_srv,bd_srv.Id_srvtp,")
				.append(" bd_srv.Fg_ctm,bd_srv.Fg_or,bd_srv.Fg_active,bd_srv.Quan_med,bd_srv.Id_unit_med,bd_srv.Fg_set,")
				.append(" bd_srv.Id_srvca,bd_srv.Sd_srvtp,bd_srv.Pri,bd_srv.Shortname,")
				.append(" A1.id_mm,A1.name as name_mm,A1.spec,").append(" (bd_srv.id_srv||A1.id_mm) as IDSRVIDMM,")
				.append(" bd_srv.Id_Org").append(" from bd_srv left outer join bd_mm A1 on 1!=1 and bd_srv.ds=0 ")
				.append(" left join bd_srvoth_wordfreq bsw  on bd_srv.id_srv = bsw.id_biz and biz_classtype = 'medsrv'")
				.append(" and id_dept ='").append(Context.get().getDeptId()).append("' ").append(" ")
				.append(") a0  where a0.Fg_Or='Y' and a0.Fg_Active='Y' ")
				.append(getFgUseFld(code_entp)); // 可使用标识
		for (String part : whereList) {
			formatsql.append(" and " + part);
		}
		return formatsql.toString();
	}

	@Override
	protected String getSrvMmSql(String code_entp, String id_pripat, List<String> whereList) {
		return "";
	}

}
