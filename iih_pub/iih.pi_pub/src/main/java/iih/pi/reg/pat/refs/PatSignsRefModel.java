package iih.pi.reg.pat.refs;

import xap.sys.appfw.refinfo.RefGridModel;

public class PatSignsRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub
		return new String[] { "Entcode", "Bedcode", "Name", "Sex", "Age",
				"Complaint", "Indates", "Docname" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		// TODO Auto-generated method stub
		return new String[] { "Id_ent", "Id_pat", "Patientcode" };
	}

	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[] { "住院号", "床号", "患者姓名", "性别", "年龄", "主诉", "住院天数",
				"医师" };
	}

	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return "Id_ent";
	}

	@Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return "Patientcode";
	}

	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return "Name";
	}

	@Override
	public String getRefSql() {

		String code_entp = (String) this.getExtendAttributeValue("code_entp");
		String sd_status = (String) this.getExtendAttributeValue("sd_status");
		String id_dep_nur = (String) this.getExtendAttributeValue("id_dep_nur");
		String refSql = "select "
				+ "enent.code as entcode,/*住院号*/"
				+ "(select code_bed from EN_ENT_IP enentip where enentip.id_ent=enent.id_ent ) as bedcode,/*床号*/"
				+ "enent.name_pat as name,/*姓名*/"
				+ "(case when enent.id_sex_pat=0 then '未知' when enent.id_sex_pat=1 then '男' when enent.id_sex_pat=2 then '女' when enent.id_sex_pat=9 then '未说明' else null end)as sex,/*性别*/"
				+ "TRUNC(months_between(sysdate, to_date(substr(enent.dt_birth_pat,1,10),'yyyy-mm-dd'))/12) as age,/*年龄*/"
				+ "null as complaint,/*主诉*/"
				+ "TRUNC(sysdate-to_date(substr(nvl(enent.dt_acpt,sysdate),1,10),'yyyy-mm-dd')) as indates,/*住院天数*/"
				+ "psndoc.name as docname, /*主治医生*/ "
				+ "enent.id_ent,"
				+ "enent.id_pat,"
				+ "patient.code as patientcode/*患者编号*/ "
				+ "from en_ent enent "
				+ "left join bd_psndoc psndoc on psndoc.id_psndoc=enent.id_emp_phy "
				+ "left join pi_pat patient on enent.id_pat=patient.id_pat ";
		refSql += "where enent.code_entp='" + code_entp + "' "
				+ "and enent.sd_status='" + sd_status + "' "
				+ "and enent.id_dep_nur='" + id_dep_nur + "' ";
		return refSql;
	}
}
