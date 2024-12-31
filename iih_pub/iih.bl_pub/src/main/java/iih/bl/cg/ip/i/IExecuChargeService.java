package iih.bl.cg.ip.i;

import iih.bl.cg.ip.dto.d.IpCompensateBillDTO;
import iih.bl.cg.ip.dto.d.UsageStrategyDTO;
import xap.mw.core.data.BizException;

/**
 * 住院执行计费接口类
 * 包括医技执行计费、药品发药计费
 * @author yi
 * @Date 2017-09-21
 */
public interface IExecuChargeService
{
	/**	多患者执行计费，由医嘱信息发起
	 * @param billParamDtoLst 计费明细
	 * @return 计费后的详细信息
	 * @throws BizException
	 */
	IpCompensateBillDTO[] execuChargeWithMultipat(IpCompensateBillDTO[] billParamDtoLst) throws BizException;
	
	/**
	 * 医技执行补费
	 * @param billParamDtoLst 记账明细内容
	 * @param usageStrategyDtoArr 用法策略DTO
	 * @return
	 * @throws BizException
	 */
	IpCompensateBillDTO[] execuChargeBase(IpCompensateBillDTO[] billParamDtoLst,UsageStrategyDTO[] usageStrategyDtoArr) throws BizException;
}
