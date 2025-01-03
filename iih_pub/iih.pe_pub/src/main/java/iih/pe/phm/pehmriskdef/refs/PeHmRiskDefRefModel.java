package iih.pe.phm.pehmriskdef.refs;

import iih.pe.phm.pehmriskdef.d.PeHmRiskDefDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeHmRiskDefRefModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[]{PeHmRiskDefDO.CODE,PeHmRiskDefDO.NAME,PeHmRiskDefDO.VALUE_REF,PeHmRiskDefDO.VALUE_IDEA,PeHmRiskDefDO.DATATP,PeHmRiskDefDO.FG_MODIFIABLE};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{PeHmRiskDefDO.ID_RISKDEF};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"编码","名称","参考值","理想值","数据来源","可改变危险因素"};
	}
	
	@Override
	public String getPkFieldCode() {
		return PeHmRiskDefDO.ID_RISKDEF;
	}
	
	@Override
	public String getRefCodeField() {
		return PeHmRiskDefDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		return PeHmRiskDefDO.NAME;
	}
	
	@Override
	public String getTableName() {
		return new PeHmRiskDefDO().getTableName();
	}

}
