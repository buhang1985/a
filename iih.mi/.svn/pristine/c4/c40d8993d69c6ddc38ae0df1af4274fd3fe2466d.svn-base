package iih.mi.mibd.mioepordcostupload.s.bp.qry;

import iih.bd.base.utils.StringUtils;
import iih.bl.params.BlParams;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class OepOrdCostQry implements ITransQry {
	
	private String _wherePart;
	
	public OepOrdCostQry(String wherePart){
		this._wherePart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return null;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" select  DECODE(act.id_interfaceacttime,  NULL,  'N',  'Y')  as  fg_upload, ");
		sql.append("               pat.id_pat, ");
		sql.append("               pat.name  as  pat_name, ");
		sql.append("               pat.code  as  pat_code, ");
		sql.append("               stoep.dt_st  as  dt_st, ");
		sql.append("               stoep.amt_ratio  as  amt_st, ");
		sql.append("               stoep.eu_direct, ");
		sql.append("               stoep.code_st, ");
		sql.append("               psn.name  as  emp_name, ");
		sql.append("               psn.id_psndoc  as  id_emp ");
		sql.append("     from  bl_st_oep  stoep ");
		sql.append("     left  join  bl_interface_act_time  act ");
		sql.append("         on  act.id_stoep  =  stoep.id_stoep ");
		sql.append("     left  join  pi_pat  pat ");
		sql.append("         on  stoep.id_pat  =  pat.id_pat ");
		sql.append("     left  join  bd_psndoc  psn ");
		sql.append("         on  psn.id_psndoc  =  act.id_emp_operator ");
		sql.append("     where  pat.fg_active  =  'Y'  ");
		String blhp000030 = BlParams.BLHP000030();
		if (StringUtils.isNotEmpty(blhp000030)) {
			String[] blhp30s = blhp000030.split(",");
			sql.append(" and (");
			for(int i=0;i<blhp30s.length;i++){
				if (i==blhp30s.length-1) {
					sql.append("  stoep.id_hp='").append(blhp30s[i]).append("')");
					continue;
				}
				sql.append("  stoep.id_hp='").append(blhp30s[i]).append("' or ");
			}
		}
		if (StringUtils.isNotEmpty(_wherePart)) {
			sql.append(this._wherePart);
		}
		sql.append("     order  by  stoep.dt_st  desc ");

		
		return sql.toString();
	}

}
