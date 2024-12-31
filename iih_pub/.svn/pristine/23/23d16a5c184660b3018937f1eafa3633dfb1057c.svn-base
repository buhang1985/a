package iih.mp.dg.ipdgapp.refs;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PatiRefModel extends RefGridModel {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		
		return new String[] { "code_pat", "name_pat", "code_bed" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		
		return new String[] { "id_pat", "code_entp" };
	}

	@Override
	public String[] getShowFieldName() {
		
		return new String[] { "患者编号", "患者姓名", "床号" };
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
		return "patbed";
	}
	
	@Override
	public String getRefSql() {
		
		String depId = (String) this.getExtendAttributeValue("depId");
		
		String sql = "select * from (select pat.code as code_pat,ent.name_pat,ip.name_bed,ent.id_pat,ent.code_entp,pat.pycode,pat.wbcode,ent.id_dep_nur "
				+ "from EN_ENT_IP ip "
				+ "inner join EN_ENT ent "
				+ "on ip.id_ent = ent.id_ent "
				+ "inner join pi_pat pat "
				+ "on ent.id_pat = pat.id_pat "
				+ "where ent.fg_ip = 'Y') patbed  where 1=1 ";
		
		if(!StringUtil.isEmpty(depId)){
			sql += " and patbed.id_dep_nur = '"+depId+"'";
		}
		
		StringBuilder sb = new StringBuilder(sql);
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			//sb.append(" Where 1=1 ");
			for (String where : this.getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}

		return sb.toString();		
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[]{"name_pat","code_pat","pycode","wbcode","name_bed" };
	}
}
