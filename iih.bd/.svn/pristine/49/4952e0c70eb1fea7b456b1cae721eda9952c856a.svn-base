package iih.bd.bs.workcalendar.s.bp2;

import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import iih.bd.bs.workcalendar.i.IWorkcalendarMDOCudService;
import iih.bd.bs.workcalendar.i.IWorkcalendarMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 设置默认工作日历
 * 
 * @author hao_wu 2020-2-12
 *
 */
public class SetDefaultWorkCalendarBp {

	public void exec(WorkCalendarDO workCalendarDo) throws BizException {
		String wherePart = "Isdefault = 'Y' and id_org = ?";
		SqlParamDTO sqlParamDTO = new SqlParamDTO();
		sqlParamDTO.addParam(Context.get().getOrgId());

		IWorkcalendarMDORService workcalendarMDORService = ServiceFinder.find(IWorkcalendarMDORService.class);
		WorkCalendarDO[] workCalendarDOs = workcalendarMDORService.find2(wherePart, sqlParamDTO, "", FBoolean.FALSE);

		ArrayList<WorkCalendarDO> saveDoList = new ArrayList<>();
		if (ArrayUtils.isNotEmpty(workCalendarDOs)) {
			for (WorkCalendarDO data : workCalendarDOs) {
				data.setIsdefault(FBoolean.FALSE);
				data.setStatus(DOStatus.UPDATED);
				saveDoList.add(data);
			}
		}

		workCalendarDo.setIsdefault(FBoolean.TRUE);
		workCalendarDo.setStatus(DOStatus.UPDATED);
		saveDoList.add(workCalendarDo);

		IWorkcalendarMDOCudService workcalendarMDOCudService = ServiceFinder.find(IWorkcalendarMDOCudService.class);
		workcalendarMDOCudService.update(saveDoList.toArray(new WorkCalendarDO[0]));
	}
}
