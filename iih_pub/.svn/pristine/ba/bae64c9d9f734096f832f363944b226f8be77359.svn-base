package iih.pe.pbd.peappttladder.refs;
import java.util.ArrayList;
import java.util.List;

import iih.pe.pbd.peappttladder.d.PeAppttLadderDO;
import iih.pe.pitm.pesrvitem.d.PeSrvItemDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeAppttLadderRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeAppttLadderDO.CODE, PeAppttLadderDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeAppttLadderDO.ID_PEAPPTTLADDER };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PeAppttLadderDO.ID_PEAPPTTLADDER;
	}

	@Override
	public String getRefCodeField() {
		return PeAppttLadderDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeAppttLadderDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeAppttLadderDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.add(PeAppttLadderDO.SORTNO);
		return listOrderParts;
	}
	
	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeAppttLadderDO(), false));
		return listWhereParts;
	}
}
