package iih.nmr.pkuf.fivecolor.refs;

import java.util.List;
import iih.nmr.pkuf.fivecolor.d.FCCMBdDataDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class FiveColorRefsModel extends RefGridModel {

	@Override
	public String[] getBlurFields() {
		return new String[] { FCCMBdDataDO.NAME, FCCMBdDataDO.CODE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { FCCMBdDataDO.ID_FCCMBDDATA };
	}

	@Override
	public String getPkFieldCode() {
		return FCCMBdDataDO.ID_FCCMBDDATA;
	}

	@Override
	public String getRefCodeField() {
		return FCCMBdDataDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return FCCMBdDataDO.NAME;
	}

	@Override
	public String[] getShowFieldCode() {
		return new String[] { FCCMBdDataDO.CODE, FCCMBdDataDO.NAME };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getTableName() {
		return new FCCMBdDataDO().getTableName();
	}

	

}
