package iih.bd.srv.diagcatectm.refs;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class DiCaCtmRefModel extends RefGridModel{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "code", "name"};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "id_dicactmitm"};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "手术编码", "手术名称"};
	}

	@Override
	public String getPkFieldCode() {
		return "id_dicactmitm";
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
	public String getTableName(){
		return "sug";
	}
	
	@Override
	public String getRefSql() {
		
		String sql = "select sug.code, sug.name, sug.id_dicactmitm " 
				+ "from (select ITM.Id_Dicactmitm, "
				+ "CTM.Name          as ctm_name, "
				+ "ITM.Code, "
				+ "ITM.Name "
				+ "from bd_dica_ctm_itm ITM "
				+ "left join bd_dica_ctm CTM "
				+ "on ITM.Id_Dicactm = CTM.Id_Dicactm) sug where 1 = 1 "
				+ "and sug.ctm_name = '一类切口手术' ";
		
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
		return new String[]{"name","code","pycode","wbcode" };
	}
}
