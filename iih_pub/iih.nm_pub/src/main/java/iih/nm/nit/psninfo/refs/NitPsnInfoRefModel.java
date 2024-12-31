package iih.nm.nit.psninfo.refs;

import iih.nm.com.ref.ComRefGridModel;
import iih.nm.nit.psninfo.d.NitPsnInfoDO;
import xap.mw.coreitf.i.IBaseDO;

/**
 * 实习生信息参照
 */
public class NitPsnInfoRefModel extends ComRefGridModel {

	@Override
	public String[] getShowFieldCode() {
		
		return new String[] { NitPsnInfoDO.NAME, NitPsnInfoDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "姓名", "编码" };
	}

	@Override
	public String getRefCodeField() {

		return NitPsnInfoDO.CODE;
	}

	@Override
	public String getRefNameField() {
		
		return NitPsnInfoDO.NAME;
	}

	@Override
	public IBaseDO getBaseDO() {
		return new NitPsnInfoDO();
	}

}
