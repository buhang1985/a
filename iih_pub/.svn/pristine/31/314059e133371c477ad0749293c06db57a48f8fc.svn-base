package iih.nmr.pkuf.nmrmea.refs;

import iih.nmr.pkuf.nmrmea.d.NmrMeaDO;
import xap.sys.appfw.refinfo.RefGridModel;


public class NmrMeaDORefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { NmrMeaDO.CODE, NmrMeaDO.NAME };
	}
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NmrMeaDO.ID_NMR_MEA,NmrMeaDO.NOTE, NmrMeaDO.FG_ACTIVE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return NmrMeaDO.ID_NMR_MEA;
	}

	@Override
	public String getTableName() {
		return new NmrMeaDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return NmrMeaDO.CODE;

	}

	@Override
	public String getRefNameField() {
		return NmrMeaDO.NAME;

	}

}