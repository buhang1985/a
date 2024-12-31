package iih.mi.itf.bizflowitf;

import iih.mi.biz.flow.oepchargeflow.d.MiOepChargePaySelfInParamDTO;
import iih.mi.biz.flow.oepchargeflow.d.MiOepChargePaySelfOutParamDTO;
import iih.mi.biz.flow.oepchargeflow.d.MiOepChargePricingSelfInParamDTO;
import iih.mi.biz.flow.oepchargeflow.d.MiOepChargePricingSelfOutParamDTO;
import iih.mi.itf.bizgrpitf.param.ResultOutParamDTO;
import xap.mw.core.data.BizException;

/**
 * 
 * 门诊医保流程
 * @author ly 2019/07/02
 *
 */
public interface OepFlowChargeItf {

	/**
	 * 自助机医保后台划价流程
	 * (本流程适用于给自助机提供交易入参模式)
	 * @param inParam 入参
	 * @return 结果
	 * @throws BizException
	 * @author ly 2019/07/02
	 */
	public abstract ResultOutParamDTO<MiOepChargePricingSelfOutParamDTO> onPricingSelf(MiOepChargePricingSelfInParamDTO inParam) throws BizException;
	
	/**
	 * 自助机医保后台收付款流程
	 * (本流程适用于给自助机提供交易入参模式)
	 * @param inParam 入参
	 * @return 结果
	 * @throws BizException
	 * @author ly 2019/07/02
	 */
	public abstract ResultOutParamDTO<MiOepChargePaySelfOutParamDTO> onPaySelf(MiOepChargePaySelfInParamDTO inParam) throws BizException;
	
}
 