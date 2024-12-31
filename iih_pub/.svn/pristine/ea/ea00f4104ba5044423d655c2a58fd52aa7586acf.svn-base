package iih.pe.pitm.perules.refs;


import iih.pe.pitm.perules.d.PeRuleDefDO;
import iih.pe.comm.utils.PeEnvContextUtil;

import java.util.ArrayList;
import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.orgfw.dept.d.DeptDO;

public class PeRuleDefRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeRuleDefDO.CODE, PeRuleDefDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeRuleDefDO.ID_PERULEDEF, PeRuleDefDO.PRIORITY, PeRuleDefDO.ID_PERULEDEF_PAR };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "规则编码", "规则名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PeRuleDefDO.ID_PERULEDEF;
	}

	@Override
	public String getRefCodeField() {
		return PeRuleDefDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeRuleDefDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeRuleDefDO().getTableName();
	}


	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.addAll(super.getOrderPart());
		listOrderParts.add(PeRuleDefDO.SORTNO);
		return listOrderParts;
	}
	
	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeRuleDefDO(), false));
		return listWhereParts;
	}
}
