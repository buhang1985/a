package iih.bd.pp.hpdivshisdto.i;

import iih.bd.pp.hpdivshisdto.d.HpDiVsHisDTO;
import xap.mw.core.data.BizException;

public interface IHpdivshisdtoExtService {
	/**
	 * 补全状态信息
	 * @param codearr
	 * @return
	 * @throws BizException
	 */
	public HpDiVsHisDTO[] completionStatus(HpDiVsHisDTO[] hpDiVsHisDTOs) throws BizException;
}
