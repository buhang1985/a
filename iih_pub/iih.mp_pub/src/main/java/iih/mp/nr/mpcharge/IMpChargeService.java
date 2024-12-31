package iih.mp.nr.mpcharge;

import iih.mp.nr.api.d.PlanParamDTO;
import iih.mp.nr.mpcharge.d.MpChargeByOrprDTO;
import iih.mp.nr.mpcharge.d.MpChargeByOrprSrvDTO;
import iih.mp.nr.mpcharge.d.MpChargeDTO;
import iih.mp.nr.mpcharge.d.MpChargeRltDTO;
import iih.mp.nr.mpcharge.d.MpChargeSetDTO;
import iih.mp.nr.mpcharge.d.MpRefundChargeSetDTO;
import iih.mp.nr.mpcharge.d.MpRefundDTO;
import xap.mw.core.data.BizException;

/**
 * 执行记账 
 * 
 * @author xuxing_2018年6月25日10:39:58
 * @version xuxing_退记账参数类型更换
 *
 */
public interface IMpChargeService {

	/**
	 * 原生执行记账
	 * 
	 * @param params
	 * @param paramSet
	 * @return
	 * @throws BizException
	 */
	public abstract MpChargeRltDTO[] mpChargingByOrig(MpChargeDTO[] params, MpChargeSetDTO paramSet) throws BizException;

	/**
	 * 住院执行记账（医嘱计划）
	 * 
	 * @param id_or_prs
	 * @param paramSet
	 * @throws BizException
	 */
	public abstract MpChargeRltDTO[] mpChargingByOrpr(String[] id_or_prs, MpChargeSetDTO paramSet) throws BizException;

	/**
	 * 住院执行记账（服务计划）
	 * 
	 * @param id_or_pr_srvs
	 * @throws BizException
	 */
	public abstract MpChargeRltDTO[] mpChargingByOrprSrv(String[] id_or_pr_srvs, MpChargeSetDTO paramSet) throws BizException;
	
	/**
	 * 住院执行记账（医嘱计划，含审计信息）
	 * 
	 * @param id_or_prs
	 * @param paramSet
	 * @throws BizException
	 */
	public abstract MpChargeRltDTO[] mpChargingByOrprDtl(MpChargeByOrprDTO[] inParams, MpChargeSetDTO paramSet) throws BizException;

	/**
	 * 住院执行记账（服务计划，含审计信息）
	 * 
	 * @param id_or_pr_srvs
	 * @throws BizException
	 */
	public abstract MpChargeRltDTO[] mpChargingByOrprSrvDtl(MpChargeByOrprSrvDTO[] inParams, MpChargeSetDTO paramSet) throws BizException;	
	
	/**
	 * BS024记账
	 * 
	 * @param params
	 * @throws BizException
	 */
	public abstract void chargeForBS024(PlanParamDTO[] params) throws BizException;

	/**
	 * 原生执行退记账
	 * 
	 * @param params
	 * @param paramSet
	 * @return
	 * @throws BizException
	 */
	public abstract MpChargeRltDTO[] mpRefundByOrig(MpRefundDTO[] params, MpRefundChargeSetDTO paramSet) throws BizException;

	/**
	 * 执行退记账（医嘱计划）
	 * 
	 * @param id_or_prs
	 * @param paramSet
	 * @throws BizException
	 */
	public abstract MpChargeRltDTO[] mpRefundByOrpr(String[] id_or_prs, MpRefundChargeSetDTO paramSet) throws BizException;

	/**
	 * 执行退记账（服务计划）
	 * 
	 * @param id_or_prs
	 * @param paramSet
	 * @throws BizException
	 */
	public abstract MpChargeRltDTO[] mpRefundByOrprSrv(String[] id_or_pr_srvs, MpRefundChargeSetDTO paramSet) throws BizException;

}
