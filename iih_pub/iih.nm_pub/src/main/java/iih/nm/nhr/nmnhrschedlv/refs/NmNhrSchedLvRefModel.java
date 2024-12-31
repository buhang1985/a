package iih.nm.nhr.nmnhrschedlv.refs;

import iih.nm.nhr.institutabatch.d.NmBatchDO;
import iih.nm.nhr.nmnhrschedlv.d.NmNhrSchedLvDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NmNhrSchedLvRefModel extends RefGridModel{
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] {NmNhrSchedLvDO.DT_BEGIN_LV ,NmNhrSchedLvDO.DAYS_LV};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] {"请假开始时间","请假天数" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NmNhrSchedLvDO.ID_NHR_SCHED_LV };
	}

	@Override
	public String getPkFieldCode() {
		return NmNhrSchedLvDO.ID_NHR_SCHED_LV;
	}

	
	@Override
	public String getRefCodeField() {
		return NmNhrSchedLvDO.ID_LV_OFFSET;
	}
	@Override
	public String getRefNameField() {
		return NmNhrSchedLvDO.DT_BEGIN_LV;
	}
	
	
	@Override
	public String getTableName() {
		return new NmNhrSchedLvDO().getTableName();
	}
	@Override
	public String[] getBlurFields() {
		return super.getBlurFields();
	}
}