package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.TransDepPatDTO;
import xap.mw.core.data.BizException;

/**
 * 获取转科转入病人总数
 * @author renying
 *
 */
public class GetTransInCountBP {
	/**
	 * 获取转科转入病人总数
	 * @param nurId 病区id
	 * @return
	 * @throws BizException
	 */
	public Integer exec(String nurId) throws BizException{
		GetTransInDepBP getTransInDep = new GetTransInDepBP();	
		TransDepPatDTO[] transDTOs =  getTransInDep.exec(nurId);
		if(EnValidator.isEmpty(transDTOs)){
			return 0 ;
		}
		return transDTOs.length;
	}
}
