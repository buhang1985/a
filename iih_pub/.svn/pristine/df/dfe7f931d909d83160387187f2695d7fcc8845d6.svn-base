package iih.mp.nr.i;

import iih.mp.nr.dto.d.ComEusuParamDTO;
import iih.mp.nr.dto.d.ComFgdggetParamDTO;
import iih.mp.nr.dto.d.ComParamDTO;
import iih.mp.nr.dto.d.EusuParamDTO;
import iih.mp.nr.dto.d.FgdggetParamDTO;
import iih.mp.nr.dto.d.OrSrvEusuParamDTO;
import iih.mp.nr.mporplan.d.MpOrPlanDO;
import iih.mp.nr.mpsrvplan.d.MpSrvPlanDO;
import xap.mw.core.data.BizException;

public interface IMpSetEusuOrFgdggetService {

	/**
	 * 通用医嘱执行记录主表（MP_OR_PR）执行状态变更
	 * 
	 * @param param
	 * @return
	 */
	public abstract MpOrPlanDO[] comSetMporprEusu(ComParamDTO[] param) throws BizException;

	/**
	 * 通用医嘱执行记录子表（MP_OR_PR_SRV）执行状态变更
	 * 
	 * @param param
	 * @return
	 */
	public abstract MpSrvPlanDO[] comSetMporsrvEusu(ComEusuParamDTO[] param) throws BizException;

	/**
	 * 通用医嘱执行记录子表（MP_OR_OR_SRV）修改摆药状态
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract MpSrvPlanDO[] comSetFgdgget(ComFgdggetParamDTO[] param) throws BizException;

	/**
	 * 药品_医嘱执行记录子表（MP_OR_PR_SRV）执行状态变更
	 * 
	 * @param param
	 * @return
	 */
	public abstract MpSrvPlanDO[] setMporsrvEusu(EusuParamDTO[] param) throws BizException;

	/**
	 * 药品_医嘱执行记录子表（MP_OR_OR_SRV）修改摆药状态
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract MpSrvPlanDO[] setFgdgget(FgdggetParamDTO[] param) throws BizException;

	/**
	 * 医嘱状态更新（没有闭环/不参与拆分的医嘱，适用门诊，住院）
	 * 
	 * @param param
	 * @throws BizException
	 */
	public abstract Integer updateOrderStatus(ComParamDTO[] param) throws BizException;

	/**
	 * 更改医嘱项目执行状态
	 * 
	 * @param params
	 * @throws BizException
	 */
	public abstract void updateOrSrvStatus(OrSrvEusuParamDTO[] params) throws BizException;
}
