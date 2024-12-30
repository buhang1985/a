package iih.sc.att.s.bp;

import iih.sc.att.sctaskpl.d.ScTaskPlDO;
import iih.sc.att.sctaskpl.i.ISctaskplCudService;
import iih.sc.att.sctaskpl.i.ISctaskplRService;
import iih.sc.att.sctaskplemp.d.ScTaskPlEmpDO;
import iih.sc.att.sctaskplemp.i.ISctaskplempCudService;
import iih.sc.att.sctaskplemp.i.ISctaskplempRService;
import iih.sc.att.sctaskplweek.d.ScTaskPlWeekDO;
import iih.sc.att.sctaskplweek.i.ISctaskplweekCudService;
import iih.sc.att.sctaskplweek.i.ISctaskplweekRService;
import iih.sc.comm.ScValidator;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 删除考勤计划
 * 
 * @author 李军
 *
 */
public class DeleteAttPlBP {
	/**
	 * 删除考勤计划 删除考勤计划、周计划、考勤人员
	 * 
	 * @param attPlId
	 *            考勤计划ID
	 * @throws BizException
	 */
	public void exec(String attPlId) throws BizException {
		// 参数验证
		ScValidator.validateParam("attPlId", attPlId);

		// 根据参数查询考勤计划
		ISctaskplRService sctaskplRService = ServiceFinder.find(ISctaskplRService.class);
		ScTaskPlDO taskPlDO = sctaskplRService.findById(attPlId);
		// 删除考勤计划
		if (taskPlDO == null) {
			return;
		}
		ISctaskplCudService sctaskplCudService = ServiceFinder.find(ISctaskplCudService.class);
		sctaskplCudService.delete(new ScTaskPlDO[] { taskPlDO });

		// 根据参数查询周计划
		ISctaskplweekRService sctaskplweekRService = ServiceFinder.find(ISctaskplweekRService.class);
		String conditionWeek = String.format("id_taskpl = '%s'", taskPlDO.getId_taskpl());
		ScTaskPlWeekDO[] scTaskPlWeekDOs = sctaskplweekRService.find(conditionWeek, "", FBoolean.FALSE);
		// 删除周计划
		if (scTaskPlWeekDOs != null && scTaskPlWeekDOs.length > 0) {
			ISctaskplweekCudService sctaskplweekCudService = ServiceFinder.find(ISctaskplweekCudService.class);
			sctaskplweekCudService.delete(scTaskPlWeekDOs);
		}
		// 根据参数查询考勤人员
		ISctaskplempRService sctaskplempRService = ServiceFinder.find(ISctaskplempRService.class);
		String conditionEmp = String.format("id_taskpl = '%s'", taskPlDO.getId_taskpl());
		ScTaskPlEmpDO[] scTaskPlEmpDO = sctaskplempRService.find(conditionEmp, "", FBoolean.FALSE);
		// 删除考勤人员
		if (scTaskPlEmpDO != null && scTaskPlEmpDO.length > 0) {
			ISctaskplempCudService sctaskplempCudService = ServiceFinder.find(ISctaskplempCudService.class);
			sctaskplempCudService.delete(scTaskPlEmpDO);
		}
	}
}
