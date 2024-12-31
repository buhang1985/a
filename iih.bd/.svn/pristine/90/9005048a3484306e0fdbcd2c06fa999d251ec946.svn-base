package iih.bd.bs.workcalendar.s.bp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import iih.bd.bs.workcalendar.d.WorkCalendDateDO;
import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import iih.bd.bs.workcalendar.i.IWorkCalendDateDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.dto.d.DayCalendarDataDTO;
import xap.sys.xbd.dto.d.MonthCalendarDataDTO;
import xap.sys.xbd.dto.d.WorkCalendarDataDTO;
/**
 * @author 作者 E-mail:
 * @version 创建时间：2016年9月9日 上午9:29:21 类说明 查询并拼装工作日历数据
 */
public class GetWorkCalendarDataBp {

	private WorkCalendarDO calDO;

	public WorkCalendarDataDTO exec(WorkCalendarDO calDO, int pageNumber) throws BizException, ParseException {

		if (calDO == null) {
			return null;
		}
		this.calDO = calDO;
		return getData(pageNumber);
	}

	/**
	 * 拼装日历数据
	 * 
	 * @param calDO
	 *            工作日历主DO
	 * @param pageNumber
	 *            页码
	 * @return
	 * @throws BizException
	 * @throws ParseException
	 */
	private WorkCalendarDataDTO getData(int pageNumber) throws BizException, ParseException {

		WorkCalendarDataDTO caDTO = new WorkCalendarDataDTO();
		caDTO.setStartdate(calDO.getBegindate());
		caDTO.setEnddate(calDO.getEnddate());
		caDTO.setYearstartdate(calDO.getBegindate());

		FArrayList monthDTOlist = new FArrayList();

		// 组装月信息集合
		setMonthDTOList(monthDTOlist, calDO, pageNumber);

		caDTO.setMonthcalendardatas(monthDTOlist);

		return caDTO;
	}

	/**
	 * 组装月信息DTO集合
	 * 
	 * @param monthDTOlist
	 *            月信息DTO集合
	 * @param calDO
	 *            日历DO
	 * @param pageNumber
	 *            页码
	 * @throws BizException
	 * @throws ParseException
	 */
	private void setMonthDTOList(FArrayList monthDTOlist, WorkCalendarDO calDO, int pageNumber) throws BizException, ParseException {
		int monthCount = (calDO.getEnddate().getYear() - calDO.getBegindate().getYear()) * 12 - calDO.getBegindate().getMonth() + calDO.getEnddate().getMonth() + 1;

		int nowYear = calDO.getBegindate().getYear();
		int nowMonth = calDO.getBegindate().getMonth();
		MonthCalendarDataDTO[] month = new MonthCalendarDataDTO[monthCount];
		for (int i = 0; i < monthCount; i++) {
			month[i] = new MonthCalendarDataDTO();
			month[i].setYear(nowYear);

			month[i].setMonth(nowMonth);

			if (nowMonth + 1 > 12) {
				nowYear++;
				nowMonth = 1;
			} else {
				nowMonth++;
			}
		}
		getDayDTOList(monthDTOlist, month, pageNumber);

		// for(int i=(pageNumber-1)*6;i<j;i++){
		// int thisMonth = month[i].getMonth();
		// int thisYear = month[i].getYear();
		// int daysInMonth = FDateTime.getDaysMonth(nowYear, nowMonth);
		// String dt_end = thisYear + "-" +
		// ((thisMonth+"").length()==1?("0"+thisMonth):thisMonth )+ "-" +
		// daysInMonth;
		// String dt_start = thisYear + "-" +
		// ((thisMonth+"").length()==1?("0"+thisMonth):thisMonth ) + "-" + "01";
		// // 查询数据库中当月日期信息
		// WorkCalendDateDO[] dateDOS = getDateDO(calDO, dt_start, dt_end);
		//
		// FArrayList dateDOList = new FArrayList();
		//
		// // 组装日期DTO装入dateDOList
		// getDayDTOList(dateDOS, dateDOList, dt_start);
		//
		// month[i].setDaycalendardatas(dateDOList);
		//
		// monthDTOlist.add(month[i]);
		// }
	}

	/**
	 * 查询数据库中当月日期信息
	 * 
	 * @param calDO
	 *            日历DO
	 * @param dt_start
	 *            当月开始日期
	 * @param dt_end
	 *            当月结束日期
	 * @return
	 * @throws BizException
	 */
	private WorkCalendDateDO[] getDateDO(String dt_start, String dt_end) throws BizException{
		IWorkCalendDateDORService rService = ServiceFinder.find(IWorkCalendDateDORService.class);
		StringBuffer sql = new StringBuffer();

		sql.append("  id_workcalendar='" + calDO.getId_workcalendar() + "' ");
		sql.append("  and calendardate >='" + dt_start + "' ");
		sql.append("  and  calendardate <= '" + dt_end + "'");

		WorkCalendDateDO[] dateDOS = rService.find(sql.toString(), " calendardate ", FBoolean.FALSE);

		return dateDOS;

	}

	/**
	 * 把日期信息跟月信息拼在一起返回
	 * @param monthDTOlist 月信息集合
	 * @param month 所有月数组
	 * @param pageNumber 页码
	 * @throws ParseException
	 * @throws BizException
	 */
	private void getDayDTOList(FArrayList monthDTOlist, MonthCalendarDataDTO[] month, int pageNumber) throws ParseException, BizException {
		int j = pageNumber * 6;
		if (j > month.length) {
			j = month.length;
		}

		int beginYear = month[(pageNumber - 1) * 6].getYear();
		int beginMonth = month[(pageNumber - 1) * 6].getMonth();

		String dt_start = beginYear + "-" + ((beginMonth + "").length() == 1 ? ("0" + beginMonth) : beginMonth) + "-" + "01";

		int endYear = month[j - 1].getYear();
		int endMonth = month[j - 1].getMonth();

		int daysInMonth = FDateTime.getDaysMonth(endYear, endMonth);

		String dt_end = endYear + "-" + ((endMonth + "").length() == 1 ? ("0" + endMonth) : endMonth) + "-" + daysInMonth;
		WorkCalendDateDO[] dateDOS = getDateDO(dt_start, dt_end);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();

		for (int i = (pageNumber - 1) * 6; i < j; i++) {
			int thisMonth = month[i].getMonth();
			int thisYear = month[i].getYear();
			FArrayList dateDOList = new FArrayList();
			for (WorkCalendDateDO workCalendDateDO : dateDOS) {
				FDate thisDay = workCalendDateDO.getCalendardate();
				if (thisDay.getYear() == thisYear && thisDay.getMonth() == thisMonth) {
					DayCalendarDataDTO dayDTO = new DayCalendarDataDTO();
					dayDTO.setDay(thisDay.getDay());
					dayDTO.setDatetpye(workCalendDateDO.getDateworktype());
					dayDTO.setKey(workCalendDateDO.getId_workcalenddate());
					dayDTO.setOndutytime(workCalendDateDO.getOndutytime() + "");
					dayDTO.setOffdutytime(workCalendDateDO.getOffdutytime() + "");

					FMap map = new FMap();
					map.put(dayDTO.getKey(), workCalendDateDO);
					dayDTO.setObj(map);
					c.setTime(format.parse(thisDay + ""));

					// 求出本天是周几
					int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
					dayDTO.setWeektype(dayOfWeek);
					dateDOList.add(dayDTO);
				}
			}

			month[i].setDaycalendardatas(dateDOList);

			monthDTOlist.add(month[i]);
		}

	}

}
