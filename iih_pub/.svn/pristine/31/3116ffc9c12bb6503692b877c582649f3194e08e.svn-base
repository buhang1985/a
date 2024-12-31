package iih.mp.mb.mbbc.refs;

import iih.mp.mb.mbbc.d.MbBcDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class MbBcDOModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		
		return new String[] {  MbBcDO.NAME, MbBcDO.CODE};
	}

	@Override
	public String[] getShowFieldName() {
	
		return new String[] { "条码对照名称", "条码对照编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {

		return new String[] {MbBcDO.ID_MB_BC };
	}

	@Override
	public String getPkFieldCode() {

		return MbBcDO.ID_MB_BC;
	}

	@Override
	public String getRefCodeField() {

		return MbBcDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return MbBcDO.NAME;
	}

	@Override
	public String getTableName() {
		return new MbBcDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MbBcDO.ID_MB_BC, MbBcDO.NAME,MbBcDO.CODE, MbBcDO.PYCODE, MbBcDO.WBCODE, MbBcDO.MNECODE };
	}


}
