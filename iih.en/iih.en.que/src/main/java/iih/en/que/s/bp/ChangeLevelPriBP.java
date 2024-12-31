package iih.en.que.s.bp;

import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.TriageEntDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

public class ChangeLevelPriBP {
	/**
	 * 改变优先级
	 * @param entDTO
	 * @throws BizException
	 */
	public void exec(TriageEntDTO entDTO) throws BizException {
		EnValidator.validateParam("TriageEntDTO", entDTO);
		EnQueEP eqBp = new EnQueEP();
		EnQueueDO enQueue = eqBp.getEnQueueById(entDTO.getId_entque());
		if (enQueue != null) {
			enQueue.setStatus(DOStatus.UPDATED);
			enQueue.setLevel_pri(Integer.valueOf(entDTO.getLevel_pri()));
			enQueue.setLevel_pri_rsn(entDTO.getLevel_pri_rsn());
			eqBp.save(new EnQueueDO[] { enQueue });
		}else{
			throw new BizException(IEnMsgConst.ERROR_CHANGLEVEL_WRONG);
		}
	}
}
