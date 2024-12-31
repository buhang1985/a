package iih.pe.pitm.pesrvitemoptional.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.pitm.pesrvitemoptional.d.PeSrvItmOptDefDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeSrvItmOptDefRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {

		return new String[] { PeSrvItmOptDefDO.NAME, PeSrvItmOptDefDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "名称", "编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeSrvItmOptDefDO.ID_PESRVITMOPTDEF};
	}

	@Override
	public String getPkFieldCode() {
		return PeSrvItmOptDefDO.ID_PESRVITMOPTDEF;
	}
	
	@Override
	public String getRefCodeField() {
		return PeSrvItmOptDefDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeSrvItmOptDefDO.NAME;
	}
	
	
	@Override
	public String getTableName() {
		return new PeSrvItmOptDefDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		return listOrderParts;
	}


	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeSrvItmOptDefDO(), false));
		return listWhereParts;
	}
}
