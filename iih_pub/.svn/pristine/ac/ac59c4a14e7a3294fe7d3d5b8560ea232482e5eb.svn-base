package iih.ems.embd.emca.refs;

import xap.sys.appfw.refinfo.RefTreeModel;

public class EmcaRefTreeModel extends RefTreeModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1;

	@Override
	public String getPkFieldCode() {
		return "id_emca";
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
		return "id_emca";
	}

	@Override
	public String getFatherField() {
		return "id_parent";
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "id_emca", "id_parent" };
	}

	@Override
	public String getTableName() {
		return "EMS_CA";
	}

	public String getRefSql() {
		StringBuffer SQL = new StringBuffer();
		SQL.append(" SELECT ");
		SQL.append("     name, ");
		SQL.append("     code, ");
		SQL.append("     id_emca , ");
		SQL.append("     id_parent ");
		SQL.append(" FROM ");
		SQL.append("     EMS_CA ");
		
		String aSql = super.getRefSql();
		return aSql;
	}
}