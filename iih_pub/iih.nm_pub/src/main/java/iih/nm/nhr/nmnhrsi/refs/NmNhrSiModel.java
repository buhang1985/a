package iih.nm.nhr.nmnhrsi.refs;

import iih.nm.com.ref.ComRefGridModel;
import iih.nm.nhr.nmnhrsi.d.NmNhrSiDO;
import xap.mw.coreitf.i.IBaseDO;

public class NmNhrSiModel extends ComRefGridModel {
			
	@Override
	public String[] getShowFieldCode() {
		return new String[]{NmNhrSiDO.CODE,NmNhrSiDO.NAME};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"班次编号","班次名称"};
	}
	
	@Override
	public String getRefCodeField() {
		return NmNhrSiDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		return NmNhrSiDO.NAME;
	}

	@Override
	public IBaseDO getBaseDO() {
		return new NmNhrSiDO();
	}
}
