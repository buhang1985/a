package iih.bd.bs.workcalendar.s.rule;

import iih.bd.base.utils.DoUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bs.workcalendar.d.WorkCalendDateDO;
import iih.bd.bs.workcalendar.d.WorkCalendYearDO;
import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 删除工作日历年和日期信息
 * 
 * @author hao_wu 2020-2-11
 *
 */
public class DeleteYearAndDateRule implements IRule<WorkCalendarDO> {

	@Override
	public void process(WorkCalendarDO... workCalendarDOs) throws BizException {
		String[] calendarIds = DoUtils.getAttrValArr(workCalendarDOs, WorkCalendarDO.ID_WORKCALENDAR, String.class);
		String wherePart = SqlUtils.getInSqlByIds(WorkCalendDateDO.ID_WORKCALENDAR, calendarIds);

		DAFacade daFacade = new DAFacade();
		daFacade.deleteByWhere(WorkCalendDateDO.class, wherePart);
		daFacade.deleteByWhere(WorkCalendYearDO.class, wherePart);
	}
}
