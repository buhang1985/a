package iih.mp.dg.opdrugdisp.refs;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class OpPatRefModel extends RefGridModel{

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "code_pat", "name_pat"};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "id_pat"};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "患者编号", "患者姓名"};
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
		return "oppat";
	}
	
	@Override
	public String getRefSql() {
		
		String depId = (String) this.getExtendAttributeValue("depId");
		
		String sql = "select * from ( " 
				+ "select distinct  pat.code code_pat, pat.name name_pat,ent.id_pat,pat.pycode,pat.wbcode,ent.id_dep_nur "
				+ "from EN_ENT_OP op "
				+ "inner join EN_ENT ent on op.id_ent = ent.id_ent "
				+ "inner join pi_pat pat on ent.id_pat = pat.id_pat "
				+ "where ent.fg_ip = 'N') oppat  where 1=1 ";
		
		if(!StringUtil.isEmpty(depId)){
			sql += " and oppat.id_dep_nur = '"+depId+"'";
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
		return new String[]{"name_pat","code_pat","pycode","wbcode" };
	}
	
}
