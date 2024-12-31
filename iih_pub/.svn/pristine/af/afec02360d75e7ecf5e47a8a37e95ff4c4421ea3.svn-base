package iih.pe.pitm.penarratesportrecipe.refs;

import iih.pe.pitm.penarratesportrecipe.d.PeNSCDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeNSCRefModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[]{PeNSCDO.CODE,PeNSCDO.NAME,PeNSCDO.SORTNO,PeNSCDO.GOAL,PeNSCDO.PROGRAM,PeNSCDO.STRENGTH,PeNSCDO.DURATION,PeNSCDO.FREQUENCY,PeNSCDO.ATTENTION};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"处方编码","处方名称","序号","运动目的","运动项目","运动强度","运动时间","运动频率","注意事项"};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{PeNSCDO.ID_PENSC};
	}
	
	@Override
	public String getPkFieldCode() {
		return PeNSCDO.ID_PENSC;
	}
	
	@Override
	public String getRefCodeField() {
		return PeNSCDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		return PeNSCDO.NAME;
	}
	
	@Override
	public String getTableName() {
		return new PeNSCDO().getTableName();
	}

}
