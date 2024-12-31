package iih.bl.cg.s.cglogic.et;

import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.params.BlParamValueConst;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;

/**
 * 急诊退记账
 * @author ly 2019/03/14
 *
 */
public class BlEtRefundAccountBP {

	/**
	 * 退记账
	 * @param accDtos
	 * @param accSetDto
	 * @return
	 * @throws BizException
	 */
	public BlCgAccountRltDTO exec(BlCgRefundAccountDTO[] accDtos, BlCgRefundAccountSetDTO accSetDto) throws BizException{
		
		if(BlParamValueConst.BLST0002_OP.equals(BlParams.BLST0002())){
			BlEtOpRefundAccountBP bp = new BlEtOpRefundAccountBP();
			return bp.exec(accDtos, accSetDto);
		}
		
		BlEtIpRefundAccountBP bp = new BlEtIpRefundAccountBP();
		return bp.exec(accDtos, accSetDto);
	}
}
