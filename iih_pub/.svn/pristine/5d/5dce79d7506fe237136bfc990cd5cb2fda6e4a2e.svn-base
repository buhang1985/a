package iih.mp.mpbd.mobileapp.refs;

import java.util.ArrayList;
import java.util.List;

import iih.bd.utils.BdEnvContextUtil;
import iih.mp.mpbd.mobileapp.d.MpMbhAppDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class MpMbhAppDOGridRefs extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { MpMbhAppDO.CODE, MpMbhAppDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MpMbhAppDO.ID_MBH_APP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return MpMbhAppDO.ID_MBH_APP;
	}

	@Override
	public String getTableName() {
		return new MpMbhAppDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return MpMbhAppDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return MpMbhAppDO.NAME;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MpMbhAppDO.CODE, MpMbhAppDO.NAME/*, MpMbhAppDO.PYCODE, NmrDocDO.WBCODE, NmrDocDO.MNECODE*/ };
	}
	
	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(BdEnvContextUtil.processEnvContext(new MpMbhAppDO(), false));
		return listWhereParts;
	}

}
