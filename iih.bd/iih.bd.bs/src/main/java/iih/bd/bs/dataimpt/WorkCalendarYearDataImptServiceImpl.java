package iih.bd.bs.dataimpt;

import iih.bd.bs.workcalendar.d.WorkCalendYearDO;
import iih.bd.bs.workcalendar.i.IWorkCalendYearDOCudService;
import iih.bd.dataimport.BDBaseDataImport;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 工作日历年度数据导入服务实现
 * 
 * @author hao_wu 2019-12-18
 *
 */
public class WorkCalendarYearDataImptServiceImpl extends BDBaseDataImport<WorkCalendYearDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new WorkCalendYearDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { WorkCalendYearDO.WORKYEAR, WorkCalendYearDO.WORKYEARSTARTDATE,
				WorkCalendYearDO.WORKAMOUNT, WorkCalendYearDO.SHOWYEAR, WorkCalendYearDO.DATAFROMTYPE,
				WorkCalendYearDO.ID_WORKCALENDAR };
	}

	@Override
	protected void insertToDB(WorkCalendYearDO[] importDatas) throws BizException {
		ServiceFinder.find(IWorkCalendYearDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(WorkCalendYearDO[] importDatas) throws BizException {
		ServiceFinder.find(IWorkCalendYearDOCudService.class).update(importDatas);
	}
}
