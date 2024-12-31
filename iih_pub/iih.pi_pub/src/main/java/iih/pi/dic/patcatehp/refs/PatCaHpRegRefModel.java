package iih.pi.dic.patcatehp.refs;

import iih.pi.dic.patientcategory.d.PiPatCaDO;

import java.util.List;

import xap.sys.appfw.refinfo.RefTreeModel;
import xap.sys.permfw.pub.EnvContextUtil;

public class PatCaHpRegRefModel extends RefTreeModel {
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"编码","患者分类","价格分类","信用分类","医保计划","险种","持卡标志","特病标志"};
	}
	
	@Override
	public String[] getShowFieldCode() {
		return new String[]{"code", "name", "name_patpri", "name_patcret", "name_hp", "name_hpkind", "fg_hp_card", "fg_hp_spcl"};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{ "id_patca", "id_pripat", "code_pripat", "id_patcret", "code_patcret", "id_hp", "code_hp", "id_hpkind", "code_hpkind", "fg_fundpay", "id_parent", 
				"wbcode", "pycode", "mnecode" };
	}
	@Override
	public String[] getBlurFields() {
		return new String[]{"code", "name", "wbcode", "pycode", "mnecode"};
	}
	@Override
	public String getPkFieldCode() {
		return "id_patca";
	}
	@Override
	public String getRefCodeField() {
		return "code";
	}
	@Override
	public String getRefNameField() {
		return "name";
	}
	@Override
	public String getFatherField() {
		return "id_parent";
	}
	@Override
	public String getChildField() {
		return "id_patca";
	}
	@Override
	public String getTableName() {
		return "pi_pat_ca";
	}
	@Override
	public String getRefSql() {
		String sql ="select pi_pat_ca.code,"
				+ "pi_pat_ca.name,"
				+ "bd_pri_pat.name as name_patpri,"
				+ "pi_pat_cret.name as name_patcret,"
				+ "bd_hp.name as name_hp,"
				+ "bd_hp_kind.name_hpkind as name_hpkind,"
				+ "pi_pat_ca_hp.fg_hp_card,"
				+ "pi_pat_ca_hp.fg_hp_spcl,"
				+ "pi_pat_ca.id_patca,"
				+ "bd_pri_pat.id_pripat,"
				+ "bd_pri_pat.code as code_pripat,"
				+ "pi_pat_cret.id_patcret,"
				+ "pi_pat_cret.code as code_patcret,"
				+ "bd_hp.id_hp,"
				+ "bd_hp.code as code_hp,"
				+ "bd_hp_kind.id_hpkind,"
				+ "bd_hp_kind.code_hpkind,"
				+ "pi_pat_ca_hp.fg_fundpay,"
				+ "pi_pat_ca.id_parent,"
				+ "pi_pat_ca.wbcode,"
				+ "pi_pat_ca.pycode,"
				+ "pi_pat_ca.mnecode "
				+ "from pi_pat_ca pi_pat_ca "
				+ "left join bd_pri_pat bd_pri_pat on pi_pat_ca.id_patpritp = bd_pri_pat.id_pripat "
				+ "left join pi_pat_cret pi_pat_cret on pi_pat_ca.id_patcrettp = pi_pat_cret.id_patcret "
				+ "left join pi_pat_ca_hp pi_pat_ca_hp on pi_pat_ca.id_patca = pi_pat_ca_hp.id_patca "
				+ "left join bd_hp bd_hp on pi_pat_ca_hp.id_hp = bd_hp.id_hp "
				+ "left join bd_hp_kind bd_hp_kind on pi_pat_ca_hp.id_hpkind = bd_hp_kind.id_hpkind ";
		StringBuilder sb = new StringBuilder(sql);
		sb.append(" where 1=1 ");
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			
			for (String where : this.getWherePart()) {
				sb.append(" and (").append(where).append(") ");
			}
		}
		String orgStr = EnvContextUtil.processEnvContext("", new PiPatCaDO(), "pi_pat_ca");
		sb.append(String.format(" and %s ", orgStr));
		sb.append(" order by pi_pat_ca.code ");
		return sb.toString();
	}
}
