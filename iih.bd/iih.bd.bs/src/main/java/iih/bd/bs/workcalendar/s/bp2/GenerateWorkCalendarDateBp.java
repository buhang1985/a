package iih.bd.bs.workcalendar.s.bp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.bs.holiday.d.HolidayDO;
import iih.bd.bs.holiday.i.IHolidayRService;
import iih.bd.bs.workcalendar.d.DateTypeForWorkEnum;
import iih.bd.bs.workcalendar.d.WorkCalendDateDO;
import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import iih.bd.bs.workcalendar.i.IWorkCalendDateDOCudService;
import iih.bd.bs.workcalendar.i.IWorkcalendarMDOCudService;
import iih.bd.bs.workcalendar.i.IWorkcalendarMDORService;
import iih.bd.bs.workcalendarrule.d.WorkCalendarRuleDO;
import iih.bd.bs.workcalendarrule.i.IWorkcalendarruleRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.cenum.d.DataFromTypeEnum;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 生成工作日历日期
 * 
 * @author hao_wu 2020-2-3
 *
 */
public class GenerateWorkCalendarDateBp {

	public void exec(WorkCalendarDO workCalendarDo) throws BizException {

		initData(workCalendarDo);

		generateDate(workCalendarDo);

		updateWorkCalendar(workCalendarDo);
	}

	@SuppressWarnings("unchecked")
	private void generateDate(WorkCalendarDO workCalendarDo) throws BizException {
		String sql = "select min(calendardate) as dt_b,max(calendardate) as dt_e from bd_workcalenddate where id_workcalendar = ? and calendardate >= ? and calendardate <= ?";
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(workCalendarDo.getId_workcalendar());
		sqlParam.addParam(workCalendarDo.getBegindate());
		sqlParam.addParam(workCalendarDo.getEnddate());

		DAFacade daFacade = new DAFacade();
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) daFacade.execQuery(sql, sqlParam,
				new MapListHandler());

		FDate dbBeginDate = null;
		FDate dbEndDate = null;
		if (dataList.size() > 0) {
			String beginDateStr = (String) dataList.get(0).get("dt_b");
			String endDateStr = (String) dataList.get(0).get("dt_e");
			if (StringUtils.isNotBlank(beginDateStr) && StringUtils.isNotBlank(endDateStr)) {
				dbBeginDate = new FDate(beginDateStr);
				dbEndDate = new FDate(endDateStr);
				generate(workCalendarDo.getBegindate(), dbBeginDate.getDateBefore(1), workCalendarDo);
				generate(dbEndDate.getDateAfter(1), workCalendarDo.getEnddate(), workCalendarDo);
				return;
			}
		}

