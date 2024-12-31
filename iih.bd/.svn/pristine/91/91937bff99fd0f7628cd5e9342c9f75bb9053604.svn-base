package iih.bd.bs.s.external.provide.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.bs.workcalendar.d.DateTypeForWorkEnum;
import iih.bd.bs.workcalendar.d.WorkCalendDateDO;
import iih.bd.bs.workcalendar.i.IWorkCalendDateDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 判断给定日期是否为工作日业务逻辑
 * 
 * @author hao_wu 2018-6-21
 *
 */
public class IsWorkDayBp {

	public FBoolean exec(FDate date, String workCalendarId) throws BizException {
		if (date == null) {
			throw new BizException("给定日期不允许为空。");
		}
		if (StringUtils.isEmpty(workCalendarId)) {
			throw new BizException("工作日历主键不允许为空。");
		}

		FBoolean isWorkDay = getWorkDayFlag(date, workCalendarId);
		return isWorkDay;
	}

	/**
	 * 获取工作日标识
	 * 
	 * @param date
	 *            需要判定的日期
	 * @param workCalendarId
	 *            工作日历主键
	 * @return 是否为工作日
	 * @throws BizException
	 */
	private FBoolean getWorkDayFlag(FDate date, String workCalendarId) throws BizException {

		String wherePart = String.format("id_workcalendar = '%s' and calendardate = '%s'", workCalendarId,
				date.toStdString());

		IWorkCalendDateDORService workCalendDateDORService = ServiceFinder.find(IWorkCalendDateDORService.class);
		WorkCalendDateDO[] result = workCalendDateDORService.find(wherePart, "", FBoolean.FALSE);

		if (result == null || result.length <= 0) {
			String msg = String.format("给定日期\"%s\"未在工作日历\"%s\"区间内。", date.toString(), workCalendarId);
			throw new BizException(msg);
		}

		if (result.length > 1) {
			String msg = String.format("工作日历\"%s\"中存在多个日期为\"%s\"的记录，请检查工作日历日期表中数据是否正确。", workCalendarId,
					date.toString());
			throw new BizException(msg);
		}

		Integer dateWorkType = result[0].getDateworktype();
		Boolean isWorkDay = DateTypeForWorkEnum.WORKDAY.equals(dateWorkType);
		return new FBoolean(isWorkDay);
	}

}
