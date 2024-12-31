package iih.pis.ivx.pisivxsetting.refs;


import iih.pis.comm.utils.PisEnvContextUtil;
import iih.pis.ivx.pisivxsetting.d.PisIvxSettingDO;

import java.util.ArrayList;
import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;

/**
 * @author 作者 :wangyuchun
 * @version 创建时间：2018年9月25日 下午8:35:16
 * 类说明：体检常用结论参照模型
 * Company: Copyright 2017 by PKU healthcare IT Co.,Ltd.
 */
public class PisIvxSettingRefModel extends RefGridModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public String[] getShowFieldCode() {
		return new String[] { PisIvxSettingDO.CODE, PisIvxSettingDO.NAME };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] {"服务号编码", "服务号名称"  };
	}

	@Override
	public String getPkFieldCode() {
		return PisIvxSettingDO.ID_PISIVXSETTING;
	}

	@Override
	public String getRefCodeField() {
		return PisIvxSettingDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PisIvxSettingDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PisIvxSettingDO().getTableName();
	}
	
	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.addAll(super.getOrderPart());
		listOrderParts.add(PisIvxSettingDO.CODE);
		return listOrderParts;
	}

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PisEnvContextUtil.processEnvContext(new PisIvxSettingDO(), false));
		return listWhereParts;
	}
}
