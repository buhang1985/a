package iih.nmr.pkuf.nmrdica.refs;

import iih.nmr.pkuf.nmrdica.d.NmrDiCaDO;
import xap.sys.appfw.refinfo.RefTreeModel;

/**
 * 文书分类参照模型
 * @author Hcst
 *
 */
public class NmrDiCaDORefModel extends RefTreeModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { NmrDiCaDO.CODE, NmrDiCaDO.NAME };
	}
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NmrDiCaDO.ID_DICA, NmrDiCaDO.ID_PAR ,NmrDiCaDO.NOTE};
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
		return new NmrDiCaDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return NmrDiCaDO.CODE;

	}

	@Override
	public String getRefNameField() {
		return NmrDiCaDO.NAME;

	}
	
	@Override
	public String getFatherField() {
		return NmrDiCaDO.ID_PAR;
	}
	
	@Override
	public String getChildField() {
		return NmrDiCaDO.ID_DICA;
	}
	

}
