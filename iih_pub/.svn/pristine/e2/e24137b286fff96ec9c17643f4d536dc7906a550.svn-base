package iih.mp.nr.splitplan.i;

import iih.ci.ord.dto.blexorder.d.OrSplitOrderDTO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import iih.mp.nr.infusion.d.InfusionDO;
import iih.mp.nr.mporplan.d.MpOrPlanDO;
import iih.mp.nr.mpsrvplan.d.MpSrvPlanDO;
import xap.mw.core.data.BizException;

public interface IMpPlanWriteInService {

	/**
	 * 执行点主记录写入
	 * 
	 * @param MporParamDTO
	 * @return true 成功 false 失败
	 * @throws BizException
	 */
	public abstract MpOrPlanDO[] mpOrPlanWriteIn(OrSplitOrderDTO[] ParamDTO) throws BizException;
	
	/**
	 * 执行点子记录写入
	 * 
	 * @param MporSrvParamDTO
	 * @return true 成功 false 失败
	 * @throws BizException
	 */
	public abstract MpSrvPlanDO[] mpSrvPlanWriteIn(SrvSplitOrderDTO[] ParamDTO) throws BizException;
	
	/**
	 * 输液签写入记录
	 * @param ParamDTO
	 * @return
	 * @throws BizException
	 */
	public abstract InfusionDO[] mpDgInfusionWriteIn(MpOrPlanDO[] paramDO) throws BizException;
}
