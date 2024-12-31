package iih.nmr.pkuf.nmrfactor.refs;

import iih.nmr.pkuf.nmrfactor.d.NRMFactorDO;
import xap.sys.appfw.refinfo.RefGridModel;


public class NRMFactorDORefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { NRMFactorDO.CODE, NRMFactorDO.NAME };
	}
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NRMFactorDO.ID_NMR_FACTOR,NRMFactorDO.NOTE, NRMFactorDO.FG_ACTIVE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return NRMFactorDO.ID_NMR_FACTOR;
	}

	@Override
	public String getTableName() {
		return new NRMFactorDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return NRMFactorDO.CODE;

	}

	@Override
	public String getRefNameField() {
		return NRMFactorDO.NAME;

	}

}