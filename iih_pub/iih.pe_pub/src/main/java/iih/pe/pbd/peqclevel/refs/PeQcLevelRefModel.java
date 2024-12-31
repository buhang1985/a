package iih.pe.pbd.peqclevel.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.comm.utils.PeEnvContextUtil;
import iih.pe.pbd.peqclevel.d.PeQcLevelDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeQcLevelRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {

		return new String[] { PeQcLevelDO.NAME, PeQcLevelDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "名称", "编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeQcLevelDO.ID_PEQCLEVEL };
	}

	@Override
	public String getPkFieldCode() {
		return PeQcLevelDO.ID_PEQCLEVEL;
	}
	
	@Override
	public String getRefCodeField() {
		return PeQcLevelDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeQcLevelDO.NAME;
	}
	
	
	@Override
	public String getTableName() {
		return new PeQcLevelDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.addAll(super.getOrderPart());
		listOrderParts.add(PeQcLevelDO.SORTNO);
		return listOrderParts;
	}
	

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeQcLevelDO(), false));
		return listWhereParts;
	}
}
