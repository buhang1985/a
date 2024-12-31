package iih.bd.bs.s.external.provide;

import iih.bd.bs.i.external.provide.IBdBsCiService;
import iih.bd.bs.s.external.provide.bp.IsWorkDayBp;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

/**
 * 提供给临床域服务
 * 
 * @author hao_wu 2018-6-21
 *
 */
public class BdBsCiServiceImpl implements IBdBsCiService {

	/**
	 * 判断给定日期是否为工作日
	 * 
	 * @param date
	 *            需要判定的日期
	 * @param workCalendarId
	 *            工作日历主键
	 * @return 是否为工作日
	 * @throws BizException
	 */
	@Override
	public FBoolean isWorkDay(FDate date, String workCalendarId) throws BizException {
		IsWorkDayBp bp = new IsWorkDayBp();
		FBoolean isWorkDay = bp.exec(date, workCalendarId);
		return isWorkDay;
	}

}
