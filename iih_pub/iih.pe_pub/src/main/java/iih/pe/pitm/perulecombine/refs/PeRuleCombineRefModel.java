package iih.pe.pitm.perulecombine.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.comm.utils.PeEnvContextUtil;
import iih.pe.pitm.perulecombine.d.PeRuleCombineDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeRuleCombineRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeRuleCombineDO.CODE, PeRuleCombineDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeRuleCombineDO.ID_PERULECOMBINE, PeRuleCombineDO.ID_PERULECOMBINE_PAR };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PeRuleCombineDO.ID_PERULECOMBINE;
	}

	@Override
	public String getRefCodeField() {
		return PeRuleCombineDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeRuleCombineDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeRuleCombineDO().getTableName();
	}


	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.addAll(super.getOrderPart());
		listOrderParts.add(PeRuleCombineDO.SORTNO);
		return listOrderParts;
	}
	
	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeRuleCombineDO(), false));
		return listWhereParts;
	}

}
