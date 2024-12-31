package iih.pe.phm.pehmriskrule.refs;

import iih.pe.phm.pehmriskrule.d.PeHmRiskRuleDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeHmRiskRuleRefModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[]{PeHmRiskRuleDO.CODE,PeHmRiskRuleDO.NAME};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{PeHmRiskRuleDO.ID_RISKRULE};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"编码","名称"};
	}
	
	@Override
	public String getPkFieldCode() {
		return PeHmRiskRuleDO.ID_RISKRULE;
	}
	
	@Override
	public String getRefCodeField() {
		return PeHmRiskRuleDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		return PeHmRiskRuleDO.NAME;
	}
	
	@Override
	public String getTableName() {
		return new PeHmRiskRuleDO().getTableName();
	}

}
