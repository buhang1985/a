package iih.pe.pbd.peagegroup.refs;
import java.util.ArrayList;
import java.util.List;

import iih.pe.pbd.peagegroup.d.PeAgeDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeAgeRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeAgeDO.CODE, PeAgeDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeAgeDO.ID_PEAGE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PeAgeDO.ID_PEAGE;
	}

	@Override
	public String getRefCodeField() {
		return PeAgeDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeAgeDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeAgeDO().getTableName();
	}


	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.add(PeAgeDO.SORTNO);
		return listOrderParts;
	}
	
	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeAgeDO(), false));
		return listWhereParts;
	}
}
