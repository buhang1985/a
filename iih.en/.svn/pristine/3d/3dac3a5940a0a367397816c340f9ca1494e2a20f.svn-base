package iih.en.pv.s.bp.ip;

import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.IpEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.i.IEnaccountMDORService;
import iih.en.pv.inpatient.d.InpatientDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 取消登记前校验数据
 * @author renying
 *
 */
public class ValidateCanRegInfoBP {

	/**
	 * 取消登记前校验数据
	 * @param enHosRegDTO
	 * @param inpatientDO
	 * @throws BizException
	 */
	public void exec(EnHosRegDTO enHosRegDTO,InpatientDO inpatientDO) throws BizException{
		//1.校验住院数据
		IpEP ipep = new IpEP();
		ipep.validateInpatientDO(inpatientDO);
		//2.校验预交金
		this.validateAmt(enHosRegDTO.getId_ent());
	}
	
	/**
	 * 校验是否有预交金
	 * 
	 * @param entID
	 * @throws BizException
	 */
	private void validateAmt(String entID) throws BizException {
		IEnaccountMDORService enaccRService = ServiceFinder.find(IEnaccountMDORService.class);
		EnAccountDO[] enAccountDOArray = enaccRService.findByAttrValString(EnAccountDO.ID_ENT, entID);
		if (!EnValidator.isEmpty(enAccountDOArray)) {
			EnAccountDO enaccDO = enAccountDOArray[0];
			if (enaccDO.getAmt_prepay() != null && enaccDO.getAmt_prepay().doubleValue() != 0) {
				throw new BizException(IEnMsgConst.ERROR_ENHOSREG_HAS_PREAMT);
			}
		}
	}
}
