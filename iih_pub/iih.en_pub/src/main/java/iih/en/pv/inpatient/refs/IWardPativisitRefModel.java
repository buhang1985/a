package iih.en.pv.inpatient.refs;

import java.util.List;

import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 科室病区患者参照（支持指定病区和就诊科室）
 *
 * @author xuxing_2015-05-08
 *
 */
public class IWardPativisitRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {

		return new String[] { "code_bed", "code_pat", "name_pat" };
	}

	@Override
	public String[] getHiddenFieldCode() {

		return new String[] { "id_ent", "id_pat", "code_amr_ip" };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "床号", "患者编号", "患者姓名" };
	}

	@Override
	public String getPkFieldCode() {
		return "id_ent";
	}

	@Override
	public String getRefCodeField() {

		return "code_bed";
	}

	@Override
	public String getRefNameField() {

		return "name_pat";
	}

	@Override
	public String getTableName() {
		return "wardPativisit";
	}

	@Override
	public String getRefSql() {

		String id_dep_nur = (String) this.getExtendAttributeValue("Id_dep_nur");//就诊病区
		
		String id_dep_phy = (String) this.getExtendAttributeValue("Id_dep_phy");//就诊科室

		StringBuffer SqlStr = new StringBuffer();

		SqlStr.append(" select * from                                                           ");
		SqlStr.append(" (                                                                       ");
		SqlStr.append("   select                                                                ");
		SqlStr.append("   enentip.name_bed as code_bed,                                         ");
		SqlStr.append("   pat.code as code_pat,                                                 ");
		SqlStr.append("   enent.name_pat,                                                       ");
		SqlStr.append("   enent.id_ent,                                                         ");
		SqlStr.append("   pat.id_pat,                                                           ");
		SqlStr.append("   pat.code_amr_ip,                                                      ");
		SqlStr.append("   enent.id_dep_nur,                                                     ");
		SqlStr.append("   enent.id_dep_phy,                                                     ");
		SqlStr.append("   pat.pycode,                                                           ");
		SqlStr.append("   pat.wbcode,                                                           ");
		SqlStr.append("   pat.mnecode,                                                          ");
		SqlStr.append("   enentip.fg_newborn                                                    ");
		SqlStr.append("   from en_ent_ip enentip                                                ");
		SqlStr.append("   inner join en_ent enent on enent.id_ent=enentip.id_ent and fg_ip='Y'  ");
		SqlStr.append("   inner join pi_pat pat on pat.id_pat=enent.id_pat                      ");
		SqlStr.append("   where 1=1 ");
		String orgSql = EnvContextUtil.processEnvContext("", new PatiVisitDO(), "enent");
		if(!StringUtil.isEmptyWithTrim(orgSql)){
			SqlStr.append(" and " + orgSql);
		}
		SqlStr.append("   order by enentip.name_bed,pat.code                                    ");
		SqlStr.append(" )wardPativisit where 1=1                                                ");

		if (!StringUtil.isEmptyWithTrim(id_dep_nur)) {
			SqlStr.append(" and id_dep_nur = '" + id_dep_nur + "'");
		}
		
		if (!StringUtil.isEmptyWithTrim(id_dep_phy)) {
			SqlStr.append(" and id_dep_phy = '" + id_dep_phy + "'");
		}

		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				SqlStr.append(" And (").append(where).append(") ");
			}
		}
		return SqlStr.toString();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { "name_pat", "code_pat", "pycode", "wbcode", "code_bed", "code_amr_ip", "mnecode" };
	}
}
