package iih.sc.comm;

import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.scbd.scheduleca.i.ISchedulecaRService;
import iih.sc.scbd.schedulechl.d.ScChlPeriodDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.workcalendar.d.DateTypeForWorkEnum;

/**
 * 计算渠道期间最大可预约日期
 * 
 * @author zhengcm
 * @date 2017-08-25 16:20:20
 *
 */
public class CalculateMaxAptDaysUtils {

	/**
	 * 计算渠道期间最大可预约日期
	 *
	 * @author zhengcm
	 * 
	 * @param periodDO 渠道期间DO
	 * @return 计算后的最大可预约日期
	 * @throws BizException
	 */
	public static FDate calculate(ScChlPeriodDO periodDO) throws BizException {
		if (periodDO == null) {
			return null;
		}
		FDateTime currentTime = ScAppUtils.getServerDateTime();
		FDate beginDate = currentTime.getBeginDate();
		int days = periodDO.getDays();// 可预约天数
		// 如果当前的小时小于开始时间，则天数减1
		if (periodDO.getBegin_time() != null) {
			if (currentTime.getHour() < periodDO.getBegin_time()) {
				days = days - 1;
			}
		}
		String sd_sctp = periodDO.getSd_sctp();// 排班类型编码
		FBoolean isCalcHoliday = periodDO.getFg_holiday_excl();// 计算节假日
		FDate date = beginDate.getDateAfter(days);
		if (!isCalcHoliday.booleanValue()) {// 不计算节假日（过滤掉节假日）
			List<String> dates = null;
			ScheduleCADO caDO = getScca(sd_sctp);
			if (!StringUtil.isEmptyWithTrim(caDO.getId_cal())) {
				dates = getCalendarDate(beginDate.toLocalString(), caDO.getId_cal());
			}
			if (null != caDO && !ListUtil.isEmpty(dates)) {
				FDate curDate = beginDate;
				int i = 0;
				while (i < days) {
					curDate = curDate.getDateAfter(1);
					if (dates.contains(curDate.toLocalString())) {
						continue;
					}
					i = i + 1;
				}
				date = curDate;
			}
		}
		return date;
	}

	/**
	 * 根据排班类型获取排班分类
	 *
	 * @author zhengcm
	 * 
	 * @param sd_sctp
	 * @return
	 * @throws BizException
	 */
	private static ScheduleCADO getScca(String sd_sctp) throws BizException {
		ISchedulecaRService service = ServiceFinder.find(ISchedulecaRService.class);
		ScheduleCADO[] caDOs = service.find("sd_sctp ='" + sd_sctp + "'", "", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(caDOs)) {
			return null;
		}
		return caDOs[0];
	}

	/**
	 * 获取开始日期之后日历对应的假日
	 *
	 * @author zhengcm
	 * 
	 * @param begin_date
	 * @param caId
	 * @return
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	private static List<String> getCalendarDate(String begin_date, String caId) throws DAException {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select dardate.calendardate ");
		buffer.append("from bd_workcalenddate dardate ");
		buffer.append("where dardate.id_workcalendar = ? ");
		buffer.append("and dardate.dateworktype = ? ");
		buffer.append("and dardate.calendardate >= ? ");
		SqlParam param = new SqlParam();
		param.addParam(caId);
		param.addParam(DateTypeForWorkEnum.HOLIDAY);
		param.addParam(begin_date);
		List<String> list = (List<String>) new DAFacade().execQuery(buffer.toString(), param, new ColumnListHandler());
		return list;
	}

}
