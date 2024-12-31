package iih.nm.nqm.nmnqmkpi.refs;

import iih.nm.nqm.nmnqmkpi.d.NmNqmKpiDO;
import xap.sys.appfw.refinfo.RefTreeModel;

public class NmNqmKpiRefModel extends RefTreeModel {
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { NmNqmKpiDO.NAME, NmNqmKpiDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "指标名称", "指标编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NmNqmKpiDO.ID_NQM_KPI, NmNqmKpiDO.ID_PAR };
	}

	@Override
	public String getPkFieldCode() {
		return NmNqmKpiDO.ID_NQM_KPI;
	}

	@Override
	public String getChildField() {
		return NmNqmKpiDO.ID_NQM_KPI;
	}

	@Override
	public String getFatherField() {
		return NmNqmKpiDO.ID_PAR;
	}

	@Override
	public String getRefCodeField() {

		return NmNqmKpiDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return NmNqmKpiDO.NAME;
	}

	@Override
	public String getTableName() {
		return new NmNqmKpiDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { NmNqmKpiDO.ID_NQM_KPI, NmNqmKpiDO.NAME, NmNqmKpiDO.CODE, NmNqmKpiDO.PYCODE, NmNqmKpiDO.WBCODE, NmNqmKpiDO.NMECODE };
	}
}
