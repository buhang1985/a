package iih.nmr.pkuf.nmrtrgt.refs;

import iih.nmr.pkuf.nmrtrgt.d.NmrTrgtDO;
import xap.sys.appfw.refinfo.RefGridModel;


public class NmrTrgtDORefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { NmrTrgtDO.CODE, NmrTrgtDO.NAME };
	}
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NmrTrgtDO.ID_NMR_TRGT,NmrTrgtDO.NOTE, NmrTrgtDO.FG_ACTIVE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return NmrTrgtDO.ID_NMR_TRGT;
	}

	@Override
	public String getTableName() {
		return new NmrTrgtDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return NmrTrgtDO.CODE;

	}

	@Override
	public String getRefNameField() {
		return NmrTrgtDO.NAME;

	}

}