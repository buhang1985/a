package iih.ems.embd.detp.refs;


import xap.sys.appfw.refinfo.RefGridModel;




public class DetpRefGridModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1;

	@Override
	public String getPkFieldCode() {
		return "id_de";
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
		return new String[] { "id_de" };
	}

	@Override
	public String getTableName() {
		return "EMS_DETP";
	}

	public String getRefSql() {
		StringBuffer SQL = new StringBuffer();
		SQL.append(" SELECT ");
		SQL.append("     name, ");
		SQL.append("     code, ");
		SQL.append("     id_de  ");
		SQL.append(" FROM ");
		SQL.append("     EMS_DETP ");
		
		String aSql = super.getRefSql();
		return aSql;
	}
}