package iih.bl.cg.s.cglogic.et;

import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.params.BlParamValueConst;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;

/**
 * 急诊退记账
 * @author ly 2019/03/14
 *
 */
public class BlEtKeepAccountBP {

	/**
	 * 记账
	 * @param accDtos
	 * @param accSetDto
	 * @return
	 * @throws BizException
	 */
	public BlCgAccountRltDTO exec(BlCgAccountDTO[] accDtos, BlCgAccountSetDTO accSetDto) throws BizException{
		
		if(BlParamValueConst.BLST0002_OP.equals(BlParams.BLST0002())){
			BlEtOpKeepAccountBP bp = new BlEtOpKeepAccountBP();
			return bp.exec(accDtos, accSetDto);
		}
		
		BlEtIpKeepAccountBP bp = new BlEtIpKeepAccountBP();
		return bp.exec(accDtos, accSetDto);
	}
}
