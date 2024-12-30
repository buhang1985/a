package iih.sc.apt.s.bp.oral;

import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;

/**
 * 根据科室获取默认排班计划
 * 
 * @author zhengcm
 * @date 2016-11-01 19:24:41
 *
 */
public class GetOralDefaultPlanBP {

	/**
	 * 根据科室获取默认排班计划
	 *
	 * @param deptId
	 * @param psnId
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScPlanDO exec(String deptId, String psnId) throws BizException {
		ScValidator.validateParam("deptId", deptId);
		ScValidator.validateParam("psnId", psnId);
		return this.queryPlan(deptId, psnId);
	}

	/**
	 * 查询排班计划
	 *
	 * @param deptId
	 * @param psnId
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScPlanDO queryPlan(String deptId, String psnId) throws BizException {
		OralAptEP oralAptEP = new OralAptEP();
		String where = String.format("id_dep = '%s' and id_emp = '%s'", deptId, psnId);
		ScheduleResDO[] resDOs = oralAptEP.getScResByCond(where, null);
		if (ArrayUtil.isEmpty(resDOs)) {
			return null;
		}
		List<String> ids = new ArrayList<String>();
		for (ScheduleResDO resDO : resDOs) {
			ids.add(resDO.getId_scres());
		}
		where = String.format("id_dep = '%s' and fg_active = 'Y'", deptId) + " and "
				+ ScSqlUtils.getInSqlByIds("id_scres", ids);
		ScPlanDO[] planDOs = oralAptEP.getScPlanByCond(where, null);
		if (ArrayUtil.isEmpty(planDOs)) {
			return null;
		}
		return planDOs[0];
	}
}
