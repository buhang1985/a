package iih.pe.pbd.peprivacy.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.pbd.peprivacy.d.PePrivacyDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PePrivacyRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {

		return new String[] { PePrivacyDO.NAME, PePrivacyDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "名称", "编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PePrivacyDO.ID_PEPRIVACY};
	}

	@Override
	public String getPkFieldCode() {
		return PePrivacyDO.ID_PEPRIVACY;
	}
	
	@Override
	public String getRefCodeField() {
		return PePrivacyDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PePrivacyDO.NAME;
	}
	
	
	@Override
	public String getTableName() {
		return new PePrivacyDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.add(PePrivacyDO.SORTNO);
		return listOrderParts;
	}

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PePrivacyDO(), false));
		return listWhereParts;
	}
}
