package iih.en.comm.ep;

import iih.en.comm.validator.EnValidator;
import iih.en.que.board.d.EnBrdCallDO;
import iih.en.que.board.i.IEbbrdcalldoCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class BrdCallEP {
	/**
	 * 保存EnBrdCallDO
	 * 
	 * @param enBrdCallDOs
	 * @return
	 * @throws BizException
	 */
	public EnBrdCallDO[] save(EnBrdCallDO[] enBrdCallDOs) throws BizException{
		EnValidator.validateParam("enBrdCallDOs", enBrdCallDOs);
		IEbbrdcalldoCudService callCudService = ServiceFinder.find(IEbbrdcalldoCudService.class);
		EnBrdCallDO[] callDOs = callCudService.save(enBrdCallDOs);
		return callDOs;
	}

}
