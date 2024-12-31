package iih.en.ip.s.bp.ip;

import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EnAccEP;
import iih.en.comm.ep.IpEP;
import iih.en.ip.dto.d.EnHosRegInfoDTO;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.inpatient.d.InpatientDO;
import xap.mw.core.data.BizException;

/**
 * 取消登记前校验数据
 * @author tang.ht
 *
 */
public class ValidateCanRegInfoBP2 {

	/**
	 * 取消登记前校验数据
	 * @param enHosRegDTO
	 * @param inpatientDO
	 * @throws BizException
	 */
	public void exec(EnHosRegInfoDTO enHosRegInfoDTO,InpatientDO inpatientDO) throws BizException{
		//1.校验住院数据
		IpEP ipep = new IpEP();
		ipep.validateInpatientDO(inpatientDO);
		//2.校验预交金
		this.validateAmt(enHosRegInfoDTO.getId_ent());
	}
	
	/**
	 * 校验是否有预交金
	 * 
	 * @param entID
	 * @throws BizException
	 */
	private void validateAmt(String entId) throws BizException {
		EnAccEP enAccEP = new EnAccEP();
		EnAccountDO enaccDO  = enAccEP.getAccByEntId(entId);
		if(enaccDO != null&&enaccDO.getAmt_prepay() != null && enaccDO.getAmt_prepay().doubleValue() != 0) {
				throw new BizException(IEnMsgConst.ERROR_ENHOSREG_HAS_PREAMT);
			}
		
	}
}
