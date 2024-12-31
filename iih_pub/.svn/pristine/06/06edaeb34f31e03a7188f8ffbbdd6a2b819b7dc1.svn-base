package iih.pe.pqn.peqacontentdef.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.pqn.peqacontentdef.d.PeQakeyDefDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeQakeyDefRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeQakeyDefDO.CODE, PeQakeyDefDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeQakeyDefDO.ID_PEQAKEYDEF };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PeQakeyDefDO.ID_PEQAKEYDEF;
	}

	@Override
	public String getRefCodeField() {
		return PeQakeyDefDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeQakeyDefDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeQakeyDefDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.addAll(super.getOrderPart());
		return listOrderParts;
	}
	

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		//listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeQakeyDefDO(), false));
		return listWhereParts;
	}
}