package iih.nm.nqm.nmnqmsuper.refs;

import iih.nm.com.ref.ComRefGridModel;
import iih.nm.nqm.nmnqmsuper.d.NmNqmSuperDO;
import xap.mw.coreitf.i.IBaseDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NmNqmSuperModel extends ComRefGridModel{
	
	
	@Override
	public String[] getShowFieldCode() {
		return new String[]{NmNqmSuperDO.CODE,NmNqmSuperDO.NAME};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"编码","名称"};
	}
	
	@Override
	public String getRefCodeField() {
		return NmNqmSuperDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		return NmNqmSuperDO.NAME;
	}

	@Override
	public IBaseDO getBaseDO() {
		return new NmNqmSuperDO();
	}
	
}
