package iih.nm.nqm.qctplcamaintenance.refs;

import xap.sys.appfw.refinfo.RefTreeModel;
import iih.nm.nqm.qctplcamaintenance.d.NmQctplCaDO;

public class NmQctplCaDOModel extends RefTreeModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { NmQctplCaDO.NAME, NmQctplCaDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "分类名称", "分类编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NmQctplCaDO.ID_QCTPL_CA, NmQctplCaDO.ID_PAR };
	}

	@Override
	public String getPkFieldCode() {
		return NmQctplCaDO.ID_QCTPL_CA;
	}

	@Override
	public String getChildField() {
		return NmQctplCaDO.ID_QCTPL_CA;
	}

	@Override
	public String getFatherField() {
		return NmQctplCaDO.ID_PAR;
	}

	@Override
	public String getRefCodeField() {

		return NmQctplCaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return NmQctplCaDO.NAME;
	}

	@Override
	public String getTableName() {
		return new NmQctplCaDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { NmQctplCaDO.ID_QCTPL_CA, NmQctplCaDO.NAME, NmQctplCaDO.CODE, NmQctplCaDO.PYCODE, NmQctplCaDO.WBCODE, NmQctplCaDO.MNECODE };
	}

}
