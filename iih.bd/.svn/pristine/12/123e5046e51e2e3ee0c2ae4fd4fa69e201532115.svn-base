package iih.bd.bs.workcalendar.s.bp;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.List;

import iih.bd.bs.holiday.d.HolidayDO;
import iih.bd.bs.holiday.i.IHolidayRService;
import iih.bd.bs.workcalendar.d.WorkCalendDateDO;
import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import iih.bd.bs.workcalendar.i.IWorkCalendDateDOCudService;
import iih.bd.bs.workcalendarrule.d.WorkCalendarRuleDO;
import iih.bd.bs.workcalendarrule.i.IWorkcalendarruleRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;


/**
 * 生成日历日期\年信息
 * 
 * @author xuxing_2017年6月30日15:13:19_迭代
 *
 */
public class SaveDateDosBp {

	/**
	 * 主入口
	 * 
	 * @param rtnDO
	 * @throws BizException
	 */
	public void exec(WorkCalendarDO param) throws BizException {

		// 1、获取假日信息
		HolidayDO[] holidays = getHolidays(param);

		// 2、获取日历规则
		WorkCalendarRuleDO rule = getRule(param);

		// 3、实例化日期信息
		WorkCalendDateDO[] dateDOS = initDates(param, holidays, rule);

		// 4、保存日历信息
		saveDate(dateDOS);
	}

	/**
	 * 获取假日信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private HolidayDO[] getHolidays(WorkCalendarDO param) throws BizException {
		IHolidayRService holidayService = ServiceFinder.find(IHolidayRService.class);
		return holidayService.find("id_holidaycate='" + param.getId_holidaycate() + "'", null, FBoolean.FALSE);
	}

	/**
	 * 获取日历规则
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private WorkCalendarRuleDO getRule(WorkCalendarDO param) throws BizException {
		IWorkcalendarruleRService ruleService = ServiceFinder.find(IWorkcalendarruleRService.class);
		return ruleService.findById(param.getId_workcalendrule());
	}

	/**
	 * 实例化日期信息
	 * 
	 * @param param
	 * @param holidays
	 * @param rule
	 * @return
	 */
	private WorkCalendDateDO[] initDates(WorkCalendarDO param, HolidayDO[] holidays, WorkCalendarRuleDO rule) {
		List<WorkCalendDateDO> reList = new ArrayList<WorkCalendDateDO>();
		int days = FDate.getDaysBetween(param.getBegindate(), param.getEnddate()) + 1;
		boolean[] sabbatical = sabbaticalFlag(rule);// 一周公休标志
		for (int i = 0; i < days; i++) {
			FDate date = param.getBegindate().getDateAfter(i);// 日期
			int workType = dateworktype(date, sabbatical, holidays);// 日期类型
			WorkCalendDateDO dateDO = new WorkCalendDateDO();
			dateDO.setId_workcalendar(param.getId_workcalendar());
			dateDO.setCalendardate(date);
			dateDO.setDateworktype(workType);
			dateDO.setOndutytime(rule.getWorkbtime());
			dateDO.setOffdutytime(rule.getWorketime());
			dateDO.setDatafromtype(0);
			dateDO.setStatus(DOStatus.NEW);
			reList.add(dateDO);
		}
		return reList.toArray(new WorkCalendDateDO[reList.size()]);
	}

	/**
	 * 保存日历信息
	 * 
	 * @param dateDOS
	 * @throws BizException
	 */
	private void saveDate(WorkCalendDateDO[] dateDOS) throws BizException {
		if (dateDOS != null && dateDOS.length > 0) {
			IWorkCalendDateDOCudService service = ServiceFinder.find(IWorkCalendDateDOCudService.class);
			service.save(dateDOS);
		}
	}

	/**
	 * 日期类型设置
	 * 
	 * @param day
	 * @param sabbatical
	 * @param holoday
	 * @return
	 */
	private int dateworktype(FDate day, boolean[] sabbatical, HolidayDO[] holidayDOs) {
		if (holidayDOs != null && holidayDOs.length > 0) {
			if (isHoloday(day, holidayDOs))
				return 2;
		}
		if (isSabbatical(day, sabbatical))
			return 1;
		return 0;
	}

	/**
	 * 判断day所在的那一天是否属于节假日期间
	 * 
	 * @param day
	 * @param holoday
	 * @return
	 */
	private boolean isHoloday(FDate day, HolidayDO[] holidayDOs) {
		boolean b = false;

		GetHolidyArrayBp bp = new GetHolidyArrayBp();
		FDate[] holidayFDates = bp.exec(holidayDOs);
		for (FDate fDate : holidayFDates) {
			if (day.compareTo(fDate) == 0) {
				b = true;
				break;
			}

		}

		return b;
	}

	/**
	 * 判断day所在的那一天是否公休
	 * 
	 * @param day
	 * @param arr
	 * @return
	 */
	private boolean isSabbatical(FDate day, boolean[] arr) {
		return arr[day.getWeek()];
	}

	/**
	 * 假日类别
	 * 
	 * @param holidayDO
	 * @return
	 */
	private BitSet holidayFlag(HolidayDO[] holidayDO) {
		BitSet bs = new BitSet();
		for (HolidayDO ido : holidayDO) {
			FDate bDate = new FDate(ido.getStarttime().toString());
			FDate eDate = new FDate(ido.getEndtime().toString());
			int from = dayOfYear(bDate);
			int to = dayOfYear(eDate) + 1;
			bs.set(from, to);
		}
		return bs;
	}

	/**
	 * 返回day在当年的第几天
	 * 
	 * @param day
	 * @return
	 */
	private int dayOfYear(FDate day) {
		Calendar c = Calendar.getInstance();
		c.setTime(day.toDate());
		return c.get(Calendar.DAY_OF_YEAR) - 1;
	}

	/**
	 * 日历规则
	 * 
	 * @param ruledo
	 * @return
	 */
	private boolean[] sabbaticalFlag(WorkCalendarRuleDO ruledo) {
		boolean[] data = new boolean[7];
		data[0] = ruledo.getSunday().booleanValue();
		data[1] = ruledo.getMonday().booleanValue();
		data[2] = ruledo.getTuesday().booleanValue();
		data[3] = ruledo.getWednesday().booleanValue();
		data[4] = ruledo.getThursday().booleanValue();
		data[5] = ruledo.getFriday().booleanValue();
		data[6] = ruledo.getSaturday().booleanValue();
		return data;
	}
}
