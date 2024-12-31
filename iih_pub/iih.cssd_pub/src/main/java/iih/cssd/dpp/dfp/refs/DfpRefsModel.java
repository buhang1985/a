package iih.cssd.dpp.dfp.refs;

import java.util.ArrayList;
import java.util.List;

import iih.bd.utils.BdEnvContextUtil;
import iih.cssd.dpp.dfp.d.CssdDfpDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class DfpRefsModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { CssdDfpDO.NO_BAR, CssdDfpDO.NAME, CssdDfpDO.DT_PRD, CssdDfpDO.DT_INVAL };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { CssdDfpDO.ID_DFP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "识别码", "名称", "生产时间", "失效时间" };
	}

	@Override
	public String getPkFieldCode() {
		return CssdDfpDO.ID_DFP;
	}

	@Override
	public String getRefCodeField() {
		return CssdDfpDO.NO_BAR;
	}

	@Override
	public String getRefNameField() {
		return CssdDfpDO.NAME;
	}

	@Override
	public String getTableName() {
		return new CssdDfpDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { CssdDfpDO.NAME, CssdDfpDO.NO_BAR, CssdDfpDO.WBCODE, CssdDfpDO.PYCODE, CssdDfpDO.MNECODE };
	}

	@Override
	public List<String> getOrderPart() {
		List<String> order = new ArrayList<String>();
		order.add(CssdDfpDO.DT_INVAL);
		order.add(CssdDfpDO.NO_BAR);
		return order;
	}

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(BdEnvContextUtil.processEnvContext(new CssdDfpDO(), false));
		return listWhereParts;
	}
}
