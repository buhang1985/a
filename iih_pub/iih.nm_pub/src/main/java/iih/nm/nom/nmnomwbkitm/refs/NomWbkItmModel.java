package iih.nm.nom.nmnomwbkitm.refs;

import iih.nm.nom.nmnomwbkitm.d.NmNomWbkItmDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NomWbkItmModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {

		return new String[] { NmNomWbkItmDO.NAME };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "手册条目" };
	}

	@Override
	public String[] getHiddenFieldCode() {

		return new String[] { NmNomWbkItmDO.ID_NOM_WBK_ITM };
	}

	@Override
	public String getPkFieldCode() {

		return NmNomWbkItmDO.ID_NOM_WBK_ITM;
	}

	@Override
	public String getRefCodeField() {

		return NmNomWbkItmDO.ID_NOM_WBK_ITM;
	}

	@Override
	public String getRefNameField() {

		return NmNomWbkItmDO.NAME;
	}

	@Override
	public String getTableName() {

		return new NmNomWbkItmDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {

		return super.getBlurFields();
	}

}
