package iih.pe.pqn.peqaca.refs;
import java.util.ArrayList;
import java.util.List;

import iih.pe.pqn.peqaca.d.PeQaCaDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeQaCaRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeQaCaDO.CODE, PeQaCaDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeQaCaDO.ID_PEQACA };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PeQaCaDO.ID_PEQACA;
	}

	@Override
	public String getRefCodeField() {
		return PeQaCaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeQaCaDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeQaCaDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.addAll(super.getOrderPart());
		listOrderParts.add(PeQaCaDO.SORTNO);
		return listOrderParts;
	}
	

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeQaCaDO(), false));
		return listWhereParts;
	}
}
