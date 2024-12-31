package iih.bd.srv.mrctmca.refs;

import iih.bd.srv.emrtype.d.MrTpDO;
import iih.bd.srv.mrctmca.d.MrCtmCaDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefTreeModel;

public class MrTplRefTreeModel extends RefTreeModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3396741874582608618L;

	@Override
	public String getPkFieldCode() {
		return "id_child";
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
		return "id_child";
	}

	@Override
	public String getFatherField() {
		return "id_parent";
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "id_child", "id_parent" };
	}

	@Override
	public String getTableName() {
		return "A";
	}

	public String getRefSql() {
		StringBuffer SQL = new StringBuffer();
		SQL.append(" from ( \n");
		SQL.append(" SELECT \n");
		SQL.append("     name, \n");
		SQL.append("     code, \n");
		SQL.append("     ID_MRCACTM AS id_child, \n");
		SQL.append("     NULL       AS id_parent \n");
		SQL.append(" FROM \n");
		SQL.append("     BD_MRCA_CTM BD_MRCA_CTM WHERE 1=1 and "+BdEnvContextUtil.processEnvContext(new MrCtmCaDO(), false)+"\n");
		SQL.append(" UNION \n");
		SQL.append(" SELECT \n");
		SQL.append("     name, \n");
		SQL.append("     code, \n");
		SQL.append("     ID_MRCACTM || ':' || BD_MRTP.ID_MRTP AS id_child, \n");
		SQL.append("     ID_MRCACTM                           AS id_parent \n");
		SQL.append(" FROM \n");
		SQL.append("     BD_MRCA_CTM_ITM \n");
		SQL.append(" INNER JOIN \n");
		SQL.append("     BD_MRTP BD_MRTP \n");
		SQL.append(" ON \n");
		SQL.append("     BD_MRCA_CTM_ITM.ID_MRTP = BD_MRTP.ID_MRTP  where 1=1 and "+ BdEnvContextUtil.processEnvContext(new MrTpDO(), false) +")");
		
		String aSql = super.getRefSql().replaceAll("from A", SQL.toString());
		return aSql;
	}
}