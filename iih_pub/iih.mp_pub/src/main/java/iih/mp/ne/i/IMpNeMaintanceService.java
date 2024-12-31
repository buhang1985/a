package iih.mp.ne.i;

import iih.mp.ne.dto.sampsrvdto.d.LabSampDTO;
import xap.mw.core.data.BizException;

public interface IMpNeMaintanceService {

	/**
	 * 标本费用重新核算
	 * 
	 * @param params
	 * @throws BizException
	 */
	public abstract void sampSrvReCal(LabSampDTO[] params) throws BizException;
}
