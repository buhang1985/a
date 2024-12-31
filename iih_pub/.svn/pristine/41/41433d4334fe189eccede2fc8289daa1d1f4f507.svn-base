package iih.pe.pbd.pedeptset.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.pbd.pedeptset.d.PeDeptSetDO;
import iih.pe.pitm.pesrvsetdef.d.PeSrvSetDefDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeDeptSetRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {

		return new String[] { PeDeptSetDO.NAME, PeDeptSetDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "名称", "编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeDeptSetDO.ID_PEDEPTSET };
	}

	@Override
	public String getPkFieldCode() {
		return PeDeptSetDO.ID_PEDEPTSET;
	}
	
	@Override
	public String getRefCodeField() {
		return PeDeptSetDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeDeptSetDO.NAME;
	}
	
	
	@Override
	public String getTableName() {
		return new PeDeptSetDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.addAll(super.getOrderPart());
		listOrderParts.add(PeDeptSetDO.SORTNO);
		return listOrderParts;
	}
	

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeDeptSetDO(), false));
		return listWhereParts;
	}
}
