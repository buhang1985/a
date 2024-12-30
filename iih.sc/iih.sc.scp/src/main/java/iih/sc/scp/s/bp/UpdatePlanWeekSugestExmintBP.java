package iih.sc.scp.s.bp;

import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scp.s.ep.ScplEp;
import iih.sc.scp.s.ep.ScplWeekEP;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FTime;

/**
 * 更新计划周的推荐提前报到时间（当前日期及之后的计划周）BP
 * 
 * @author zhengcm
 * @date 2017-11-29 09:32:50
 *
 */
public class UpdatePlanWeekSugestExmintBP {

	/**
	 * 更新计划周的推荐提前报到时间
	 * 
	 * @author zhengcm
	 * @date 2017-11-29 09:33:07
	 *
	 * @param deptId
	 * @param sugestVal
	 * @throws BizException
	 */
	public void exec(ScDeptParamDO paramDO, ScDeptParamDsDO[] newDsDO, ScDeptParamDsDO[] oldDsDO) throws BizException {
		// 检查参数
		ScValidator.validateParam("deptId", paramDO.getId_dep());
		ScValidator.validateParam("sugestVal", paramDO.getSugest_exmint());
		ScValidator.validateParam("id_scca", paramDO.getId_scca());
		// 本科室计划ID
		List<String> planIdList = this.getAllDeptPlanIds(paramDO.getId_dep(), paramDO.getId_scca());
		// 更新计划周建议提前到达时间
		this.updateAllWeekSugestExmint(planIdList, paramDO.getSugest_exmint(), newDsDO, oldDsDO);
	}

	/**
	 * 获取本科室的所有计划ID
	 * 
	 * @author zhengcm
	 * @date 2017-11-29 09:39:04
	 *
	 * @param deptId
	 * @return
	 * @throws BizException
	 */
	private List<String> getAllDeptPlanIds(String deptId, String id_scca) throws BizException {
		String where = String.format("id_dep = '%s' and id_scca = '%s' ", deptId, id_scca);
		ScPlanDO[] planDOs = new ScplEp().getScPls(where, null);
		if (ArrayUtil.isEmpty(planDOs)) {
			return null;
		}
		List<String> planIdList = new ArrayList<String>();
		for (ScPlanDO planDO : planDOs) {
			String id_scpl = planDO.getId_scpl();
			if (!planIdList.contains(id_scpl)) {
				planIdList.add(id_scpl);
			}
		}
		return planIdList;
	}

	/**
	 * 更新计划周的推荐提前到达时间
	 * 
	 * @author zhengcm
	 * @date 2017-11-29 09:52:37
	 *
	 * @param planIdList
	 * @param sugestVal
	 * @throws BizException
	 */
	private void updateAllWeekSugestExmint(List<String> planIdList, int sugestVal, ScDeptParamDsDO[] newDsDOs,
			ScDeptParamDsDO[] oldDsDOs) throws BizException {
		if (ListUtil.isEmpty(planIdList)) {
			return;
		}
		ScplWeekEP weekEP = new ScplWeekEP();
		String where = ScSqlUtils.getInSqlByIds("id_scpl", planIdList);
		ScPlanWeekDO[] weekDOs = weekEP.getPlWeekByCond(where, null);
		if (ArrayUtil.isEmpty(weekDOs)) {
			return;
		}
		Map<String, FTime> map = new HashMap<String, FTime>();
		// 将原有医技科室参数数据存到map里 key:日期分组id value: 停止挂号时间
		for (ScDeptParamDsDO oldDsDO : oldDsDOs) {
			map.put(oldDsDO.getId_dayslot(), oldDsDO.getT_end_reg());
		}

		// 循环排班计划
		for (ScPlanWeekDO weekDO : weekDOs) 
		{
			// 循环新保存数据
			for (ScDeptParamDsDO newDsDO : newDsDOs) 
			{
				weekDO.setStatus(DOStatus.UPDATED);
				weekDO.setSugest_exmint(sugestVal);
				// 如果日期分组分组相同 ,原有科室参数中的停止挂号时间与排班计划总的停止挂号时间相同,修改排班计划中的停止挂号时间
				if (weekDO.getId_dayslot().equals(newDsDO.getId_dayslot())
						&& map.get(weekDO.getId_dayslot()).equals(weekDO.getT_e_reg())) {
					weekDO.setT_e_reg(newDsDO.getT_end_reg());
					break;
				}
			}
		}

		weekEP.save(weekDOs);
	}
}
