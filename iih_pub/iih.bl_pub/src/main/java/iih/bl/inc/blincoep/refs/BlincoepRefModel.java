package iih.bl.inc.blincoep.refs;

import xap.sys.appfw.refinfo.RefGridModel;
import iih.bl.inc.blincoep.d.BlIncOepDO;



public class BlincoepRefModel extends RefGridModel{
	@Override
	public String[] getShowFieldCode() {
		return new String[]{BlIncOepDO.INCNO};
	}
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{BlIncOepDO.ID_INCOEP};
	}
	@Override
	public String[] getShowFieldName() {
		return new String[]{"门急诊发票号码"};
	}
	@Override
	public String getPkFieldCode() {
		return BlIncOepDO.ID_INCOEP;
	}
	@Override
	public String getRefCodeField() {
		return BlIncOepDO.INCNO;
	}
	
	@Override
	public String getTableName() {
		return new BlIncOepDO().getTableName();
	}
	
	
}
