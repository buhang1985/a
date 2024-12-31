package iih.nmr.pkuf.nmrdoc.refs;

import java.util.ArrayList;
import java.util.List;

import iih.bd.utils.BdEnvContextUtil;
import iih.nmr.pkuf.nmrdoc.d.NmrDocDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 文书基本信息
 * @Description:
 * @author: xu_xing@founder.com.cn
 * @version：2018年3月19日 上午11:46:48 创建
 */
public class NmrDocGridRefs extends RefGridModel {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { NmrDocDO.CODE, NmrDocDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NmrDocDO.ID_NMR_DOC,NmrDocDO.ID_SET };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return NmrDocDO.ID_NMR_DOC;
	}

	@Override
	public String getTableName() {
		return new NmrDocDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return NmrDocDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return NmrDocDO.NAME;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { NmrDocDO.CODE, NmrDocDO.NAME, NmrDocDO.PYCODE, NmrDocDO.ID_SET, NmrDocDO.WBCODE, NmrDocDO.MNECODE };
	}
	
	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(BdEnvContextUtil.processEnvContext(new NmrDocDO(), false));
		return listWhereParts;
	}
}
