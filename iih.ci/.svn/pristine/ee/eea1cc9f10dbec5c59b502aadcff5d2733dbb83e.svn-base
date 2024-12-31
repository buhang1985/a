package iih.ci.ord.s.external.bp.qry;

import com.mysql.jdbc.StringUtils;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据就诊主键查询本次就诊的已签署未作废的诊断明细信息
 * @author Young
 *
 */
public class GetEnDiInfo4BlDTOsQry implements ITransQry {

	private String id_ent;
	
	public GetEnDiInfo4BlDTOsQry(String id_ent, String... params){
		this.id_ent = id_ent;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam param = new SqlParam();
		if(!StringUtils.isNullOrEmpty(this.id_ent)){
			param.addParam(this.id_ent);
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		StringBuilder strSql = new StringBuilder();
		strSql.append("select DI.id_di,");
		strSql.append("DI.id_ditp,");
		strSql.append("DI.sd_ditp,");
		strSql.append("DITP.name name_ditp,");
		strSql.append("DI.dt_di,");
		strSql.append("DI.id_emp_sign,");
		strSql.append("EMPSIGN.code code_emp_sign,");
		strSql.append("EMPSIGN.name name_emp_sign,");
		
		strSql.append("DIITM.id_diitm,");
		strSql.append("DIITM.sortno,");
		strSql.append("DIITM.id_disys,");
		strSql.append("DIITM.sd_disys,");
		strSql.append("DIITM.id_didef_code,");
		strSql.append("DIITM.id_didef_name,");
		strSql.append("DIITM.id_didef_syn_code,");
		strSql.append("DIITM.id_didef_syn_name,");
		strSql.append("DIITM.supplement,");
		strSql.append("DIITM.fg_majdi,");
		strSql.append("DIITM.fg_suspdi,");
		strSql.append("DIITM.id_parent ");
		
		strSql.append("from ci_di_itm DIITM ");
		strSql.append("left join ci_di DI on DI.id_di=DIITM.id_di ");
		strSql.append("left join bd_udidoc DITP on DI.id_ditp=DITP.id_udidoc ");
		strSql.append("left join bd_psndoc EMPSIGN on DI.id_emp_sign=EMPSIGN.id_psndoc ");
		
		strSql.append("where DI.id_en=? and DI.fg_sign='Y' and DI.fg_cancel='N' order by DI.dt_sign desc,DIITM.sortno ");
		
		return strSql.toString();
	}

}
