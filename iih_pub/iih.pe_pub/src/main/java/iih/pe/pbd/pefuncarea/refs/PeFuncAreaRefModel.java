package iih.pe.pbd.pefuncarea.refs;
import java.util.ArrayList;
import java.util.List;

import iih.pe.pbd.pefuncarea.d.PeFuncAreaDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeFuncAreaRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeFuncAreaDO.CODE, PeFuncAreaDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeFuncAreaDO.ID_PEFUNCAREA };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PeFuncAreaDO.ID_PEFUNCAREA;
	}

	@Override
	public String getRefCodeField() {
		return PeFuncAreaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeFuncAreaDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeFuncAreaDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.addAll(super.getOrderPart());
		listOrderParts.add("sortno");
		return listOrderParts;
	}
	
	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeFuncAreaDO(), false));
		return listWhereParts;
	}
}

