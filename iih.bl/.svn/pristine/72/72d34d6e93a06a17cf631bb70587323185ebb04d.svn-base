package iih.bl.cg.s;

import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgErrorDTO;
import iih.bl.cg.dto.cglogic.d.BlCgOpAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.i.IBlCgAccountService;
import iih.bl.cg.s.cglogic.et.BlEtKeepAccountBP;
import iih.bl.cg.s.cglogic.et.BlEtRefundAccountBP;
import iih.bl.cg.s.cglogic.ip.BlIpCheckBeforeKeepBP;
import iih.bl.cg.s.cglogic.ip.BlIpKeepAccountBP;
import iih.bl.cg.s.cglogic.ip.BlIpRefundAccountBP;
import iih.bl.cg.s.cglogic.op.BlOpKeepAccountBP;
import iih.bl.cg.s.cglogic.op.BlOpRefundAccountBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 费用域记账服务
 * @author ly 2018/06/23
 *
 */
@Service(serviceInterfaces = { IBlCgAccountService.class }, binding = Binding.JSONRPC)
public class BlCgAccountServiceImpl implements IBlCgAccountService {

	/**
	 * 门诊记账
	 * @param accDtos 待记账数据
	 * @param accSetDto 记账配置
	 * @return 记账结果
	 * @throws BizException
	 */
	@Override
	public BlCgAccountRltDTO keepAccountForOp(BlCgAccountDTO[] accDtos,BlCgOpAccountSetDTO accSetDto) throws BizException {
		BlOpKeepAccountBP bp = new BlOpKeepAccountBP();
		return bp.exec(accDtos, accSetDto);
	}
	
	/**
	 * 门诊退记账
	 * @param refundDtos 退记账数据
	 * @param accSetDto 退记账配置
	 * @return 退记账结果
	 * @throws BizException
	 */
	@Override
	public BlCgAccountRltDTO refundAccountForOp(BlCgRefundAccountDTO[] refundDtos, BlCgRefundAccountSetDTO accSetDto) throws BizException {
		BlOpRefundAccountBP bp = new BlOpRefundAccountBP();
		return bp.exec(refundDtos, accSetDto);
	}
	
	/**
	 * 急诊记账
	 * @param accDtos
	 * @param accSetDto
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlCgAccountRltDTO keepAccountForEt(BlCgAccountDTO[] accDtos, BlCgAccountSetDTO accSetDto) throws BizException{
		BlEtKeepAccountBP bp = new BlEtKeepAccountBP();
		return bp.exec(accDtos, accSetDto);
	}
	
	/**
	 * 急诊退记账
	 * @param accDtos
	 * @param accSetDto
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlCgAccountRltDTO refundAccountForEt(BlCgRefundAccountDTO[] accDtos, BlCgRefundAccountSetDTO accSetDto) throws BizException{
		BlEtRefundAccountBP bp = new BlEtRefundAccountBP();
		return bp.exec(accDtos, accSetDto);
	}
	
	/**
	 * 住院记账
	 * @param accDtos 待记账数据
	 * @param accSetDto 记账配置
	 * @return 记账结果
	 * @throws BizException
	 */
	@Override
	public BlCgAccountRltDTO keepAccountForIp(BlCgAccountDTO[] accDtos,BlCgAccountSetDTO accSetDto) throws BizException{
		BlIpKeepAccountBP bp = new BlIpKeepAccountBP();
		return bp.exec(accDtos, accSetDto);
	}

	/**
	 * 住院退记账
	 * @param refundDtos 退记账数据
	 * @param accSetDto 退记账配置
	 * @return 退记账结果
	 * @throws BizException
	 */
	@Override
	public BlCgAccountRltDTO refundAccountForIp(BlCgRefundAccountDTO[] refundDtos, BlCgRefundAccountSetDTO accSetDto) throws BizException {
		BlIpRefundAccountBP bp = new BlIpRefundAccountBP();
		return bp.exec(refundDtos, accSetDto);
	}
	
	/**
	 * 住院记账校验逻辑
	 * @param accDtos 待记账数据
	 * @param accSetDto 记账配置
	 * @return 校验结果
	 * @throws BizException
	 */
	@Override
	public BlCgErrorDTO[] checkBeforeKeepAccountForIp(BlCgAccountDTO[] accDtos,BlCgAccountSetDTO accSetDto) throws BizException{
		BlIpCheckBeforeKeepBP bp = new BlIpCheckBeforeKeepBP();
		return bp.exec(accDtos, accSetDto);
	}
}
