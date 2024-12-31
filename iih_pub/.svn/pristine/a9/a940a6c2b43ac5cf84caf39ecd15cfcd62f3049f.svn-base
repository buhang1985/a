package iih.en.pv.inpatient.refs;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 预住院就诊参照（支持指定病区和就诊科室含ID_ENT）
 *
 * @author li.wm
 *
 */
public class IpPatEntIppreRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "code_pat", "name_pat", "dt_entry" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "id_pat","code_amr_ip", "id_ent" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "患者编号", "患者姓名", "入院时间" };
	}

	@Override
	public String getPkFieldCode() {
		return "id_ent";
	}

	@Override
	public String getRefCodeField() {
		return "code_pat";
	}

	@Override
	public String getRefNameField() {
		return "name_pat";
	}

	@Override
	public String getTableName() {
		return "ipippre";
	}

	@Override
	public String getRefSql() {

		String depId = (String) this.getExtendAttributeValue("depId");
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from  ( select distinct pat.code as code_pat,");
		sql.append(" ent.name_pat,");
		sql.append(" ent.dt_entry,");
		sql.append(" ent.id_pat,");
		sql.append(" ip.code_amr_ip,");
		sql.append(" ip.id_ent,");
		sql.append(" ip.fg_ippre,");
		sql.append(" pat.pycode,");
		sql.append(" pat.wbcode,");
		sql.append(" ent.id_dep_nur ");
		sql.append(" from en_ent_ip ip ");
		sql.append(" inner join en_ent ent  on ip.id_ent = ent.id_ent ");
		sql.append(" inner join en_ippre ippre on ip.id_ent = ippre.id_ent ");

		sql.append("inner join pi_pat pat  on ent.id_pat = pat.id_pat ");
		sql.append("where ip.fg_ippre = 'Y'  ");
		if (!StringUtil.isEmpty(depId)) {
			sql.append(" and (ipper.id_dep_phy = '" + depId + "' or ipper.id_dep_ward = '" + depId
					+ "' or ip.id_dep_phyadm = '" + depId + "' or ip.id_dep_nuradm = '" + depId + "'");
		}

		sql.append(" ) ipippre ");
		sql.append("where 1=1  ");

		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sql.append(" And (").append(where).append(") ");
			}
		}

		return sql.toString();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { "name_pat", "code_pat", "pycode", "wbcode", "code_amr_ip","id_ent" };
	}
}
