package iih.bd.bs.dataimpt;

import iih.bd.bs.workcalendar.d.WorkCalendDateDO;
import iih.bd.bs.workcalendar.i.IWorkCalendDateDOCudService;
import iih.bd.dataimport.BDBaseDataImport;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 工作日历日期数据导入服务实现
 * 
 * @author hao_wu 2019-12-18
 *
 */
public class WorkCalendarDateDataImptServiceImpl extends BDBaseDataImport<WorkCalendDateDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new WorkCalendDateDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { WorkCalendDateDO.CALENDARDATE, WorkCalendDateDO.DATAFROMTYPE, WorkCalendDateDO.ONDUTYTIME,
				WorkCalendDateDO.OFFDUTYTIME, WorkCalendDateDO.ID_WORKCALENDAR };
	}

	@Override
	protected void insertToDB(WorkCalendDateDO[] importDatas) throws BizException {
		ServiceFinder.find(IWorkCalendDateDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(WorkCalendDateDO[] importDatas) throws BizException {
		ServiceFinder.find(IWorkCalendDateDOCudService.class).update(importDatas);
	}
}
