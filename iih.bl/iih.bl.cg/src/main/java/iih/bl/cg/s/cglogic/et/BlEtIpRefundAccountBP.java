package iih.bl.cg.s.cglogic.et;

import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import xap.mw.core.data.BizException;

/**
 * 急诊退记账(住院表)
 * @author ly 2019/03/14
 *
 */
public class BlEtIpRefundAccountBP {

	/**
	 * 退记账
	 * @param accDtos
	 * @param accSetDto
	 * @return
	 * @throws BizException
	 */
	public BlCgAccountRltDTO exec(BlCgRefundAccountDTO[] accDtos, BlCgRefundAccountSetDTO accSetDto) throws BizException{
		
		throw new BizException("暂不支持急诊记账到住院表中");
	}
}
