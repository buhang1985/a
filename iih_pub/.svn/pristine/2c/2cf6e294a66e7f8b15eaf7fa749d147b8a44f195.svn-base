package iih.mp.mpbd.mpmbhfunca.refs;

import java.util.ArrayList;
import java.util.List;

import iih.bd.utils.BdEnvContextUtil;
import iih.mp.mpbd.mpmbhfunca.d.MpMbhAppCaDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class MpMbhAppCaDOGridRefs extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { MpMbhAppCaDO.CODE, MpMbhAppCaDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MpMbhAppCaDO.ID_MBH_APP_FUNCA };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return MpMbhAppCaDO.ID_MBH_APP;
	}

	@Override
	public String getTableName() {
		return new MpMbhAppCaDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return MpMbhAppCaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return MpMbhAppCaDO.NAME;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MpMbhAppCaDO.CODE, MpMbhAppCaDO.NAME/*, MpMbhAppDO.PYCODE, NmrDocDO.WBCODE, NmrDocDO.MNECODE*/ };
	}
	
	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(BdEnvContextUtil.processEnvContext(new MpMbhAppCaDO(), false));
		return listWhereParts;
	}

}
