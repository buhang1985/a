package iih.bd.bs.workcalendar.i;

import iih.bd.bs.workcalendar.d.WorkCalendDateDO;
import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 工作日历扩展服务接口
 * 
 * @author hao_wu 2020-2-3
 *
 */
public interface IWorkCalendarExtRService {

	/**
	 * 查询工作日历日期分页信息
	 * 
	 * @param pageInfo
	 * @param workCalendarDo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<WorkCalendDateDO> findWorkCalendarDatePagingData(PaginationInfo pageInfo,
			WorkCalendarDO workCalendarDo) throws BizException;

}
