package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.workcalendar.d.WorkCalendarRuleDO;
import xap.sys.xbd.workcalendar.i.IWorkcalendarruleCudService;

/**
 * 工作日历规则
 * 
 * @author Administrator
 *
 */
public class WorkCalendarRuleDataImptServiceImpl extends BDBaseDataImport<WorkCalendarRuleDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new WorkCalendarRuleDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { WorkCalendarRuleDO.ID_WORKCALENDARRULE, WorkCalendarRuleDO.NAME,
				WorkCalendarRuleDO.CODE };
	}

	@Override
	protected void insertToDB(WorkCalendarRuleDO[] importDatas) throws BizException {
		ServiceFinder.find(IWorkcalendarruleCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(WorkCalendarRuleDO[] importDatas) throws BizException {
		ServiceFinder.find(IWorkcalendarruleCudService.class).update(importDatas);
	}
}
