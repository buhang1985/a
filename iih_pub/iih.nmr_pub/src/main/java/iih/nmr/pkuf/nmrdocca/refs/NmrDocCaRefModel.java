package iih.nmr.pkuf.nmrdocca.refs;

import iih.nmr.pkuf.nmrdocca.d.NmrDocCaDO;
import xap.sys.appfw.refinfo.RefTreeModel;

/**
 * 文书分类参照模型
 * @author Hcst
 *
 */
public class NmrDocCaRefModel extends RefTreeModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { NmrDocCaDO.CODE, NmrDocCaDO.NAME };
	}
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NmrDocCaDO.ID_NMR_DOCCA, NmrDocCaDO.ID_PAR };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return NmrDocCaDO.ID_NMR_DOCCA;
	}

	@Override
	public String getTableName() {
		return new NmrDocCaDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return NmrDocCaDO.CODE;

	}

	@Override
	public String getRefNameField() {
		return NmrDocCaDO.NAME;

	}
	
	@Override
	public String getFatherField() {
		return NmrDocCaDO.ID_PAR;
	}
	
	@Override
	public String getChildField() {
		return NmrDocCaDO.ID_NMR_DOCCA;
	}
	

}
