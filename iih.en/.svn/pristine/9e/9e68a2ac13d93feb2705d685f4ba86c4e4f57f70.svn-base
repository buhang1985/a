package iih.en.pv.s.bp.op;

import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 检索操作员当天挂号信息
 * @author Administrator
 *
 */
public class GetRegListByOperBP {
	/**
	 * 检索操作员当天挂号信息
	 * @param operId
	 * @return
	 * @throws BizException
	 */
	public RegInfoDTO[] exec(String operId) throws BizException{	
		GetRegInfoListBP qryBP = new GetRegInfoListBP();
		return qryBP.exec(operId,null,null,FBoolean.FALSE);
	}	
}
