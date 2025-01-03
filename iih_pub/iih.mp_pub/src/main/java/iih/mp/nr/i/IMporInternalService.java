package iih.mp.nr.i;

import iih.mp.nr.dto.internal.d.OrPlanDTO;
import iih.mp.nr.dto.internal.d.OrSrvPlanDTO;
import iih.mp.nr.dto.internal.d.OrderDTO;
import iih.mp.nr.dto.internal.d.PlanDTO;
import iih.mp.nr.dto.internal.d.StatusDTO;
import iih.mp.nr.setmaterialbill.d.SetMetrailBillDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

public interface IMporInternalService {

	/**
	 * 通用医嘱执行计划闭环状态更新（医嘱）
	 * 
	 * @param DTOS
	 * @param fun_code
	 * @param Oper_code
	 * @throws BizException
	 */
	public void updateOrpltpByOr(OrPlanDTO[] DTOS, String fun_code, String Oper_code) throws BizException;

	/**
	 * 通用医嘱执行计划闭环状态更新（含记账点 医嘱闭环配置 配置的记账点 记账）
	 * 
	 * @param DTOS
	 * @param fun_code
	 * @param Oper_code （操作类型 可空）
	 * @param fg_postpaid (是否支持后计费)
	 * @throws BizException
	 */
	public void updateOrpltpAndChargeByOr(OrPlanDTO[] DTOS, String fun_code, String Oper_code, FBoolean fg_postpaid) throws BizException;
	
	/**
	 * 通用医嘱执行计划闭环状态更新（计划）
	 * 
	 * @param DTOS
	 * @param fun_code
	 * @param Oper_code
	 * @throws BizException
	 */
	public void updateOrpltpByPlan(PlanDTO[] DTOS, String fun_code, String Oper_code) throws BizException;

	/**
	 * 根据医嘱ID更新执行计划闭环状态（适用草药）
	 * 
	 * @param id_ors
	 * @param fun_code
	 * @param Oper_code
	 * @throws BizException
	 */
	public void updateOrpltpByIdOr(OrderDTO[] DTOS, String fun_code, String Oper_code) throws BizException;

	// /**
	// * 根据执行计划计费
	// *
	// * @param Id_or_prs
	// * @throws BizException
	// */
	// public abstract void setBillByPlan(String[] Id_or_prs, String source)
	// throws BizException;
	//
	// /**
	// * 根据计费参数计费
	// *
	// * @param Id_or_srvs
	// * @param paramdtos
	// * @throws BizException
	// */
	// public abstract void setBillByParam(SetMetrailBillDTO[] paramDTOS, String
	// source) throws BizException;
	//
	// /**
	// * 根据执行计划和计费参数计费
	// *
	// * @param Id_or_prs
	// * @param DTOS
	// * @throws BizException
	// */
	// public abstract void setBillByPlanAndParam(String[] Id_or_prs,
	// SetMetrailBillDTO[] paramDTOS, String source) throws BizException;

	/**
	 * 获取医技确认计划
	 * 
	 * @param id_pats
	 * @return
	 * @throws BizException
	 */
	public abstract String[] getConfirmPlansByPats(String[] id_pats, FDateTime dt_b, FDateTime dt_e) throws BizException;

	/**
	 * 获取医技取消计划
	 * 
	 * @param id_pats
	 * @return
	 * @throws BizException
	 */
	public abstract String[] getCancelPlansByPats(String[] id_pats,FDateTime dt_b,FDateTime dt_e) throws BizException;

	/**
	 * 医嘱计划维度取消
	 * 
	 * @param orPlans
	 * @throws BizException
	 */
	public abstract void cancelByOrPan(OrPlanDTO[] orPlans) throws BizException;

	/**
	 * 根据医嘱执行闭环配置回退闭环状态 (根据记账点 标识 判定是否退费)
	 * @param orPlans
	 * @throws BizException
	 */
	public abstract void cancelAndRefundByOrPan(OrPlanDTO[] orPlans) throws BizException;
	
	/**
	 * 第三方系统取消
	 * @param orPlans
	 * @throws BizException
	 */
	public abstract void cancelByOtherSys(OrPlanDTO[] orPlans) throws BizException;

	/**
	 * 计划维度取消
	 * 
	 * @param orPlans
	 * @throws BizException
	 */
	public abstract void cancelByPlan(PlanDTO[] plans) throws BizException;

	/**
	 * 医嘱项目计划取消
	 * 
	 * @param orSrvPlans
	 * @throws BizException
	 */
	public abstract void cancelByOrSrvPan(OrSrvPlanDTO[] orSrvPlans) throws BizException;

	/**
	 * 护理文书表Sql生成
	 * 
	 * @param id_class
	 * @return
	 */
	public abstract String createNuSqlStr(String id_class, String creatTableStr) throws BizException;

	/**
	 * 患者在院校验
	 * 
	 * @param id_ent
	 * @throws BizException
	 */
	public abstract void patientOutValidation(String[] id_ents) throws BizException;

	/**
	 * 更新不拆分的医嘱（有闭环）状态
	 * 
	 * @param params
	 * @param fun_code
	 * @param fg_default
	 * @throws BizException
	 */
	public abstract void updateOrStatusWhitOutPlan(OrderDTO[] params, String fun_code, FBoolean fg_default) throws BizException;

	/**
	 * 回退不拆分的医嘱状态
	 * @param id_ors
	 * @throws BizException
	 */
	public abstract void cancelByOrWithNoPlanBp(String[] id_ors) throws BizException;

	/**
	 * 手动更新医嘱执行状态,入参为PlanDTO，不依赖闭环
	 * 
	 * @param params
	 * @throws BizException
	 */
	public abstract void manualUpdateOrderStatus(OrPlanDTO[] params) throws BizException;

	/**
	 * 药品拒摆处理
	 * @param id_or_pr_srvs
	 * @throws BizException
	 */
	public abstract void drugsRefuse(String[] id_or_pr_srvs) throws BizException;
	
	/**
	 * 药品取消拒摆处理
	 * @param id_or_pr_srvs
	 * @throws BizException
	 */
	public abstract void drugsRefuseCancel(String[] id_or_pr_srvs) throws BizException;
	
	/**
	 * 第三方接口医嘱执行计划闭环状态更新（含记账点 医嘱闭环配置 配置的记账点 记账）
	 * @param fg_postpaid 
	 */
	public abstract void updateOrpltpAndChargeByOuter(OrPlanDTO[] orplans, StatusDTO statusDTOs, FBoolean fg_postpaid) throws BizException;

	/**
	 * (标准接口)医嘱状态更新接口专用    门诊退计费
	 * @param id_ors
	 * @throws BizException
	 */
	public abstract void mpOpOrderRefund(String[] id_ors) throws BizException;
}
