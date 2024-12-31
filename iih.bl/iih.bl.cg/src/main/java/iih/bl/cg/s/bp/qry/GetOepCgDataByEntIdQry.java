package iih.bl.cg.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据就诊主键查询门诊记账sql
 * @author ly 2018/10/30
 *
 */
public class GetOepCgDataByEntIdQry  implements ITransQry {

	private String entId;
	
	public GetOepCgDataByEntIdQry(String entId){
		this.entId = entId;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer sqlSb) {
		
		sqlSb.append("where cgitm.id_ent = ? ");
		sqlSb.append("order by cgoep.dt_cg ");
		
		SqlParam param = new SqlParam();
		param.addParam(this.entId);
		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select ");
		sqlSb.append("cgitm.id_cgitmoep,");
		sqlSb.append("cgitm.id_srv,");
		sqlSb.append("cgitm.code_srv,");
		sqlSb.append("cgitm.name_srv,");
		sqlSb.append("cgitm.id_or, ");
		sqlSb.append("cgitm.price_ratio,");
		sqlSb.append("cgitm.quan * cgoep.eu_direct quan,");
		sqlSb.append("cgitm.amt_ratio * cgoep.eu_direct amt_ratio,");
		sqlSb.append("cgitm.srvu id_measdoc,");
		sqlSb.append("measdoc.name name_measdoc,");
		sqlSb.append("cgitm.spec,");
		sqlSb.append("cgitm.fg_st,");
		sqlSb.append("cgoep.id_dep_cg,");
		sqlSb.append("cgdep.name name_dep_cg,");
		sqlSb.append("cgoep.id_emp_cg,");
		sqlSb.append("psndoc.name name_emp_cg,");
		sqlSb.append("cgoep.dt_cg, ");
		sqlSb.append("doc.name  name_emp_confirm, ");
		sqlSb.append("dep.name  name_dep_mp ");
		
		sqlSb.append("from bl_cg_itm_oep cgitm ");
		sqlSb.append("inner join bl_cg_oep cgoep ");
		sqlSb.append("on cgitm.id_cgoep = cgoep.id_cgoep ");
		sqlSb.append("left join bd_measdoc measdoc ");
		sqlSb.append("on cgitm.srvu = measdoc.id_measdoc ");
		sqlSb.append("left join bd_dep cgdep ");
		sqlSb.append("on cgoep.id_dep_cg = cgdep.id_dep ");
		sqlSb.append("left join bd_psndoc psndoc ");
		sqlSb.append("on cgoep.id_emp_cg = psndoc.id_psndoc ");
		sqlSb.append("left join mp_or_pr orpr ");
		sqlSb.append("on orpr.id_or_pr=cgitm.id_or_pr ");
		sqlSb.append("left join bd_psndoc doc ");
		sqlSb.append("on doc.id_psndoc = orpr.id_emp_confirm ");
		sqlSb.append("left join bd_dep dep ");
		sqlSb.append("on dep.id_dep=cgitm.id_dep_mp ");
		return sqlSb.toString();
		
	}
}
