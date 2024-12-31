package iih.mkr.std.commondeval.refs;

import iih.mkr.std.commondeval.d.DataElementValDO;
import iih.mkr.utils.MkrEnvContextUtil;

import java.util.ArrayList;
import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;

public class CommonDeValRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { DataElementValDO.CODE, DataElementValDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DataElementValDO.VALDOMAINCODE,DataElementValDO.ID_DE_VAL };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return DataElementValDO.ID_DE_VAL;
	}

	@Override
	public String getRefCodeField() {
		return DataElementValDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return DataElementValDO.NAME;
	}

	@Override
	public String getTableName() {
		return new DataElementValDO().getTableName();
	}

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(MkrEnvContextUtil.processEnvContext(new DataElementValDO(), false));
		return listWhereParts;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { DataElementValDO.CODE, DataElementValDO.NAME, DataElementValDO.PYCODE, DataElementValDO.WBCODE, DataElementValDO.MNECODE };
	}
}
