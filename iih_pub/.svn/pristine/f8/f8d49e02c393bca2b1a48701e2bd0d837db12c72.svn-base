package iih.bd.srv.mrtplvst.refs;

import iih.bd.srv.mrtplvst.d.BdMrtplVstDO;
import iih.bd.utils.BdEnvContextUtil;

import java.util.ArrayList;
import java.util.List;

import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.refinfo.RefGridModel;

public class MrtplvstRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { BdMrtplVstDO.CODE, BdMrtplVstDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { BdMrtplVstDO.ID_MRTPL_VST };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return BdMrtplVstDO.ID_MRTPL_VST;
	}

	@Override
	public String getRefCodeField() {
		return BdMrtplVstDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return BdMrtplVstDO.NAME;
	}

	@Override
	public String getTableName() {
		return new BdMrtplVstDO().getTableName();
	}

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(BdEnvContextUtil.processEnvContext(new BdMrtplVstDO(), false));
		return listWhereParts;
	}
}
