package iih.mp.nr.splitplan.i;

import iih.mp.mpbd.exerepair.d.ExeRepairCondDTO;
import iih.mp.nr.dto.splitrtn.d.SplitRes;
import iih.mp.nr.mporplan.d.MpOrPlanDO;
import iih.mp.nr.mpsrvplan.d.MpSrvPlanDO;
import iih.mp.nr.splitplan.splitrequest.d.ComSpQueParamDTO;
import xap.mw.core.data.BizException;

public interface IMpPlanRequestService {

	/**
	 * 住院_通用执行拆解请求
	 * 
	 * @param DO
	 * @throws BizException
	 */
	public abstract String mpSplitRequest(ComSpQueParamDTO ParamDTO) throws BizException;

	/**
	 * 门急诊_执行拆解请求
	 * @param id_ors
	 * @throws BizException
	 */
	public abstract void mpSplitRequestOut(String[] id_ors) throws BizException;

	/**
	 * 住院医嘱预拆分(执行数据修复)
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract SplitRes mpPreSplitRequest(ExeRepairCondDTO ParamDTO) throws BizException;

	/**
	 * 初始化医嘱计划
	 * 
	 * @param rtn
	 * @return
	 * @throws BizException
	 */
	public MpOrPlanDO[] initOrPlan(SplitRes rtn) throws BizException;

	/**
	 * 初始化服务计划
	 * 
	 * @param rtn
	 * @return
	 * @throws BizException
	 */
	public MpSrvPlanDO[] initSrvPlan(SplitRes rtn) throws BizException;

}
