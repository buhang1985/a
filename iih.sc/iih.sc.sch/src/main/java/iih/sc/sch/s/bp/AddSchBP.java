package iih.sc.sch.s.bp;

import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.d.desc.ScPlanDODesc;
import iih.sc.scp.scplan.i.IScplanRService;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**新增排班
 * @author ccj 
 *
 */
public class AddSchBP {
	/**
	 * 根据计划生成排班和号表号位
	 * @param startStr 开始时间
	 * @param endStr 结束时间	
	 * @param Id_dep 科室
	 * @param Id_scpl 计划
	 * @param Fg_recover 是否覆盖
	 * @param sctp 排班分类code
	 * @return 返回本次排班所有未排班的情况
	 * @throws Exception
	 */
	public String exec(String startStr,String endStr,String id_dep,String id_scpl,FBoolean fg_recover,String sctp)throws BizException{
		if(StringUtils.isBlank(startStr) || StringUtils.isBlank(endStr) || fg_recover == null || StringUtils.isBlank(sctp)) return null;
		IScplanRService planSrv = ServiceFinder.find(IScplanRService.class);
		AddSchByOnePlanBp addSchByOnePlanBp = new AddSchByOnePlanBp();
		String msg = null;  //返回没有排班成功排班信息
		if(StringUtils.isEmpty(id_dep)){
			// 找排班分类是门诊的所有计划 生成全院计划
			ScPlanDO[] planDOs = planSrv.findByAttrValString(ScPlanDO.SD_SCTP, sctp);
			if(planDOs == null || planDOs.length == 0) return null;
			msg = addSch(addSchByOnePlanBp, planDOs, startStr, endStr, fg_recover);
		}else if(StringUtils.isEmpty(id_scpl)){
			// 部门不为null 计划为null  部门排班
			ScPlanDO[] planDOs = planSrv.find(ScPlanDODesc.TABLE_ALIAS_NAME+".Id_dep = '"+
			id_dep+"' and "+ScPlanDODesc.TABLE_ALIAS_NAME+".Sd_sctp = '"+sctp+"'", "", FBoolean.TRUE);
			if(planDOs == null || planDOs.length == 0) return null;
			msg = addSch(addSchByOnePlanBp, planDOs, startStr, endStr, fg_recover);
		}else if(StringUtils.isNotEmpty(id_dep) && StringUtils.isNotEmpty(id_scpl)){
			//生成一个计划的
			ScPlanDO planDO = planSrv.findById(id_scpl);
			if(planDO == null) return null;
			msg = addSch(addSchByOnePlanBp, new ScPlanDO[]{planDO}, startStr, endStr, fg_recover);
		}
		return msg;
	}
	
	/**排班
	 * @param addSchByOnePlanBp 
	 * @param planDOs  计划arrays
	 * @param startStr	开始时间
	 * @param endStr	结束时间
	 * @param fg_recover	覆盖标识
	 * @return 返回本次排班所有未排班的情况
	 * @throws BizException
	 */
	private String addSch(AddSchByOnePlanBp addSchByOnePlanBp,ScPlanDO[] planDOs,String startStr,String endStr,FBoolean fg_recover) throws BizException{
		if(ArrayUtils.isEmpty(planDOs)) return null;
		StringBuffer sb = new StringBuffer();  
		for (ScPlanDO scPlanDO : planDOs) {
			String currentInformation = addSchByOnePlanBp.exec(startStr,endStr,scPlanDO,fg_recover);
			if(StringUtils.isNotEmpty(currentInformation)){
				sb.append(currentInformation);
			}
		}
		return sb.toString();
	}
	
}
