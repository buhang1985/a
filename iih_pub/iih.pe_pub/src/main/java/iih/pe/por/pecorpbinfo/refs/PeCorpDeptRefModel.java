package iih.pe.por.pecorpbinfo.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.por.pecorpbinfo.d.PeCorpDeptDO;
import iih.pe.por.pecorpbinfo.d.PeCorpbInfoDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeCorpDeptRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {

		return new String[] { PeCorpDeptDO.NAME, PeCorpDeptDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "名称", "编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeCorpDeptDO.ID_PECORPDEPT};
	}

	@Override
	public String getPkFieldCode() {
		return PeCorpDeptDO.ID_PECORPDEPT;
	}
	
	@Override
	public String getRefCodeField() {
		return PeCorpDeptDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeCorpDeptDO.NAME;
	}
	
	
	@Override
	public String getTableName() {
		return new PeCorpDeptDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.add(PeCorpbInfoDO.CODE);
		return listOrderParts;
	}

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeCorpDeptDO(), false));
		return listWhereParts;
	}
}
