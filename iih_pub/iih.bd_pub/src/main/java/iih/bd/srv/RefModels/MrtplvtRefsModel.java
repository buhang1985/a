package iih.bd.srv.RefModels;

import java.util.List;

import iih.bd.srv.mrtplvt.d.MrtplVtDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class MrtplvtRefsModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub
		return new String[] { MrtplVtDO.NAME, MrtplVtDO.CODE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		// TODO Auto-generated method stub
		return new String[] { MrtplVtDO.ID_MRTPLVT };
	}

	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[] { "生命体征测量类别", "编码" };
	}

	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return MrtplVtDO.ID_MRTPLVT;
	}

	@Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return MrtplVtDO.CODE;
	}

	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return MrtplVtDO.NAME;
	}

	@Override
	public String getTableName() {
		return new MrtplVtDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MrtplVtDO.CODE, MrtplVtDO.NAME};
	}
	
	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = super.getWherePart();
		listWhereParts.add(BdEnvContextUtil.processEnvContext(new MrtplVtDO(), false));
		return listWhereParts;
	}
}
