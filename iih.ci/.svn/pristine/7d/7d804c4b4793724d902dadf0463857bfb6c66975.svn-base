package iih.ci.mr.s.bp.qry;

import iih.ci.mr.cimrpatsigns.d.Patparam;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class FindPatDTOSql implements ITransQry {

	private String Code_entp;
	private String Sd_status;
	private String Id_dep_nur;
	private String whereType;
	private String key;

	public FindPatDTOSql(Patparam patparam) {
		this.Code_entp = patparam.getCode_entp();
		this.Sd_status = patparam.getSd_status();
		this.Id_dep_nur = patparam.getId_dep_nur();
		this.whereType = patparam.getWheretype();
		this.key = patparam.getValue().toLowerCase();
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam = new SqlParam();
		rtnParam.addParam(Code_entp);
		rtnParam.addParam(Sd_status);
		rtnParam.addParam(Id_dep_nur);

		if (!StringUtil.isEmpty(key)) {
			if (whereType.equals("0")) {
				rtnParam.addParam("%" + key + "%");
				rtnParam.addParam("%" + key + "%");
				rtnParam.addParam("%" + key + "%");
				rtnParam.addParam("%" + key + "%");
				rtnParam.addParam("%" + key + "%");
				rtnParam.addParam("%" + key + "%");
			} else {
				rtnParam.addParam("%" + key + "%");
			}
		}

		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		return _getQrySQLStr();
	}

	private String _getQrySQLStr() {
//		String sqlStr = "select " + " enent.id_ent," + " enent.code_entp," + " enent.id_pat," + " enent.code," + " enentip.name_bed as bebcode," + " enent.name_pat as name,"
//				+ " udisex.name as sex,/*性别*/" + "  enent.dt_birth_pat as dt_birth," + " 'N' as checked" + " from en_ent enent" + " left join EN_ENT_IP enentip on enentip.id_ent=enent.id_ent"
//				+ " left join bd_udidoc udisex on udisex.id_udidoc=enent.id_sex_pat " +" left join pi_pat pipat on pipat.id_pat=enent.id_pat " + " where enent.code_entp=? and enentip.sd_status=? and enent.id_dep_nur=? ";
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select enent.id_ent, "); 
		sqlStr.append(" enent.code_entp, "); 
		sqlStr.append(" enent.id_pat, "); 
		sqlStr.append(" enent.code, "); 
		sqlStr.append(" enentip.name_bed as bebcode, ");
		sqlStr.append(" enent.name_pat as name, "); 
		sqlStr.append(" udisex.name as sex, ");
		sqlStr.append(" enent.dt_birth_pat as dt_birth, ");
		sqlStr.append(" 'N' as checked, ");
		sqlStr.append(" enent.dt_entry, ");
		sqlStr.append(" enent.dt_end ");
		sqlStr.append(" from en_ent enent "); 
		sqlStr.append(" left join EN_ENT_IP enentip on enentip.id_ent=enent.id_ent ");
		sqlStr.append(" left join bd_udidoc udisex on udisex.id_udidoc=enent.id_sex_pat  ");
		sqlStr.append(" left join pi_pat pipat on pipat.id_pat=enent.id_pat "); 
		sqlStr.append(" where enent.code_entp=? and enentip.sd_status=? and enent.id_dep_nur=? ");

		if (!StringUtil.isEmpty(key)) {
			if (!StringUtils.isBlank(whereType)) {
				switch (whereType) {
				case "0":
					sqlStr.append( "and (lower(enentip.name_bed) like ? or lower(enent.name_pat) like ? or lower(enent.code) like ? or lower(pipat.wbcode) like ? or lower(pipat.pycode) like ? or lower(pipat.mnecode) like ? )");
					break;
				case "1":
					sqlStr .append("and lower(enentip.name_bed) like ?");
					break;
				case "2":
					sqlStr.append("and lower(enent.name_pat) like ?");
					break;
				default:
					//sqlStr += "and lower(enent.code) like ?";
					sqlStr.append("and lower(enent.code) like ?") ;
					break;
				}
			}
		}
		return sqlStr + " order by enentip.name_bed ASC";
	}
}
