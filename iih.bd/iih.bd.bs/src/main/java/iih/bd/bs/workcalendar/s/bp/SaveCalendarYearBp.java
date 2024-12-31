package iih.bd.bs.workcalendar.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import iih.bd.bs.workcalendar.d.WorkCalendYearDO;
import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import iih.bd.bs.workcalendar.i.IWorkCalendYearDOCudService;
import iih.bd.bs.workcalendar.i.IWorkCalendYearDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据日历保存年信息
 * 
 * @author xuxing_2017年6月30日16:29:04
 *
 */
public class SaveCalendarYearBp {

	/**
	 * 主入口
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public WorkCalendYearDO[] exec(WorkCalendarDO param) throws BizException {

		// 1、获取已经保存的年信息
		WorkCalendYearDO[] years = getYearsInfo(param);

		// 2、获取已经保存的年信息对照
		HashMap<Integer, WorkCalendYearDO> mapYears = getExistYears(years);

		// 3、实例化年信息
		WorkCalendYearDO[] beSaveYars = initYearsInfo(param, mapYears);

		// 4、保存年信息
		WorkCalendYearDO[] saved = save(beSaveYars);

		// 5、获取返回值
		WorkCalendYearDO[] rtns = getRtn(years, saved);

		return rtns;
	}

	/**
	 * 获取已经保存的年信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private WorkCalendYearDO[] getYearsInfo(WorkCalendarDO param) throws BizException {
		IWorkCalendYearDORService findService = ServiceFinder.find(IWorkCalendYearDORService.class);
		return findService.find("id_workcalendar='" + param.getId_workcalendar() + "'", "workyear", FBoolean.FALSE);
	}

	/**
	 * 获取已经保存的年信息列表
	 * 
	 * @param years
	 * @return
	 */
	private HashMap<Integer, WorkCalendYearDO> getExistYears(WorkCalendYearDO[] years) {
		HashMap<Integer, WorkCalendYearDO> reMap = new HashMap<Integer, WorkCalendYearDO>();
		if (years != null && years.length > 0) {
			for (WorkCalendYearDO year : years) {
				reMap.put(year.getWorkyear(), year);
			}
		}
		return reMap;
	}

	/**
	 * 实例化年信息
	 * 
	 * @param param
	 * @param listYears
	 * @return
	 */
	private WorkCalendYearDO[] initYearsInfo(WorkCalendarDO param, HashMap<Integer, WorkCalendYearDO> mapYear) {
		List<WorkCalendYearDO> reList = new ArrayList<WorkCalendYearDO>();
		int beginYear = param.getBegindate().getYear();
		int endYear = param.getEnddate().getYear();
		for (int i = beginYear; i <= endYear; i++) {
			if (!mapYear.containsKey(i)) {
				WorkCalendYearDO yearDO = new WorkCalendYearDO();
				yearDO.setId_workcalendar(param.getId_workcalendar());
				yearDO.setWorkyear(i);
				yearDO.setShowyear(i + "");
				yearDO.setDatafromtype(0);
				if (i == beginYear) {
					yearDO.setWorkyearstartdate(param.getBegindate());// 首年取开始日期
				} else {
					yearDO.setWorkyearstartdate(getYearFirstDate(i));// 非首年取第一天
				}

				// 周数
				int dayCount = 0;
				if (i == endYear) {
					dayCount = FDate.getDaysBetween(yearDO.getWorkyearstartdate(), param.getEnddate());
				} else {
					dayCount = getDays(yearDO.getWorkyearstartdate());
				}
				yearDO.setWorkamount(dayCount % 7 > 0 ? (dayCount / 7 + 1) : dayCount / 7);
				yearDO.setStatus(DOStatus.NEW);
				reList.add(yearDO);
			} else {
				// 重新计算周数
				WorkCalendYearDO yearDO = mapYear.get(i);

				int dayCount = 0;
				if (i == endYear) {
					dayCount = FDate.getDaysBetween(yearDO.getWorkyearstartdate(), param.getEnddate());
				} else {
					dayCount = getDays(yearDO.getWorkyearstartdate());
				}
				int weekCount = dayCount % 7 > 0 ? (dayCount / 7 + 1) : dayCount / 7;
				if (weekCount != yearDO.getWorkamount()) {
					yearDO.setWorkamount(weekCount);
					yearDO.setStatus(DOStatus.UPDATED);
					reList.add(yearDO);
				}
			}
		}
		return reList.toArray(new WorkCalendYearDO[reList.size()]);
	}

	/**
	 * 保存年信息
	 * 
	 * @param beSaveYars
	 * @return
	 * @throws BizException
	 */
	private WorkCalendYearDO[] save(WorkCalendYearDO[] beSaveYars) throws BizException {
		IWorkCalendYearDOCudService saveService = ServiceFinder.find(IWorkCalendYearDOCudService.class);
		return saveService.save(beSaveYars);
	}

	/**
	 * 获取返回值
	 * 
	 * @param saveYars
	 * @param years
	 * @return
	 */
	private WorkCalendYearDO[] getRtn(WorkCalendYearDO[] saveYars, WorkCalendYearDO[] years) {
		List<WorkCalendYearDO> reList = new ArrayList<WorkCalendYearDO>();
		reList.addAll(Arrays.asList(saveYars));
		reList.addAll(Arrays.asList(years));
		return reList.toArray(new WorkCalendYearDO[reList.size()]);
	}

	/**
	 * 获取执行开始日期的当年的总天数
	 * 
	 * @param beginDate
	 * @param year
	 * @return
	 */
	private int getDays(FDate beginDate) {
		FDate dateNextFirst = new FDate((beginDate.getYear() + 1) + "-01-01");
		FDate lastDate = dateNextFirst.getDateAfter(-1);
		return FDate.getDaysBetween(beginDate, lastDate);
	}

	/**
	 * 获取年度起始日
	 * 
	 * @param year
	 * @return
	 */
	private FDate getYearFirstDate(int year) {
		FDate date = new FDate(year + "-01-01");
		return date;
	}
}
