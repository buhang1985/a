package iih.ems.embd.emgeca.refs;

import xap.sys.appfw.refinfo.RefTreeModel;

public class EmGecaRefTreeModel extends RefTreeModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1;

	@Override
	public String getPkFieldCode() {
		return "id_geca";
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
	public String getChildField() {
		return "id_geca";
	}

	@Override
	public String getFatherField() {
		return "id_parent";
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "id_geca", "id_parent" };
	}

	@Override
	public String getTableName() {
		return "ems_geca";
	}

	public String getRefSql() {
		StringBuffer SQL = new StringBuffer();
		SQL.append(" SELECT ");
		SQL.append("     name,");
		SQL.append("     code,");
		SQL.append("      id_geca, ");
		SQL.append("      id_parent ");
		
		
		SQL.append(" FROM "); 
		SQL.append("ems_geca");
		String aSql = super.getRefSql();
		return aSql;
	}
	
}