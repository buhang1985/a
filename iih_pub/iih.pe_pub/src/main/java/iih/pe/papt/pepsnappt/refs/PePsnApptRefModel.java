package iih.pe.papt.pepsnappt.refs;


import iih.pe.papt.pehmappt.d.PeHmApptDO;
import iih.pe.papt.pepsnappt.d.PePsnApptDO;
import iih.pe.comm.utils.PeEnvContextUtil;

import java.util.ArrayList;
import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;

/**
 * @author 作者 :wangyuchun
 * @version 创建时间：2018年9月25日 下午8:35:16
 * 类说明：体检常用结论参照模型
 * Company: Copyright 2017 by PKU healthcare IT Co.,Ltd.
 */
public class PePsnApptRefModel extends RefGridModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public String[] getShowFieldCode() {
		return new String[] { PePsnApptDO.CARD_PE, PePsnApptDO.NAME_PSN,PePsnApptDO.DT_PE,PePsnApptDO.PE_CODE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PePsnApptDO.ID_PEPSNAPPT };
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[] {"流程号", "姓名","体检时间","体检唯一码"  };
	}

	@Override
	public String getPkFieldCode() {
		return PePsnApptDO.ID_PEPSNAPPT;
	}

	@Override
	public String getRefCodeField() {
		return PePsnApptDO.CARD_PE;
	}

	@Override
	public String getRefNameField() {
		return PePsnApptDO.NAME_PSN;
	}

	@Override
	public String getTableName() {
		return new PePsnApptDO().getTableName();
	}
	
	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.addAll(super.getOrderPart());
		listOrderParts.add(PePsnApptDO.CARD_PE);
		return listOrderParts;
	}

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PePsnApptDO(), false));
		return listWhereParts;
	}
}
