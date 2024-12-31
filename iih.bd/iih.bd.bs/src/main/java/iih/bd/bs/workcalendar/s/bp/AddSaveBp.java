package iih.bd.bs.workcalendar.s.bp;

import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import iih.bd.bs.workcalendar.i.IWorkcalendarMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存工作日历
 * 
 * @author xuxing_2017年6月30日16:32:27
 *
 */
public class AddSaveBp {

	/**
	 * 主入口
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public WorkCalendarDO exec(WorkCalendarDO param) throws BizException {

		if (param == null) {
			return null;
		}

		// 1.保存主DO
		WorkCalendarDO rtnDO = saveWorkCalendarDO(param);

		// 2.保存年信息
		saveYearDO(rtnDO);

		// 3、保存日信息
		saveDateInfo(param);

		return rtnDO;
	}

	/**
	 * 保存YearDO
	 * 
	 * @param rtnDO
	 * @throws BizException
	 */
	private void saveYearDO(WorkCalendarDO param) throws BizException {
		SaveCalendarYearBp bp = new SaveCalendarYearBp();
		bp.exec(param);
	}

	/**
	 * 保存工作日历主DO
	 * 
	 * @param calendarDo
	 * @return
	 * @throws BizException
	 */
	private WorkCalendarDO saveWorkCalendarDO(WorkCalendarDO calendarDo) throws BizException {
		IWorkcalendarMDOCudService service = ServiceFinder.find(IWorkcalendarMDOCudService.class);
		calendarDo.setIsdefault(FBoolean.FALSE);
		calendarDo.setActivestate(2);
		calendarDo.setStatus(DOStatus.NEW);
		calendarDo.setId_group(Context.get().getGroupId());
		calendarDo.setId_org(Context.get().getOrgId());
		WorkCalendarDO[] calendarDOs = service.save(new WorkCalendarDO[] { calendarDo });
		return calendarDOs[0];
	}

	/**
	 * 保存日信息
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void saveDateInfo(WorkCalendarDO param) throws BizException {
		SaveDateDosBp bp = new SaveDateDosBp();
		bp.exec(param);
	}
}
