package iih.bd.bs.workcalendar.s.bp;

import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import iih.bd.bs.workcalendar.i.IWorkcalendarMDOCudService;
import iih.bd.bs.workcalendar.i.IWorkcalendarMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 生成工作日历信息
 * 
 * @author xuxing_2017年6月30日15:12:05_迭代
 *
 */
public class DetailSaveBp {

	/**
	 * 主入口
	 * 
	 * @param calendarDo
	 * @return
	 * @throws BizException
	 */
	public WorkCalendarDO exec(WorkCalendarDO calendarDo) throws BizException {

		// 1.保存主表数据
		WorkCalendarDO cDo = updateWorkCalendarDO(calendarDo);

		// 2、更新年度信息
		updateYearsInfo(cDo);

		// 3.更新日期信息
		updateDates(calendarDo);

		return cDo;
	}

	/**
	 * 更新工作日历主表数据
	 * 
	 * @param calendarDo
	 * @return
	 * @throws BizException
	 */
	private WorkCalendarDO updateWorkCalendarDO(WorkCalendarDO calendarDo) throws BizException {

		IWorkcalendarMDORService findService = ServiceFinder.find(IWorkcalendarMDORService.class);
		WorkCalendarDO calendarDO = findService.findById(calendarDo.getId_workcalendar());

		IWorkcalendarMDOCudService service = ServiceFinder.find(IWorkcalendarMDOCudService.class);
		calendarDo.setStatus(DOStatus.UPDATED);
		WorkCalendarDO[] rtns = service.save(new WorkCalendarDO[] { calendarDo });
		if (rtns != null && rtns.length > 0) {
			WorkCalendarDO rtn = rtns[0];
			if (calendarDO.getBegindate().equals(calendarDO.getEnddate())) {
				rtn.setBegindate(calendarDO.getBegindate());// 日历信息导入完毕后的首次生成
			} else {
				rtn.setBegindate(calendarDO.getEnddate().getDateAfter(1));
			}
			return rtn;
		}
		throw new BizException("工作日历保存失败！");
	}

	/**
	 * 更新年度信息
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void updateYearsInfo(WorkCalendarDO param) throws BizException {
		SaveCalendarYearBp bp = new SaveCalendarYearBp();
		bp.exec(param);
	}

	/**
	 * 更新日期信息
	 * 
	 * @param calendarDo
	 * @throws BizException
	 */
	private void updateDates(WorkCalendarDO calendarDo) throws BizException {
		SaveDateDosBp bp = new SaveDateDosBp();
		bp.exec(calendarDo);
	}
}
