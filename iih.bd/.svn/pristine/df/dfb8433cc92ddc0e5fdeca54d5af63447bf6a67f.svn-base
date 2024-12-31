package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.IDataImport;
import xap.sys.xbd.workcalendar.d.WorkCalendDateDO;
import xap.sys.xbd.workcalendar.i.IWorkCalendDateDOCudService;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2017年5月24日 上午11:58:57 类说明：工作日历日期属性导入数据 Company: Copyright 2017
 *          by PKU healthcare IT Co.,Ltd.
 */
public class WorkCalendarDateDataImptServiceImpl extends BDBaseDataImport<WorkCalendDateDO> implements IDataImport {

	@Override
	protected BaseDO getDoInstance() {
		return new WorkCalendDateDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { WorkCalendDateDO.ID_WORKCALENDAR, WorkCalendDateDO.ID_WORKCALENDDATE };
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
