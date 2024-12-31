package iih.pe.phm.perstrisks.refs;

import iih.pe.phm.perstrisks.d.PeRstRisksDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeRstRisksRefModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[]{PeRstRisksDO.RST,PeRstRisksDO.FG_POSI,PeRstRisksDO.MARK_POSI};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{PeRstRisksDO.ID_PERSTRISKS};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"结果","阳性标识","阳性符号"};
	}
	
	@Override
	public String getPkFieldCode() {
		return PeRstRisksDO.ID_PERSTRISKS;
	}
	
	@Override
	public String getRefCodeField() {
		return PeRstRisksDO.RST;
	}
	
	@Override
	public String getRefNameField() {
		return PeRstRisksDO.FG_POSI;
	}
	
	@Override
	public String getTableName() {
		return new PeRstRisksDO().getTableName();
	}


}
