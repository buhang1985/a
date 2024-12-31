package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.workcalendar.d.WorkCalendDateDO;
import xap.sys.xbd.workcalendar.d.WorkCalendYearDO;
import xap.sys.xbd.workcalendar.i.IWorkCalendYearDOCudService;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2017年5月24日 下午1:26:04 </br>
 *          类说明：工作日历年属性导入数据 </br>
 *          Company: Copyright 2017 by PKU healthcare IT Co.,Ltd.
 */
public class WorkCalendarYearDataImptServiceImpl extends BDBaseDataImport<WorkCalendYearDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new WorkCalendDateDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { WorkCalendDateDO.ID_WORKCALENDAR, WorkCalendDateDO.ID_WORKCALENDDATE };
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
