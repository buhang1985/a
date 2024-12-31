package iih.bd.srv.mrtplvs.refs;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.mrtplvs.d.BdMrtplVsDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * @Description:生命体征项目参照
 * @author: xu_xing@founder.com.cn
 * @version：2018年3月29日 下午2:38:16 创建
 */
public class MrtplVsRefsModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { BdMrtplVsDO.CODE, BdMrtplVsDO.NAME, BdMrtplVsDO.DES };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { BdMrtplVsDO.ID_MRTPL_VS };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "备注" };
	}

	@Override
	public String getPkFieldCode() {
		return BdMrtplVsDO.ID_MRTPL_VS;
	}

	@Override
	public String getRefCodeField() {
		return BdMrtplVsDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return BdMrtplVsDO.NAME;
	}

	@Override
	public String getTableName() {
		return new BdMrtplVsDO().getTableName();
	}

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(BdEnvContextUtil.processEnvContext(new BdMrtplVsDO(), false));
		return listWhereParts;
	}
}
