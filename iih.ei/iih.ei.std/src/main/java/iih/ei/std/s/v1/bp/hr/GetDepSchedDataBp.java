package iih.ei.std.s.v1.bp.hr;

import org.apache.commons.lang.ArrayUtils;

import iih.ei.std.d.v1.hr.depscheddata.d.DepSchedInParamDTO;
import iih.ei.std.d.v1.hr.depscheddata.d.SchedDataInfoDTO;
import iih.ei.std.d.v1.hr.depscheddata.d.WeekSchedInfoResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.hr.hsc.hscschedweek.d.HscSchedDO;
import iih.hr.hsc.hscschedweek.d.HscSchedWeekDO;
import iih.hr.hsc.hscschedweek.d.HscschedweekAggDO;
import iih.hr.hsc.hscschedweek.i.IHscschedweekRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

public class GetDepSchedDataBp extends IIHServiceBaseBP<DepSchedInParamDTO, WeekSchedInfoResultDTO> {

	@Override
	protected void checkParam(DepSchedInParamDTO param) throws BizException {
		if (param == null) {
			throw new BizException("科室排班查询入参为空！");
		} else if (StringUtil.isEmptyWithTrim(param.getId_dep())) {
			throw new BizException("科室排班查询入参[科室Id]为空！");
		} else if (param.getDt_monday() == null) {
			throw new BizException("科室排班查询入参[周一日期]为空！");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected WeekSchedInfoResultDTO process(DepSchedInParamDTO param) throws BizException {
		IDeptRService deptRService = ServiceFinder.find(IDeptRService.class);
		DeptDO[] depDos = deptRService.findByAttrValString(DeptDO.CODE, param.getId_dep());
		if(ArrayUtils.isEmpty(depDos)) {
			throw new BizException("根据【dpet_code】未获取到科室");
		}
		SelectDepSchedDataBp bp = new SelectDepSchedDataBp();
		return bp.exec(depDos[0].getId_dep(), param.getDt_monday());
	}
}
