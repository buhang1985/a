package iih.ems.embd.emstca.refs;


import java.util.List;

import xap.lui.core.xml.StringUtils;
import xap.sys.appfw.refinfo.RefGridModel;




public class EmstcaRefGridModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1;

	@Override
	public String getPkFieldCode() {
		return "id_ca";
	}

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "name", "code" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "名称", "编码" };
	}
	
	@Override
	public String getRefNameField() {
		return "name";
	}
	@Override
	public String getRefCodeField() {
		return "code";
	}
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "id_ca" };
	}

	@Override
	public String getTableName() {
		return "EMS_STCA";
	}
	@Override
	public String[] getBlurFields() {
		return new String[] { "name", "code"};
	}
	@Override
	public String getRefSql() {
		StringBuffer SQL = new StringBuffer();
		SQL.append(" SELECT ");
		SQL.append("     name, ");
		SQL.append("     code, ");
		SQL.append("     id_ca  ");
		SQL.append(" FROM ");
		SQL.append("     EMS_STCA where 1=1 ");
		
		String sd_direct = (String) this.getExtendAttributeValue("sd_direct");
		if(StringUtils.isNotBlank(sd_direct))
		{
			SQL.append(" and sd_direct = '"+sd_direct+"' ");
		}
		 StringBuilder sb = new StringBuilder(SQL);
			List<String> whereList = this.getWherePart();
			if (whereList.size() > 0) {
				for (String where : this.getWherePart()) {
					sb.append(" And (").append(where).append(") ");
				}
			}
			
		String aSql = sb.toString();
		return aSql;
	}
}