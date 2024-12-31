package iih.pe.pitm.pesrvitem.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.pitm.pesrvitem.d.PeSrvItemDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.permfw.dataper.d.systemEnum;

public class PeSrvItemRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {

		return new String[] { PeSrvItemDO.NAME, PeSrvItemDO.CODE, PeSrvItemDO.NAME_SHORT,PeSrvItemDO.PYCODE,PeSrvItemDO.UNIT,PeSrvItemDO.REFERENCE };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "名称", "编码","简称", "检索码","计量单位","参考范围" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeSrvItemDO.ID_PESRVITEM };
	}

	@Override
	public String getPkFieldCode() {
		return PeSrvItemDO.ID_PESRVITEM;
	}
	
	@Override
	public String getRefCodeField() {
		return PeSrvItemDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeSrvItemDO.NAME;
	}
	
	
	@Override
	public String getTableName() {
		return new PeSrvItemDO().getTableName();
	}

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		
		listWhereParts.addAll(super.getWherePart());
		
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeSrvItemDO(), false));
		String room = (String) this.getExtendAttributeValue("id_pedeptset");
        if (room != null){
        	listWhereParts.add("Id_pedeptset = '"+room+"'");
        }
		return listWhereParts;
	}
	
	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.add(PeSrvItemDO.ID_PEDEPTSET);
		listOrderParts.add(PeSrvItemDO.SORTNO);
		return listOrderParts;
	}
	
}
