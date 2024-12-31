package iih.bd.bs.workcalendar.i;

import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import xap.mw.core.data.BizException;

/**
 * 工作日历扩展服务接口
 * 
 * @author hao_wu 2020-2-3
 *
 */
public interface IWorkCalendarExtCudService {

	/**
	 * 生成工作日历日期
	 * 
	 * @param workCalendarDo 生成需要的参数
	 * @throws BizException
	 */
	public abstract void generateWorkCalendarDate(WorkCalendarDO workCalendarDo) throws BizException;

	/**
	 * 设置默认工作日历
	 * 
	 * @param workCalendarDo
	 */
	public abstract void setDefaultWorkCalendar(WorkCalendarDO workCalendarDo) throws BizException;
}
