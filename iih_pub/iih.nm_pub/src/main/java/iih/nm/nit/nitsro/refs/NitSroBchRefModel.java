package iih.nm.nit.nitsro.refs;

import iih.nm.nit.nitsro.d.NitSroBchDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 实习进修批参照
 * @author caoshuai Oct 15, 2018 8:46:06 AM
 *@param
 */
public class NitSroBchRefModel extends RefGridModel{

	@Override
	public String[] getShowFieldCode() {

		return new String[] { NitSroBchDO.NAME, NitSroBchDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "姓名", "编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {

		return new String[] {NitSroBchDO.ID_NIT_SRO_BCH};
	}

	@Override
	public String getPkFieldCode() {

		return NitSroBchDO.ID_NIT_SRO_BCH;
	}

	@Override
	public String getRefCodeField() {

		return NitSroBchDO.CODE;
	}

	@Override
	public String getRefNameField() {

		return NitSroBchDO.NAME;
	}



	@Override
	public String getTableName() {

		return new NitSroBchDO().getTableName();
	}
}
