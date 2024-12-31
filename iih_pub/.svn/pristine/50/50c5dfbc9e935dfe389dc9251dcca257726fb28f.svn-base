package iih.nmr.pkuf.nmrdi.refs;

import iih.nmr.pkuf.nmrdi.d.NmrDiDO;
import iih.nmr.pkuf.nmrdica.d.NmrDiCaDO;
import xap.sys.appfw.refinfo.RefTreeModel;

/**
 * 文书分类参照模型
 * @author Hcst
 *
 */
public class NmrDiDORefModel extends RefTreeModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { NmrDiDO.CODE, NmrDiCaDO.NAME };
	}
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NmrDiDO.ID_NMR_DI, NmrDiCaDO.NOTE};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return NmrDiCaDO.ID_DICA;
	}

	@Override
	public String getTableName() {
		return new NmrDiDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return NmrDiDO.CODE;

	}

	@Override
	public String getRefNameField() {
		return NmrDiDO.NAME;

	}
	
	@Override
	public String getChildField() {
		return NmrDiDO.ID_NMR_DI;
	}
}
