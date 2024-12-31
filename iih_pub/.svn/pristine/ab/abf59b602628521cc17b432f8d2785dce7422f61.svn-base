package iih.en.pv.inpatient.refs;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 科室病区出院患者参照（支持指定病区和就诊科室含ID_ENT）
 *
 * @author mameng_2019-02-22
 *
 */
public class IpOutPatEntRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { "code_pat", "name_pat" };
	}
	

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "id_pat", "code_amr_ip", "id_ent" };
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[] { "患者编号", "患者姓名" };
	}

	@Override
	public String getPkFieldCode() {
		return "id_pat";
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
	public String getTableName(){
		return "patentip";
	}
	
	@Override
	public String getRefSql() {
		
		String depId = (String) this.getExtendAttributeValue("depId");
		
		String sql = "select * from (select distinct pat.code as code_pat,ent.name_pat,ent.id_pat,ip.code_amr_ip,ip.id_ent,pat.pycode,pat.wbcode,ent.id_dep_nur "
				+ "from en_ent_ip ip "
				+ "inner join en_ent ent "
				+ "on ip.id_ent = ent.id_ent "
				+ "inner join pi_pat pat "
				+ "on ent.id_pat = pat.id_pat "
				+ "where ip.sd_status = '28' order by pat.code ) patentip  where 1=1 ";
		
		if(!StringUtil.isEmpty(depId)){
			sql += " and patentip.id_dep_nur = '"+depId+"'";
		}
		
		StringBuilder sb = new StringBuilder(sql);
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}

		return sb.toString();	
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[]{"name_pat","code_pat","pycode","wbcode","code_amr_ip", "id_ent" };
	}
}
