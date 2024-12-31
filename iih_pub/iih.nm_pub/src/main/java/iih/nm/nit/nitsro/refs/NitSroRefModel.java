package iih.nm.nit.nitsro.refs;

import iih.nm.nit.nitsro.d.NitSroDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 
 * 生源机构参照
 *
 */
public class NitSroRefModel extends RefGridModel{
	@Override
	public String[] getShowFieldCode() {
		
		return new String[] { NitSroDO.NAME, NitSroDO.CODE };
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[] { "姓名", "编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		
		return new String[] {NitSroDO.ID_NIT_SRO};
	}

	@Override
	public String getPkFieldCode() {
		
		return NitSroDO.ID_NIT_SRO;
	}

	@Override
	public String getRefCodeField() {

		return NitSroDO.CODE;
	}

	@Override
	public String getRefNameField() {
		
		return NitSroDO.NAME;
	}



	@Override
	public String getTableName() {
		
		return new NitSroDO().getTableName();
	}
}
