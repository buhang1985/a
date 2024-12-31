package iih.nm.nom.nomwkitm.refs;

import iih.nm.nom.nomwkitm.d.NomWkitmDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NomWkitmRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { NomWkitmDO.SORTNO, NomWkitmDO.NAME, NomWkitmDO.FG_ACTIVE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NomWkitmDO.ID_NOM_WKITM };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "序号", "项目" ,"是否启用"};
	}

	@Override
	public String getPkFieldCode() {
		return NomWkitmDO.ID_NOM_WKITM;
	}

	@Override
	public String getRefCodeField() {
		return NomWkitmDO.ID_NOM_WKITM;
	}

	@Override
	public String getRefNameField() {
		return NomWkitmDO.NAME;
	}

	@Override
	public String getTableName() {
		return new NomWkitmDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { NomWkitmDO.NAME };
	}		
}
