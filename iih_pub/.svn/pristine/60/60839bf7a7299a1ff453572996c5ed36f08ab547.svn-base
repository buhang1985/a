package iih.pe.pitm.pesrvrptgrp.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.pitm.pesrvrptgrp.d.PeSrvrPtGrpDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeSrvrPtGrpRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {

		return new String[] { PeSrvrPtGrpDO.NAME, PeSrvrPtGrpDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "名称", "编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeSrvrPtGrpDO.ID_PESRVRPTGRP};
	}

	@Override
	public String getPkFieldCode() {
		return PeSrvrPtGrpDO.ID_PESRVRPTGRP;
	}
	
	@Override
	public String getRefCodeField() {
		return PeSrvrPtGrpDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeSrvrPtGrpDO.NAME;
	}
	
	
	@Override
	public String getTableName() {
		return new PeSrvrPtGrpDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.addAll(super.getOrderPart());
		listOrderParts.add(PeSrvrPtGrpDO.ID_PEDEPTSET);
		listOrderParts.add(PeSrvrPtGrpDO.SORTNO);
		return listOrderParts;
	}
	

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeSrvrPtGrpDO(), false));
		return listWhereParts;
	}
}
