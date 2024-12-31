package iih.pe.pbd.pewfoptiondef.refs;
import java.util.ArrayList;
import java.util.List;

import iih.pe.pbd.pewfoptiondef.d.PeWfOptionDefDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeWfOptionDefRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeWfOptionDefDO.CODE, PeWfOptionDefDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeWfOptionDefDO.ID_PEWFOPTIONDEF };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "选项编码", "选项名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PeWfOptionDefDO.ID_PEWFOPTIONDEF;
	}

	@Override
	public String getRefCodeField() {
		return PeWfOptionDefDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeWfOptionDefDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeWfOptionDefDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.addAll(super.getOrderPart());
		listOrderParts.add(PeWfOptionDefDO.SORTNO);
		return listOrderParts;
	}
	

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeWfOptionDefDO(), false));
		return listWhereParts;
	}
}

