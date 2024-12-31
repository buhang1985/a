package iih.bl.cg.i;

import xap.mw.core.data.BizException;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgErrorDTO;
import iih.bl.cg.dto.cglogic.d.BlCgOpAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;

/**
 * 费用域记账服务
 * @author ly 2018/06/23
 *
 */
public interface IBlCgAccountService {

	/**
	 * 门诊记账
	 * @param accDtos 待记账数据
	 * @param accSetDto 记账配置
	 * @return 记账结果
	 * @throws BizException
	 */
	public abstract BlCgAccountRltDTO keepAccountForOp(BlCgAccountDTO[] accDtos,BlCgOpAccountSetDTO accSetDto) throws BizException;
	
	/**
	 * 门诊退记账
	 * @param refundDtos 退记账数据
	 * @param accSetDto 退记账配置
	 * @return 退记账结果
	 * @throws BizException
	 */
	public abstract BlCgAccountRltDTO refundAccountForOp(BlCgRefundAccountDTO[] refundDtos,BlCgRefundAccountSetDTO accSetDto) throws BizException;
	
	/**
	 * 急诊记账
	 * @param accDtos
	 * @param accSetDto
	 * @return
	 * @throws BizException
	 */
	public abstract BlCgAccountRltDTO keepAccountForEt(BlCgAccountDTO[] accDtos, BlCgAccountSetDTO accSetDto) throws BizException;
	
	/**
	 * 急诊退记账
	 * @param accDtos
	 * @param accSetDto
	 * @return
	 * @throws BizException
	 */
	public abstract BlCgAccountRltDTO refundAccountForEt(BlCgRefundAccountDTO[] accDtos, BlCgRefundAccountSetDTO accSetDto) throws BizException;
	
	/**
	 * 住院记账
	 * @param accDtos 待记账数据
	 * @param accSetDto 记账配置
	 * @return 记账结果
	 * @throws BizException
	 */
	public abstract BlCgAccountRltDTO keepAccountForIp(BlCgAccountDTO[] accDtos,BlCgAccountSetDTO accSetDto) throws BizException;
	
	/**
	 * 住院退记账
	 * @param refundDtos 退记账数据
	 * @param accSetDto 退记账配置
	 * @return 退记账结果
	 * @throws BizException
	 */
	public abstract BlCgAccountRltDTO refundAccountForIp(BlCgRefundAccountDTO[] refundDtos,BlCgRefundAccountSetDTO accSetDto) throws BizException;
	
	/**
	 * 住院记账校验逻辑
	 * 目前用于药品记账前校验
	 * @param accDtos 待记账数据
	 * @param accSetDto 记账配置
	 * @return 校验结果
	 * @throws BizException
	 */
	public abstract BlCgErrorDTO[] checkBeforeKeepAccountForIp(BlCgAccountDTO[] accDtos,BlCgAccountSetDTO accSetDto) throws BizException;
}
