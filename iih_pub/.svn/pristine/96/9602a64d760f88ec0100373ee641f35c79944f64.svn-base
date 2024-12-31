package iih.pe.por.pepsncard.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.por.pepsncard.d.PePsnCardDDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PePsnCardRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { PePsnCardDDO.NO_CARD, PePsnCardDDO.NAME_PSN };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PePsnCardDDO.ID_PEPSNCARD };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "会员卡号", "会员姓名" };
	}

	@Override
	public String getPkFieldCode() {
		return PePsnCardDDO.ID_PEPSNCARD;
	}

	@Override
	public String getRefCodeField() {
		return PePsnCardDDO.NO_CARD;
	}

	@Override
	public String getRefNameField() {
		return PePsnCardDDO.NAME_PSN;
	}

	@Override
	public String getTableName() {
		return new PePsnCardDDO().getTableName();
	}


	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PePsnCardDDO(), false));
		return listWhereParts;
	}

}
