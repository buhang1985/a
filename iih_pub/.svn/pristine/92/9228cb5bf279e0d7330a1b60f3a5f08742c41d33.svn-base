package iih.nm.nqm.nmnqmspcs.refs;

import iih.bd.utils.BdEnvContextUtil;
import iih.nm.nqm.nmnqmspcs.d.NmNqmSpcsKpiDo;

import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;

public class NmNqmSpcsKpiRefModel extends RefGridModel{

	@Override
	public String[] getBlurFields() {
		return super.getBlurFields();
	}

	@Override
	public String getPkFieldCode() {
		return NmNqmSpcsKpiDo.ID_NQM_SPCS_KPI;
	}

	@Override
	public String getRefCodeField() {
		return NmNqmSpcsKpiDo.CODE;
	}

	@Override
	public String getRefNameField() {
		return NmNqmSpcsKpiDo.NAME;
	}

	@Override
	public String getTableName() {
		return new NmNqmSpcsKpiDo().getTableName();
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] {NmNqmSpcsKpiDo.ID_NQM_SPCS_KPI};
	}

	@Override
	public String[] getShowFieldCode() {
		return new String[] { NmNqmSpcsKpiDo.NAME, NmNqmSpcsKpiDo.CODE,NmNqmSpcsKpiDo.FG_ACTIVE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "指标名称", "指标编码", "启用状态" };
	}
	
	@Override
	public List<String> getWherePart() {
		List<String> wherePart = super.getWherePart();
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new NmNqmSpcsKpiDo(), false);
		wherePart.add(BdModeWherePart);
		return wherePart;
	}  
	
}
