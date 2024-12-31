package iih.pe.pitm.perstillness.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.pitm.perstillness.d.PeRstIllnessDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeRstIllnessRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeRstIllnessDO.CODE, PeRstIllnessDO.NAME};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeRstIllnessDO.ID_PERSTILLNESS };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PeRstIllnessDO.ID_PERSTILLNESS;
	}

	@Override
	public String getRefCodeField() {
		return PeRstIllnessDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeRstIllnessDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeRstIllnessDO  ().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.add(PeRstIllnessDO.SORTNO);
		return listOrderParts;
	}
	

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeRstIllnessDO(), false));
		return listWhereParts;
	}
}
