package iih.bd.srv.mrctmca.refs;

import xap.sys.appfw.refinfo.RefTreeGridModel;

public class MrTplRefTreeGridModel extends RefTreeGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4581621676179321985L;

	@Override
	public String getClassTableName() {
		return "BD_MRCA_CTM";
	}

	@Override
	public String[] getClassFieldCode() {
		return new String[] { "CODE", "NAME", "ID_MRCACTM", "ID_PARENT" };
	}

	@Override
	public String getClassPkFieldCode() {
		return "ID_MRCACTM";
	}

	@Override
	public String getClassRefCodeField() {
		return "CODE";
	}

	@Override
	public String getClassRefNameField() {
		return "NAME";
	}

	@Override
	public String getClassJoinField() {
		return "ID_MRCACTM";
	}

	@Override
	public String getDocJoinField() {
		return "ID_MRCACTM";
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "BD_MRTP.ID_MRTP" };
	}

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "BD_MRTP.CODE", "BD_MRTP.NAME" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getTableName() {
		return "BD_MRCA_CTM_ITM";
	}

	@Override
	public String getPkFieldCode() {
		return "BD_MRTP.ID_MRTP";
	}

	@Override
	public String getRefCodeField() {
		return "BD_MRTP.CODE";
	}

	@Override
	public String getRefNameField() {
		return "BD_MRTP.NAME";
	}

	@Override
	public String getRefSql() {
		String joinValue = getClassJoinValue();
		StringBuffer SQL = new StringBuffer();
		SQL.append("SELECT \n");
		SQL.append("    bd_mrtp.code, \n");
		SQL.append("    bd_mrtp.name, \n");
		SQL.append("    bd_mrtp.id_mrtp \n");
		SQL.append("FROM \n");
		SQL.append("    bd_mrca_ctm_itm \n");
		SQL.append("JOIN \n");
		SQL.append("    bd_mrca_ctm \n");
		SQL.append("ON \n");
		SQL.append("    bd_mrca_ctm_itm.id_mrcactm = bd_mrca_ctm.id_mrcactm \n");
		SQL.append("JOIN \n");
		SQL.append("    bd_mrtp \n");
		SQL.append("ON \n");
		SQL.append("    bd_mrca_ctm_itm.id_mrtp = bd_mrtp.id_mrtp \n");
		SQL.append("WHERE \n");
		SQL.append("    1=1 \n");
		SQL.append("AND bd_mrca_ctm.id_mrcactm = '" + joinValue + "'");

		return SQL.toString();
	}

	// @Override
	// public String getClassRefSql() {
	// return super.getClassRefSql();
	// }

	@Override
	public String getChildField() {
		return "ID_MRCACTM";
	}

	@Override
	public String getFatherField() {
		return "ID_PARENT";
	}
}