		generate(workCalendarDo.getBegindate(), workCalendarDo.getEnddate(), workCalendarDo);
	}

	/**
	 * 更新工作日历结束时间
	 * 
	 * @param workCalendarDo
	 * @throws BizException
	 */
	private void updateWorkCalendar(WorkCalendarDO workCalendarDo) throws BizException {
		IWorkcalendarMDORService workcalendarMDORService = ServiceFinder.find(IWorkcalendarMDORService.class);
		WorkCalendarDO dbWorkCalendarDO = workcalendarMDORService.findById(workCalendarDo.getId_workcalendar());

		dbWorkCalendarDO.setEnddate(workCalendarDo.getEnddate());
		dbWorkCalendarDO.setStatus(DOStatus.UPDATED);
		IWorkcalendarMDOCudService workcalendarMDOCudService = ServiceFinder.find(IWorkcalendarMDOCudService.class);
		workcalendarMDOCudService.update(new WorkCalendarDO[] { dbWorkCalendarDO });
	}

	/**
	 * 初始化数据
	 * 
	 * @throws BizException
	 */
	private void initData(WorkCalendarDO workCalendarDo) throws BizException {
		this.initHoliday(workCalendarDo);
		this.initWorkCalendRule(workCalendarDo);
		this.initHolidayArray();
	}

	/**
	 * 生成工作日历日期
	 * 
	 * @param beginDate 开始日期
	 * @param endDate   结束日期
	 * @throws BizException
	 */
	private void generate(FDate beginDate, FDate endDate, WorkCalendarDO workCalendarDo) throws BizException {
		// 需要生成的天数
		int days = FDate.getDaysBetween(beginDate, endDate) + 1;
		if (days < 1) {
			return;
		}

		int groupSize = 1000;
		List<WorkCalendDateDO> dateList = new ArrayList<>();
		for (int i = 0; i < days; i++) {
			FDate date = beginDate.getDateAfter(i);
			WorkCalendDateDO calendDateDo = this.createWorkCalendDateDO(date, workCalendarDo);
			dateList.add(calendDateDo);
			if (dateList.size() >= groupSize || i == (days - 1)) {
				this.saveWorkCalendDate(dateList.toArray(new WorkCalendDateDO[0]));
				dateList.clear();
			}
		}
	}

	/**
	 * 创建工作日历日期
	 * 
	 * @param date
	 * @return
	 * @throws BizException
	 */
	private WorkCalendDateDO createWorkCalendDateDO(FDate date, WorkCalendarDO workCalendarDo) throws BizException {

		WorkCalendarRuleDO ruleDo = this._ruleDo;
		Integer workTp = this.getWorkType(date);

		WorkCalendDateDO dateDo = new WorkCalendDateDO();
		dateDo.setId_workcalendar(workCalendarDo.getId_workcalendar());
		dateDo.setCalendardate((FDate) date.clone());
		dateDo.setDateworktype(workTp);
		dateDo.setOndutytime(ruleDo.getWorkbtime());
		dateDo.setOffdutytime(ruleDo.getWorketime());
		dateDo.setDatafromtype(DataFromTypeEnum.CURLEVEL);
		dateDo.setStatus(DOStatus.NEW);
		return dateDo;
	}

	/**
	 * 获取工作类型
	 * 
	 * @param date
	 * @return
	 * @throws BizException
	 */
	private Integer getWorkType(FDate date) throws BizException {
		FDate[] holidayArray = this._holidayArray;
		if (ArrayUtils.contains(holidayArray, date)) {
			return (Integer) DateTypeForWorkEnum.HOLIDAY;
		}

		boolean[] weekOffDayArray = getWeekOffDayArray();
		return weekOffDayArray[date.getWeek()] ? (Integer) DateTypeForWorkEnum.OFFDAY
				: (Integer) DateTypeForWorkEnum.WORKDAY;
	}

	private boolean[] _weekOffDayArray;

	/**
	 * 获取一周七天的公休日数组 [星期天->星期六]
	 * 
	 * @return
	 * @throws BizException
	 */
	private boolean[] getWeekOffDayArray() throws BizException {
		if (ArrayUtils.isNotEmpty(this._weekOffDayArray)) {
			return this._weekOffDayArray;
		}

		WorkCalendarRuleDO ruleDo = this._ruleDo;
		boolean[] weekOffDayArray = new boolean[7];

		weekOffDayArray[0] = FBoolean.TRUE.equals(ruleDo.getSunday());
		weekOffDayArray[1] = FBoolean.TRUE.equals(ruleDo.getMonday());
		weekOffDayArray[2] = FBoolean.TRUE.equals(ruleDo.getTuesday());
		weekOffDayArray[3] = FBoolean.TRUE.equals(ruleDo.getWednesday());
		weekOffDayArray[4] = FBoolean.TRUE.equals(ruleDo.getThursday());
		weekOffDayArray[5] = FBoolean.TRUE.equals(ruleDo.getFriday());
		weekOffDayArray[6] = FBoolean.TRUE.equals(ruleDo.getSaturday());
		this._weekOffDayArray = weekOffDayArray;
		return this._weekOffDayArray;
	}

	private FDate[] _holidayArray;

	/**
	 * 获取节假日集合
	 * 
	 * @return
	 * @throws BizException
	 */
	private void initHolidayArray() throws BizException {
		HolidayDO[] holidayDos = this._holidayDos;
		if (ArrayUtils.isEmpty(holidayDos)) {
			return;
		}
		GetHolidayArrayBp bp = new GetHolidayArrayBp();
		this._holidayArray = bp.exec(holidayDos);
	}

	private HolidayDO[] _holidayDos;

	/**
	 * 获取假日定义信息
	 * 
	 * @return
	 * @throws BizException
	 */
	private void initHoliday(WorkCalendarDO workCalendarDo) throws BizException {
		if (StringUtils.isBlank(workCalendarDo.getId_holidaycate())) {
			return;
		}

		String wherePart = "Id_holidaycate = ? and Holidayyear between ? and ?";

		SqlParamDTO sqlParamDTO = new SqlParamDTO();
		sqlParamDTO.addParam(workCalendarDo.getId_holidaycate());
		sqlParamDTO.addParam(workCalendarDo.getBegindate().getYear());
		sqlParamDTO.addParam(workCalendarDo.getEnddate().getYear());

		IHolidayRService holidayRService = ServiceFinder.find(IHolidayRService.class);
		this._holidayDos = holidayRService.find2(wherePart, sqlParamDTO, "Holidayyear", FBoolean.FALSE);
	}

	private WorkCalendarRuleDO _ruleDo;

	/**
	 * 获取工作日历规则
	 * 
	 * @return
	 * @throws BizException
	 */
	private void initWorkCalendRule(WorkCalendarDO workCalendarDo) throws BizException {
		IWorkcalendarruleRService workcalendarruleRService = ServiceFinder.find(IWorkcalendarruleRService.class);
		this._ruleDo = workcalendarruleRService.findById(workCalendarDo.getId_workcalendrule());
		if (this._ruleDo == null) {
			throw new BizException("获取工作日历规则失败");
		}
	}

	/**
	 * 保存工作日历日期信息
	 * 
	 * @param workCalendDateDos
	 * @throws BizException
	 */
	private void saveWorkCalendDate(WorkCalendDateDO[] workCalendDateDos) throws BizException {
		IWorkCalendDateDOCudService workCalendDateDOCudService = ServiceFinder.find(IWorkCalendDateDOCudService.class);
		workCalendDateDOCudService.insert(workCalendDateDos);
	}
}
