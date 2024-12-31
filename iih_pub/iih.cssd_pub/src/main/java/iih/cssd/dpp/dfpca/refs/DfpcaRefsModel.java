package iih.cssd.dpp.dfpca.refs;

import iih.cssd.dpp.dfpca.d.CssdDfpCaDO;
import xap.sys.appfw.refinfo.RefTreeModel;

public class DfpcaRefsModel extends RefTreeModel{

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { CssdDfpCaDO.CODE, CssdDfpCaDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { CssdDfpCaDO.ID_DFP_CA, CssdDfpCaDO.ID_PARENT};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return CssdDfpCaDO.ID_DFP_CA;
	}

	@Override
	public String getChildField() {
		return CssdDfpCaDO.ID_DFP_CA;
	}

	@Override
	public String getFatherField() {
		return CssdDfpCaDO.ID_PARENT;
	}

	@Override
	public String getRefCodeField() {
		return CssdDfpCaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return CssdDfpCaDO.NAME;
	}
	
	@Override
	public String getTableName() {
		return new CssdDfpCaDO().getTableName();
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[] { CssdDfpCaDO.NAME, CssdDfpCaDO.CODE};
	};
}
