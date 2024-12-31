package iih.bd.bs.workcalendar.s;

import java.text.ParseException;

import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import iih.bd.bs.workcalendar.i.IWorkcalendarExtService;
import iih.bd.bs.workcalendar.s.bp.AddSaveBp;
import iih.bd.bs.workcalendar.s.bp.DetailSaveBp;
import iih.bd.bs.workcalendar.s.bp.GetEndDateTimeByBeginAndWorkdaysBp;
import iih.bd.bs.workcalendar.s.bp.GetWorkCalendarDataBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.xbd.dto.d.WorkCalendarDataDTO;

/**
 * 工作日历日期信息扩展服务实现
 */
@Service(serviceInterfaces = { IWorkcalendarExtService.class }, binding = Binding.JSONRPC)
public class WorkcalendarExtServiceImpl implements IWorkcalendarExtService {

	@Override
	public FDateTime getEndDateTime(FDateTime begin, int workdayhours, String workCalendarid) throws BizException {
		GetEndDateTimeByBeginAndWorkdaysBp bp = new GetEndDateTimeByBeginAndWorkdaysBp();
		return bp.exec(begin, workdayhours, workCalendarid);
	}

	/**
	 * 组装日历数据
	 */
	@Override
	public WorkCalendarDataDTO getetWorkCalendarData(WorkCalendarDO calDO, int pageNumber)
			throws BizException, ParseException {
		GetWorkCalendarDataBp bp = new GetWorkCalendarDataBp();
		return bp.exec(calDO, pageNumber);
	}

	/**
	 * 生成工作日历明细
	 */
	@Override
	public WorkCalendarDO detailSave(WorkCalendarDO calendarDo) throws BizException {
		DetailSaveBp bp = new DetailSaveBp();
		return bp.exec(calendarDo);
	}

	/**
	 * 新增工作日历保存
	 */
	@Override
	public WorkCalendarDO addSave(WorkCalendarDO calendarDo) throws BizException {
		AddSaveBp bp = new AddSaveBp();
		return bp.exec(calendarDo);
	}
}
