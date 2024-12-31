package iih.bd.bs.workcalendar.s;

import iih.bd.bs.workcalendar.d.WorkCalendDateDO;
import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import iih.bd.bs.workcalendar.i.IWorkCalendarExtCudService;
import iih.bd.bs.workcalendar.i.IWorkCalendarExtRService;
import iih.bd.bs.workcalendar.s.bp2.FindWorkCalendarDatePagingDataBp;
import iih.bd.bs.workcalendar.s.bp2.GenerateWorkCalendarDateBp;
import iih.bd.bs.workcalendar.s.bp2.SetDefaultWorkCalendarBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 工作日历扩展服务
 * 
 * @author hao_wu 2020-2-3
 *
 */
public class WorkCalendarExtCrudServiceImpl implements IWorkCalendarExtCudService, IWorkCalendarExtRService {

	@Override
	public PagingRtnData<WorkCalendDateDO> findWorkCalendarDatePagingData(PaginationInfo pageInfo,
			WorkCalendarDO workCalendarDo) throws BizException {
		FindWorkCalendarDatePagingDataBp bp = new FindWorkCalendarDatePagingDataBp();
		PagingRtnData<WorkCalendDateDO> pagingData = bp.exec(pageInfo, workCalendarDo);
		return pagingData;
	}

	@Override
	public void generateWorkCalendarDate(WorkCalendarDO workCalendarDo) throws BizException {
		GenerateWorkCalendarDateBp bp = new GenerateWorkCalendarDateBp();
		bp.exec(workCalendarDo);
	}

	@Override
	public void setDefaultWorkCalendar(WorkCalendarDO workCalendarDo) throws BizException {
		SetDefaultWorkCalendarBp bp = new SetDefaultWorkCalendarBp();
		bp.exec(workCalendarDo);
	}

}
