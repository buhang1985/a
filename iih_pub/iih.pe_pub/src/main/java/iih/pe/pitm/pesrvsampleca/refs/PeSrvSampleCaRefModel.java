package iih.pe.pitm.pesrvsampleca.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.pitm.pesrvsampleca.d.PeSrvSampleCaDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeSrvSampleCaRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {

		return new String[] { PeSrvSampleCaDO.NAME, PeSrvSampleCaDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "名称", "编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeSrvSampleCaDO.ID_PESRVSAMPLECA};
	}

	@Override
	public String getPkFieldCode() {
		return PeSrvSampleCaDO.ID_PESRVSAMPLECA;
	}
	
	@Override
	public String getRefCodeField() {
		return PeSrvSampleCaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeSrvSampleCaDO.NAME;
	}
	
	
	@Override
	public String getTableName() {
		return new PeSrvSampleCaDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.add(PeSrvSampleCaDO.SORTNO);
		return listOrderParts;
	}

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeSrvSampleCaDO(), false));
		return listWhereParts;
	}
}
