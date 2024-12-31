package iih.pe.por.pepsnbinfo.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.por.pepsnbinfo.d.PePsnBInfoDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PePsnBInfoRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {

		return new String[] { PePsnBInfoDO.NAME, PePsnBInfoDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "名称", "编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PePsnBInfoDO.ID_PEPSNBINFO};
	}

	@Override
	public String getPkFieldCode() {
		return PePsnBInfoDO.ID_PEPSNBINFO;
	}
	
	@Override
	public String getRefCodeField() {
		return PePsnBInfoDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PePsnBInfoDO.NAME;
	}
	
	
	@Override
	public String getTableName() {
		return new PePsnBInfoDO().getTableName();
	}


	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PePsnBInfoDO(), false));
		return listWhereParts;
	}
}
