package iih.bd.bs.workcalendar.s.rule;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import iih.bd.bs.workcalendar.s.bp.SaveCalendarYearBp;
import iih.bd.bs.workcalendar.s.bp2.GenerateWorkCalendarDateBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 生成工作日历年和日期规则
 * 
 * @author hao_wu 2020-2-3
 *
 */
public class GenerateWorkCalendarYearAndDateRule implements IRule<WorkCalendarDO> {

	@Override
	public void process(WorkCalendarDO... workCalendarDos) throws BizException {
		if (ArrayUtils.isEmpty(workCalendarDos)) {
			return;
		}

		generateYear(workCalendarDos);
		generateDate(workCalendarDos);
	}

	/**
	 * 生成年信息
	 * 
	 * @param workCalendarDos
	 * @throws BizException
	 */
	private void generateYear(WorkCalendarDO[] workCalendarDos) throws BizException {
		SaveCalendarYearBp bp = new SaveCalendarYearBp();
		for (WorkCalendarDO workCalendarDo : workCalendarDos) {
			bp.exec(workCalendarDo);
		}
	}

	/**
	 * 生成日期信息
	 * 
	 * @param workCalendarDos
	 * @throws BizException
	 */
	private void generateDate(WorkCalendarDO[] workCalendarDos) throws BizException {
		GenerateWorkCalendarDateBp bp = new GenerateWorkCalendarDateBp();
		for (WorkCalendarDO workCalendarDo : workCalendarDos) {
			bp.exec(workCalendarDo);
		}
	}

}
