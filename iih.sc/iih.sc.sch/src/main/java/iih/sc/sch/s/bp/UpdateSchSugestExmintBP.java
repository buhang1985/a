package iih.sc.sch.s.bp;

import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.SchPlEP;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FTime;

/**
 * 更新指定科室排班的建议提前报到时间（当前日期及之后的排班）BP
 * 
 * @author zhengcm
 * @date 2017-11-29 10:21:35
 *
 */
public class UpdateSchSugestExmintBP {

	/**
	 * 更新指定科室排班的建议提前报到时间（当前日期及之后的排班）
	 * 
	 * @author zhengcm
	 * @date 2017-11-29 10:21:55
	 *
	 * @param deptId
	 * @param sugestVal
	 * @throws BizException
	 */
	public void exec(ScDeptParamDO paramDO,ScDeptParamDsDO[] newDsDOs,ScDeptParamDsDO[] oldDsDOs) throws BizException {
		// 检查参数
		ScValidator.validateParam("deptId", paramDO.getId_dep());
		ScValidator.validateParam("sugestVal", paramDO.getSugest_exmint());
		ScValidator.validateParam("id_scca", paramDO.getId_scca());
		// 当前科室的排班计划ID
		List<String> planIdList = this.getAllPlanIdList( paramDO.getId_dep(),paramDO.getId_scca());
		// 更新排班推荐提前报到时间
		this.updateSchSugestExmint(planIdList, paramDO, newDsDOs,oldDsDOs);
	}

	/**
	 * 获取科室排班计划ID
	 * 
	 * @author zhengcm
	 * @date 2017-11-29 10:31:56
	 *
	 * @param deptId
	 * @return
	 * @throws BizException
	 */
	private List<String> getAllPlanIdList(String deptId,String id_scca) throws BizException {
		String where = String.format("id_dep = '%s' and id_scca = '%s'", deptId,id_scca);
		ScPlanDO[] planDOs = new SchPlEP().getScPlanByWhere(where);
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
	 * 更新排班推荐提前报到时间
	 * 
	 * @author zhengcm
	 * @date 2017-11-29 10:44:23
	 *
	 * @param planIdList
	 * @param sugestVal
	 * @throws BizException
	 */
	private void updateSchSugestExmint(List<String> planIdList, ScDeptParamDO paramDO,ScDeptParamDsDO[] newDsDOs,ScDeptParamDsDO[] oldDsDOs) throws BizException {
		if(ListUtil.isEmpty(planIdList)){
			return ;
		}
		SchEP schEP = new SchEP();
		String cond = ScSqlUtils.getInSqlByIds("id_scpl", planIdList) + " and d_sch >= '"
				+ ScAppUtils.getServerDate().toLocalString() + "'";
		ScSchDO[] schDOs = schEP.getSchByCond(cond, null);
		if (ArrayUtil.isEmpty(schDOs)) {
			return;
		}
		
	
		List<ScSchDO> schDOList = new ArrayList<ScSchDO>();
		//循环排班
		for (ScSchDO schDO : schDOs) 
		{
			if (StringUtil.isEmptyWithTrim(schDO.getId_depparam())
					|| (!StringUtil.isEmptyWithTrim(schDO.getId_depparam()) && schDO.getId_depparam().equals(
							paramDO.getId_deptparam()))) {
				//循环 需保存的排班分类的午别信息
				for(ScDeptParamDsDO  newDsDO : newDsDOs)
				{
					//判断排班的午别与新午别信息相同
					if(newDsDO.getId_dayslot().equals(schDO.getId_dayslot()))
					{
						//循环保存之前的分类午别
						for(ScDeptParamDsDO oldDsDO : oldDsDOs)
						{
							//午别相同,停止挂号时间相同,修改排班停止挂号时间
							if(oldDsDO.getId_dayslot().equals(newDsDO.getId_dayslot()) && oldDsDO.getT_end_reg().equals(schDO.getT_e_reg()))
							{
								schDO.setT_e_reg(newDsDO.getT_end_reg());
								break;
							}
						}
						break;
					}
				}
				schDO.setStatus(DOStatus.UPDATED);
				schDO.setSugest_exmint(paramDO.getSugest_exmint());
				schDOList.add(schDO);
			}
		}
		schEP.save(schDOList.toArray(new ScSchDO[0]));
	}
}
