package iih.pe.pitm.pesrviprptca.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.comm.utils.PeEnvContextUtil;
import iih.pe.pitm.pesrviprptca.d.PeSrvIpRptCaDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeSrvIpRptCaRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {

		return new String[] { PeSrvIpRptCaDO.NAME, PeSrvIpRptCaDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "名称", "编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeSrvIpRptCaDO.ID_PESRVIPRPTCA};
	}

	@Override
	public String getPkFieldCode() {
		return PeSrvIpRptCaDO.ID_PESRVIPRPTCA;
	}
	
	@Override
	public String getRefCodeField() {
		return PeSrvIpRptCaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeSrvIpRptCaDO.NAME;
	}
	
	
	@Override
	public String getTableName() {
		return new PeSrvIpRptCaDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.addAll(super.getOrderPart());
		listOrderParts.add(PeSrvIpRptCaDO.SORTNO);
		return listOrderParts;
	}
	

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeSrvIpRptCaDO(), false));
		return listWhereParts;
	}
}
