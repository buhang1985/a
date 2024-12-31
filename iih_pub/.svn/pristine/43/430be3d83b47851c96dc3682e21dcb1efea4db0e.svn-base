package iih.bd.srv.mrtplvs.refs;

import iih.bd.srv.mrtplvs.d.BdMrtplVsItmDO;
import iih.bd.utils.BdEnvContextUtil;

import java.util.ArrayList;
import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 体征横向录入测量项目参照
 * @author lijm
 *
 */
public class MrtplVsItmRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { BdMrtplVsItmDO.CODE, BdMrtplVsItmDO.NAME, BdMrtplVsItmDO.ID_DATAORIGIN };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "项目属性编码", "项目属性名称", "数据来源" };
	}

	public String[] getHiddenFieldCode() {
		return new String[] { BdMrtplVsItmDO.ID_MRTPL_VS_ITM };
	}

	@Override
	public String getPkFieldCode() {
		return BdMrtplVsItmDO.ID_MRTPL_VS_ITM;
	} 

	@Override
	public String getRefCodeField() {
		return BdMrtplVsItmDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return BdMrtplVsItmDO.NAME;
	}

	
	@Override
	public String getTableName() {
		return new BdMrtplVsItmDO().getTableName();
	}

	@Override
	public List<String> getOrderPart() {
		List<String> order = new ArrayList<String>();
		order.add(BdMrtplVsItmDO.SORTNO);
		return order;
	}

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(BdEnvContextUtil.processEnvContext(new BdMrtplVsItmDO(), false));
		return listWhereParts;
	}
}
