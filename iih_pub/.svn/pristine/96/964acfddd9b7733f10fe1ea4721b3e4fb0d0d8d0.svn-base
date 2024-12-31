package iih.mp.mpbd.prnca.refs;

import iih.mp.mpbd.prnca.d.MpOrPrnDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class MpPrnRefModel extends RefGridModel{
	
	@Override
	public String[] getShowFieldCode(){
		return new String[]{MpOrPrnDO.CODE,MpOrPrnDO.NAME};
	}
	@Override
	public String[] getHiddenFieldCode(){
		return new String[]{MpOrPrnDO.ID_OR_PRN};
	}
	@Override
	public String[] getShowFieldName(){
		return new String[]{"编码","名称"};
	}
	@Override
	public String getPkFieldCode(){
		return MpOrPrnDO.ID_OR_PRN;
	}
	@Override
	public String getTableName(){
		return new MpOrPrnDO().getTableName();
	}
	@Override
	public String getRefCodeField(){
		return MpOrPrnDO.CODE;
	}
	@Override
	public String getRefNameField(){
		return MpOrPrnDO.NAME;
	}
	@Override
	public String[] getBlurFields() {
		return new String[]{MpOrPrnDO.CODE,MpOrPrnDO.NAME};
	}
}
