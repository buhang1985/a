package iih.bl.cg.ip.s;

import iih.bl.cg.ip.dto.d.IpCompensateBillDTO;
import iih.bl.cg.ip.dto.d.UsageStrategyDTO;
import iih.bl.cg.ip.i.IExecuChargeService;
import iih.bl.cg.ip.s.bp.ExecuChargeBaseBp;
import iih.bl.cg.ip.s.bp.ExecuChargeMultiPatBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 执行记账接口实现类，业务集合
 * @author yangyang
 * @Date 2017-10-21
 */
@Service(serviceInterfaces = { IExecuChargeService.class }, binding = Binding.JSONRPC)
public class ExecuChargeServiceImpl implements IExecuChargeService {

	/**	多患者执行计费(多患者发药)，发药确费，因为药品的价格在发药方获得，所以需要校验比较多的内容
	 * @param billParamDtoLst 计费明细
	 * @return 计费后的详细信息
	 * @throws BizException
	 */
	@Override
	public IpCompensateBillDTO[] execuChargeWithMultipat(
			IpCompensateBillDTO[] billParamDtoLst) throws BizException {
		ExecuChargeMultiPatBp handlerBp=new ExecuChargeMultiPatBp();
		return handlerBp.exec(billParamDtoLst);
	}
	
	/** 医技执行计费,依托于医嘱服务项目，计算价格并组装
	 * @return 记账后信息
	 * @throws BizException
	 */
	@Override
	public IpCompensateBillDTO[] execuChargeBase(IpCompensateBillDTO[] billParamDtoLst,UsageStrategyDTO[] usageStrategyDtoArr) throws BizException
	{
		ExecuChargeBaseBp handlerBp=new ExecuChargeBaseBp();
		return handlerBp.exec(billParamDtoLst, usageStrategyDtoArr);
	}

}
