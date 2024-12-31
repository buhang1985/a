package iih.pi.acc.account.refs;

import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.d.desc.PiPatAccDODesc;
import xap.sys.appfw.refinfo.RefGridModel;

public class AccountRefModel extends RefGridModel{
	@Override
	public String[] getShowFieldCode(){
		return new String[]{PiPatAccDO.CODE,PiPatAccDO.NAME};
	}
	@Override
	public String[] getHiddenFieldCode(){
		return new String[]{PiPatAccDO.ID_PATACC};
	}
	@Override
	public String[] getShowFieldName(){
		return new String[]{"编码","名称"};
	}
	@Override
	public String getPkFieldCode(){
		return PiPatAccDO.ID_PATACC;
	}
	@Override
	public String getTableName(){
		return PiPatAccDODesc.TABLE_NAME;
	}
	@Override
	public String getRefCodeField(){
		return PiPatAccDO.CODE;
	}
	@Override
	public String getRefNameField(){
		return PiPatAccDO.NAME;
	}

}
