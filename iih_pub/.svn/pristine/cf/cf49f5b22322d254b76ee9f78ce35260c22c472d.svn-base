package iih.pe.pqn.peevalchrorisk.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.pqn.peevalchrorisk.d.PeChroRiskDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeChroRiskRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {

		return new String[] { PeChroRiskDO.NAME, PeChroRiskDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "名称", "编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeChroRiskDO.ID_PECHRORISK};
	}

	@Override
	public String getPkFieldCode() {
		return PeChroRiskDO.ID_PECHRORISK;
	}
	
	@Override
	public String getRefCodeField() {
		return PeChroRiskDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeChroRiskDO.NAME;
	}
	
	
	@Override
	public String getTableName() {
		return new PeChroRiskDO().getTableName();
	}


	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeChroRiskDO(), false));
		return listWhereParts;
	}
}
