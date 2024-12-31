package iih.bd.bs.dataimpt;

import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import iih.bd.bs.workcalendar.i.IWorkcalendarMDOCudService;
import iih.bd.dataimport.BDBaseDataImport;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 工作日历数据导入服务实现
 * 
 * @author hao_wu 2019-12-18
 *
 */
public class WorkCalendarDataImptServiceImpl extends BDBaseDataImport<WorkCalendarDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new WorkCalendarDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { WorkCalendarDO.ID_GROUP, WorkCalendarDO.ID_ORG, WorkCalendarDO.ID_WORKCALENDRULE,
				WorkCalendarDO.NAME, WorkCalendarDO.CODE, WorkCalendarDO.BEGINDATE, WorkCalendarDO.ENDDATE,
				WorkCalendarDO.YEARSTARTDATE };
	}

	@Override
	protected void insertToDB(WorkCalendarDO[] importDatas) throws BizException {
		ServiceFinder.find(IWorkcalendarMDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(WorkCalendarDO[] importDatas) throws BizException {
		ServiceFinder.find(IWorkcalendarMDOCudService.class).update(importDatas);
	}
}
