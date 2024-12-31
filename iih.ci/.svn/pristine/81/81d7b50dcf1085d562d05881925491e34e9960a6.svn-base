package iih.ci.ord.s.external.bp.qry;

import iih.ci.ord.pub.CiOrdUtils;

import com.mysql.jdbc.StringUtils;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询手术开单信息
 * @author Young
 *
 */
public class GetOrdOperInfo4BlDTOsQry implements ITransQry {

	private String id_ent;
	private String[] id_ors;
	
	public GetOrdOperInfo4BlDTOsQry(String id_ent, String[] id_ors, String... params){
		this.id_ent = id_ent;
		this.id_ors = id_ors;
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
		return param;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		StringBuilder strSql = new StringBuilder();
		strSql.append("select ORD.id_or,");
		strSql.append("ORD.code_or,");
		strSql.append("ORD.des_or,");
		strSql.append("ORD.content_or,");
		strSql.append("ORD.name_or,");
		strSql.append("ORD.id_emp_sign,");
		strSql.append("EMPSIGN.code code_emp_sign,");
		strSql.append("EMPSIGN.name name_emp_sign,");
		strSql.append("ORD.dt_effe,");
		strSql.append("ORD.dt_end,");
		
		strSql.append("APSUG.id_srv,");
		strSql.append("APSUG.id_srv_code,");
		strSql.append("APSUG.id_didef_relstd,");
		strSql.append("DIDEFSTD.code sd_didef_relstd,");
		strSql.append("DIDEFSTD.name name_didef_relstd,");
		strSql.append("APSUG.id_di,");
		strSql.append("APSUG.str_code_di sd_di,");
		strSql.append("APSUG.str_name_di name_di,");
		strSql.append("APSUG.no_applyform,");
		strSql.append("APSUG.dt_plan,");
		strSql.append("APSUG.id_lvlsug,");
		strSql.append("APSUG.sd_lvlsug,");
		strSql.append("LVLSUG.name name_lvlsug,");
		strSql.append("APSUG.id_anestp,");
		strSql.append("APSUG.sd_anestp,");
		strSql.append("ANESTP.name name_anestp,");
		strSql.append("APSUG.fg_allergy,");
		strSql.append("APSUG.fg_patho,");
		strSql.append("APSUG.id_su_op,");
		strSql.append("APSUG.sd_su_op,");
		strSql.append("SUOP.name name_su_op,");
		strSql.append("APSUG.announcements,");
		strSql.append("APSUG.quan_bt_paln,");
		strSql.append("APSUG.id_emp_operate,");
		strSql.append("EMPOPER.code sd_emp_operate,");
		strSql.append("EMPOPER.name name_emp_operate,");
		strSql.append("APSUG.id_emp_helper,");
		strSql.append("EMPHELP.code sd_emp_helper,");
		strSql.append("EMPHELP.name name_emp_helper,");
		strSql.append("APSUG.id_sugbody,");
		strSql.append("APSUG.sd_sugbody,");
		strSql.append("BODY.name name_sugbody,");
		strSql.append("APSUG.specialreq,");
		strSql.append("APSUG.specialinstrument,");
		strSql.append("APSUG.specialdes,");
		strSql.append("APSUG.fg_new_sug,");
		strSql.append("APSUG.fg_daysug,");
		strSql.append("APSUG.fg_er_sug,");
		strSql.append("APSUG.fg_xq_sug,");
		strSql.append("APSUG.fg_zq_sug ");
		
		strSql.append("from ci_order ORD ");
		strSql.append("left join bd_psndoc EMPSIGN on ORD.id_emp_sign=EMPSIGN.id_psndoc ");
		strSql.append("left join ci_ap_sug APSUG on ORD.id_or=APSUG.id_or ");
		strSql.append("left join bd_di_def DIDEFSTD on APSUG.id_didef_relstd=DIDEFSTD.id_didef ");
		
		strSql.append("left join bd_udidoc LVLSUG  on APSUG.id_lvlsug      = LVLSUG.id_udidoc ");
		strSql.append("left join bd_udidoc ANESTP  on APSUG.id_anestp      = ANESTP.id_udidoc ");
		strSql.append("left join bd_udidoc SUOP    on APSUG.id_su_op       = SUOP.id_udidoc ");
		strSql.append("left join bd_udidoc BODY    on APSUG.id_sugbody     = BODY.id_udidoc ");
		strSql.append("left join bd_psndoc EMPOPER on APSUG.id_emp_operate = EMPOPER.id_psndoc ");
		strSql.append("left join bd_psndoc EMPHELP on APSUG.id_emp_helper  = EMPHELP.id_psndoc ");
		
		String strWhere = "";
		if (!StringUtils.isNullOrEmpty(this.id_ent)){
			strWhere += " where ORD.id_en=? and ORD.fg_sign='Y' and ORD.fg_canc='N' and ORD.sd_srvtp like '04%' and ORD.sd_su_bl!=2 ";
		} 
		if (id_ors != null && id_ors.length > 0){
			if (strWhere.length() > 0) {
				strWhere += " and ";
			} else {
				strWhere += " where ";
			}
			strWhere += " ORD.id_or in (?) ";
		}
		
		strSql.append(strWhere + " order by ORD.dt_sign desc");
		return strSql.toString();
	}
}
