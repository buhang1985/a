package iih.ci.ord.s.external.provide.bp.bl.qry;

import iih.ci.ord.pub.CiOrdUtils;

import com.mysql.jdbc.StringUtils;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询药品开单信息
 * @author Young
 *
 */
public class GetOrdDrugInfo4BlDTOsQry implements ITransQry {

	private String id_ent;
	private String[] id_ors;
	private String[] id_orsrvs;

	public GetOrdDrugInfo4BlDTOsQry(String id_ent, String[] id_ors, String[] id_orsrvs, String... params) {
		this.id_ent = id_ent;
		this.id_ors = id_ors;
		this.id_orsrvs = id_orsrvs;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam param = new SqlParam();
		if (!StringUtils.isNullOrEmpty(this.id_ent)) {
			param.addParam(this.id_ent);
		}
		if (this.id_ors != null && this.id_ors.length > 0) {
			param.addParam(CiOrdUtils.getSqlInStrsWithOutIn(this.id_ors));
		}
		if (this.id_orsrvs != null && this.id_orsrvs.length > 0) {
			param.addParam(CiOrdUtils.getSqlInStrsWithOutIn(this.id_orsrvs));
		}
		return param;
	}
	
	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		StringBuilder strSql = new StringBuilder();
		strSql.append("select ORD.id_or,");
		strSql.append("ORD.code_or,");
		strSql.append("ORD.name_or,");
		strSql.append("ORD.des_or,");
		strSql.append("ORD.id_freq,");
		strSql.append("FREQ.name name_freq,");
		strSql.append("ORD.orders,");
		strSql.append("ORD.id_route,");
		strSql.append("ROUTE.name name_route,");
		strSql.append("ORD.id_boil,");
		strSql.append("BOIL.name name_boil,");
		strSql.append("ORD.days_or,");
		strSql.append("ORD.id_emp_sign,");
		strSql.append("EMPSIGN.code code_emp_sign,");
		strSql.append("EMPSIGN.name name_emp_sign,");
		strSql.append("ORD.dt_effe,");
		strSql.append("ORD.dt_end,");
		
		strSql.append("ORSRV.id_orsrv,");
		strSql.append("ORSRV.sortno,");
		strSql.append("ORSRV.id_srv,");
		strSql.append("ORSRV.name,");
		strSql.append("ORSRV.quan_medu,");
		strSql.append("ORSRV.id_medu,");
		strSql.append("MEAS.name name_medu,");
		strSql.append("ORSRV.id_routedes,");
		strSql.append("ROUTEDES.name name_routedes,");
		strSql.append("ORSRV.id_boildes,");
		strSql.append("BOILDES.name name_boildes,");
		strSql.append("ORSRV.pri,");
		strSql.append("ORSRV.fg_self,");
		strSql.append("ORSRV.id_dep_wh,");
		strSql.append("DEPWH.code code_dep_wh,");
		strSql.append("ORSRV.fg_base,");
		strSql.append("ORSRV.fg_specill,");
		strSql.append("ORSRVHP.indicitemid,");
		strSql.append("ORSRV.fg_nothingwithorders,");
		strSql.append("ORSRV.id_dsdef,");
		strSql.append("ORSRV.sd_srvtp,");
		strSql.append("ORSRV.code_srv,");
		
		strSql.append("ORSRVMM.id_orsrvmm,");
		strSql.append("ORSRVMM.id_mm,");
		strSql.append("ORSRVMM.code_mm,");
		strSql.append("ORSRVMM.name_mm,");
		strSql.append("ORSRVMM.quan_cur,");
		strSql.append("ORSRVMM.id_pgku_cur,");
		strSql.append("MEASCUR.name name_pgku_cur,");
		strSql.append("ORSRVMM.quan_num_base,");
		strSql.append("ORSRVMM.quan_den_base,");
		strSql.append("ORSRVMM.id_pgku_base,");
		strSql.append("MEASBASE.name name_pgku_base,");
		strSql.append("ORSRVMM.id_dosage,");
		strSql.append("ORSRVMM.sd_dosage,");
		strSql.append("DOSAGE.name name_dosage,");
		strSql.append("ORSRVMM.days_available ");
		
		strSql.append("from ci_or_srv ORSRV ");
		strSql.append("left join ci_order ORD on ORD.id_or=ORSRV.id_or ");
		strSql.append("left join ci_or_srv_mm ORSRVMM on ORSRVMM.id_orsrv=ORSRV.id_orsrv ");
		strSql.append("left join bd_freq FREQ on FREQ.id_freq=ORD.id_freq ");
		strSql.append("left join bd_route ROUTE on ROUTE.id_route=ORD.id_route ");
		strSql.append("left join bd_boil BOIL on BOIL.id_boil=ORD.id_boil ");
		strSql.append("left join bd_psndoc EMPSIGN on ORD.id_emp_sign=EMPSIGN.id_psndoc ");
		
		strSql.append("left join bd_measdoc MEAS on ORSRV.id_medu=MEAS.id_measdoc ");
		strSql.append("left join bd_route_des ROUTEDES on ROUTEDES.id_routedes=ORSRV.id_routedes ");
		strSql.append("left join bd_boil_des BOILDES on BOILDES.id_boildes=ORSRV.id_boildes ");
		strSql.append("left join bd_dep DEPWH on DEPWH.id_dep=ORSRV.id_dep_wh ");
		strSql.append("left join ci_or_srv_hp ORSRVHP on ORSRVHP.id_orsrv=ORSRV.id_orsrv ");
		
		strSql.append("left join bd_measdoc MEASCUR on ORSRVMM.id_pgku_cur=MEASCUR.id_measdoc ");
		strSql.append("left join bd_measdoc MEASBASE on ORSRVMM.id_pgku_cur=MEASBASE.id_measdoc ");
		strSql.append("left join bd_udidoc DOSAGE on ORSRVMM.id_dosage=DOSAGE.id_udidoc ");
		
		String strWhere = "";
		if (!StringUtils.isNullOrEmpty(this.id_ent)){
			strWhere += " where ORD.id_en=? and ORSRV.fg_or='Y' and ORD.fg_sign='Y' and ORD.fg_canc='N' and ORSRV.sd_srvtp like '01%' and ORD.sd_su_bl!=2 ";
		}
		if (id_ors != null && id_ors.length > 0){
			if (strWhere.length() > 0) {
				strWhere += " and ";
			} else {
				strWhere += " where ORSRV.fg_or='Y' and ";
			}
			strWhere += " ORD.id_or in (?) ";
		}
		if (id_orsrvs != null && id_orsrvs.length > 0){
			if (strWhere.length() > 0) {
				strWhere += " and ";
			} else {
				strWhere += " where ";
			}
			strWhere += " ORSRV.id_orsrv in (?) ";
		}
		
		strSql.append(strWhere + " order by ORD.dt_sign desc,ORSRV.sortno ");
		return strSql.toString();
	}
}
