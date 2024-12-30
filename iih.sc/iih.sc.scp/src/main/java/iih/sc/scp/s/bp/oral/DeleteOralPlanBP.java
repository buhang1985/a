package iih.sc.scp.s.bp.oral;

import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scp.s.bp.GetOralPlanOptSrvBP;
import iih.sc.scp.s.ep.OralScplEP;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scploptsrv.d.ScPlOptSrvDO;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;

/**
 * 删除口腔科排班计划BP
 * 
 * @author zhengcm
 * @date 2016-09-26 11:27:45
 *
 */
public class DeleteOralPlanBP {

	/**
	 * 删除口腔科排班计划
	 *
	 * @param id_scpl 排班计划id
	 * @throws BizException
	 * @author zhengcm
	 */
	public void exec(String id_scpl) throws BizException {
		// 1、检查参数
		ScValidator.validateParam("id_scpl", id_scpl);

		OralScplEP oralScplEP = new OralScplEP();

		// 2、获取排班计划
		ScPlanDO planDO = oralScplEP.getPlanById(id_scpl);

		// 3、获取排班计划备选服务
		ScPlOptSrvDO[] planOptSrvDOs = new GetOralPlanOptSrvBP().exec(id_scpl);

		// 4、获取排班周计划
		ScplweekAggDO[] planWeekAggDOs = this.getPlanWeekAggDO(id_scpl);

		// 5、获取排班周计划号位
		ScPlanWeekTickDO[] planWeekTickDOs = this.getPlanWeekTickDO(planWeekAggDOs);

		// 6、删除排班周计划号位
		oralScplEP.deletePlanWeekTick(planWeekTickDOs);

		// 7、删除排班周计划
		oralScplEP.deletePlanWeekAgg(planWeekAggDOs);

		// 8、删除排班备选服务
		oralScplEP.deletePlanOptSrv(planOptSrvDOs);

		// 9、删除排班计划
		oralScplEP.deletePlan(new ScPlanDO[] { planDO });
	}

	/**
	 * 获取排班周计划AggDO
	 *
	 * @param id_scpl 排班计划id
	 * @return 排班周计划AggDO数组
	 * @throws BizException
	 * @author zhengcm
	 */
	private ScplweekAggDO[] getPlanWeekAggDO(String id_scpl) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_scpl)) {
			return null;
		}
		String where = String.format("id_scpl = '%s'", id_scpl);
		return new OralScplEP().getPlanWeekAggByCond(where, null);
	}

	/**
	 * 获取排班周计划号位
	 *
	 * @param aggDOs 排班周计划AggDO数组
	 * @return 排班周计划号位DO数组
	 * @throws BizException
	 * @author zhengcm
	 */
	private ScPlanWeekTickDO[] getPlanWeekTickDO(ScplweekAggDO[] aggDOs) throws BizException {
		if (ArrayUtil.isEmpty(aggDOs)) {
			return null;
		}
		List<String> ids = new ArrayList<String>();
		for (ScplweekAggDO aggDO : aggDOs) {
			if (!StringUtil.isEmptyWithTrim(aggDO.getParentDO().getId_scplweek())) {
				ids.add(aggDO.getParentDO().getId_scplweek());
			}
		}
		if (ListUtil.isEmpty(ids)) {
			return null;
		}
		String where = ScSqlUtils.getInSqlByIds("id_scplweek", ids);
		return new OralScplEP().getPlanWeekTickByCond(where, null);
	}

}
