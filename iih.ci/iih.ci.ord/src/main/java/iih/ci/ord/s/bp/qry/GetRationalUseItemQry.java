package iih.ci.ord.s.bp.qry;

import iih.ci.ord.pub.CiOrdUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetRationalUseItemQry implements ITransQry {

	private String id_ent;
	private String idors;

	public GetRationalUseItemQry(String id_ent, String idors) {
		this.id_ent = id_ent;
		this.idors = idors;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(this.id_ent);
		// sqlparam.addParam(this.idors);
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"select '-1' as orderno,srv.id_orsrv as \"index\",srv.name as name_mm_ty,bdmm.name as name_mm,mm.code_mm,srv.quan_medu,m.name as name_unit_medu, ");
		sb.append("b.name as name_freq,route.name as name_route, ");
		sb.append("ci.dt_effe as dt_begin,ci.dt_end,ci.dt_effe as dt_plan,ci.code_or as grouptag, ");
		sb.append("case ci.code_entp when '00' then '0' else decode(ci.fg_long,'Y','0','N','1',0) end as fg_long, ");
		sb.append("mm.quan_cur,m2.name as Name_quan_cur,ci.des_or as remark,'' as Presno ");
		sb.append("from ci_order ci ");
		sb.append("left join ci_or_srv srv on ci.id_or=srv.id_or ");
		sb.append("left join ci_or_srv_mm mm on srv.id_orsrv=mm.id_orsrv ");
		sb.append("left join bd_mm bdmm on bdmm.id_mm = mm.id_mm ");
		sb.append("left join bd_measdoc m on srv.id_medu = m.id_measdoc ");
		sb.append("left join bd_freq b on ci.id_freq = b.id_freq ");
		sb.append("left join bd_route route on ci.id_route = route.id_route ");
		sb.append("left join bd_measdoc m2 on mm.id_pgku_cur= m2.id_measdoc ");
		sb.append("where (ci.id_en=? and ci.fg_sign='Y' and ci.fg_canc='N'  and srv.sd_srvtp like '01%' and srv.sd_su_bl !='2' and (ci.dt_end is null or (substr(ci.dt_end,0,10) >= to_char(sysdate,'YYYY-MM-DD'))))");
		if (!CiOrdUtils.isEmpty(this.idors)) {
			sb.append(" or ci.id_or in ("+this.idors + ")");
		} 
		return sb.toString();
	}
}
