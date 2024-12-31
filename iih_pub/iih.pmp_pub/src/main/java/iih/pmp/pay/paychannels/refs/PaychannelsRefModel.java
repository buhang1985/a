package iih.pmp.pay.paychannels.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pmp.pay.paychannels.d.PaychannelsDO;
import xap.mw.coreitf.i.IBaseDO;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.permfw.pub.EnvContextUtil;

public class PaychannelsRefModel extends RefGridModel{

	@Override
	public String[] getShowFieldCode() {

		return new String[] { PaychannelsDO.NAME, PaychannelsDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "名称", "编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PaychannelsDO.ID_PAYCHANNELS };
	}

	@Override
	public String getPkFieldCode() {
		return PaychannelsDO.ID_PAYCHANNELS;
	}
	
	@Override
	public String getRefCodeField() {
		return PaychannelsDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PaychannelsDO.NAME;
	}
	

	@Override
	public String getTableName() {
		return new PaychannelsDO ().getTableName();
	}


	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(processEnvContext(new PaychannelsDO(), false));
		return listWhereParts;
	}
	public static String processEnvContext(IBaseDO baseDO, boolean fg_tableAlias) {
		String wherePart = EnvContextUtil.processEnvContext("", baseDO, fg_tableAlias);
		if (wherePart == null || wherePart.equals("") || wherePart.isEmpty()) {
			return " 1 = 2 ";
		}
		return wherePart;
	}

}
