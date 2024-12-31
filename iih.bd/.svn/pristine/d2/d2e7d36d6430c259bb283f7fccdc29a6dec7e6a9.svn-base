package iih.bd.bs.workcalendar.s.bp;

import iih.bd.bs.workcalendar.d.DateTypeForWorkEnum;
import iih.bd.bs.workcalendar.d.WorkCalendDateDO;
import iih.bd.bs.workcalendar.i.IWorkCalendDateDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据开始时间日期和工作日小时数获取结束时间日期
 * @author guoyang
 *
 */
public class GetEndDateTimeByBeginAndWorkdaysBp {

	public FDateTime exec(FDateTime begin, int workdayhours, String workCalendarid) throws BizException {
		validator(begin, workdayhours, workCalendarid);
		WorkCalendDateDO[] workCalendDates = getWorkCalendDate(begin, workdayhours, workCalendarid);
		return getEndDateTime(begin, workCalendDates, workdayhours);
	}
	
	/**
	 * 传入参数校验
	 * @param begin
	 * @param workdayhours
	 * @param workCalendarid
	 * @throws BizException
	 */
	private void validator(FDateTime begin, int workdayhours, String workCalendarid) throws BizException {

		if(begin == null){
			throw new BizException("开始时间不能为空！");
		}
		
		if(workCalendarid == null){
			throw new BizException("工作日历主键不能为空！");
		}
	}

	/**
	 * 获取工作日历的日期信息
	 * @param begin
	 * @param workdayhours
	 * @param workCalendarid
	 * @return 
	 * @throws BizException 
	 */
	private WorkCalendDateDO[] getWorkCalendDate(FDateTime begin, int workdayhours, String workCalendarid) throws BizException {
		
		WorkCalendDateDO[] workCalendDates = getWorkCalendDate(workCalendarid);
		if(workCalendDates == null || workCalendDates.length <= 0){
			throw new BizException("查询不到当前工作日历的日期信息！");
		}
		boolean afterFirst = begin.after(workCalendDates[0].getCalendardate());
		boolean beforeLast =  begin.before(workCalendDates[workCalendDates.length-1].getCalendardate());
		if(afterFirst && beforeLast){
			return workCalendDates;
		}else{
			throw new BizException("开始日期:"+ begin +"不在工作日历范围内!");
		}
	}

	/**
	 * 结束时间
	 * @param begin 
	 * @param workCalendDates
	 * @param workdayhours
	 * @return
	 * @throws BizException 
	 */
	private FDateTime getEndDateTime(FDateTime begin, WorkCalendDateDO[] workCalendDates, int workdayhours) throws BizException {
		for (int i = 0; i < workCalendDates.length; i++) {
			boolean isSame = begin.getDate().isSameDate(workCalendDates[i].getCalendardate());
			if(isSame){
				return CalculateEndDateTime(begin, workCalendDates, workdayhours, i);
			}
		}
		throw new BizException("开始日期:"+ begin +"不在工作日历范围内!");
	}

	/**
	 * 计算结束日期
	 * @param begin
	 * @param workCalendDates
	 * @param workdayhours
	 * @param i
	 * @return
	 * @throws BizException
	 */
	private FDateTime CalculateEndDateTime(FDateTime begin, WorkCalendDateDO[] workCalendDates, int workdayhours, int i) throws BizException {
		
		//对传入的对应小时折算成天数
		int count = workdayhours / 24;
		//小时折算为天数后剩余不足一天的小时数
		int hours = workdayhours % 24;
		//起始日期的小时值
		int beginhour = begin.getUFTime().getHour();
		
		//当beginhour+hours处于[0,24)时(区间左闭右开)，则仍然处于当前日，不做增减，大于等于24则为下一工作日，小于0则为前一工作日
		if((beginhour + hours) >= 24){
			//起始日期加上剩余小时数后超过当日24时则为下一天
			count++;
		}else if((beginhour + hours) < 0){
			//起始日期加上剩余日期后小于当日0时则为前一天(workdayhours可为负数)
			count--;
		}
		
		if((i+count) > workCalendDates.length-1 || (i+count) < 0) {
			throw new BizException("开始日期:"+ begin +"后的"+ count +"个工作日超出工作日历的日期范围！");
		}
		//计算起始时间加上workdayhours时间后的FTime
		long millis = begin.getUFTime().getMillis() + hours*3600000L;
		return new FDateTime(workCalendDates[i+count].getCalendardate(), new FTime(millis));
	}

	/**
	 * 日期信息查询服务查询工作日历下的日期信息
	 * @param workCalendarid
	 * @return WorkCalendDateDO[]
	 * @throws BizException 
	 */
	private WorkCalendDateDO[] getWorkCalendDate(String workCalendarid) throws BizException {
		IWorkCalendDateDORService workCalendDateDORService = ServiceFinder.find(IWorkCalendDateDORService.class);
		String condition = String.format("id_workcalendar = '%s' and dateworktype = %d", workCalendarid, DateTypeForWorkEnum.WORKDAY);
		WorkCalendDateDO[] workCalendDates = workCalendDateDORService.find(condition, "Calendardate", FBoolean.FALSE);
		if (workCalendDates == null || workCalendDates.length <= 0) {
			throw new BizException("未查询到工作日历下日期信息！");
		}
		return workCalendDates;
	}
}
