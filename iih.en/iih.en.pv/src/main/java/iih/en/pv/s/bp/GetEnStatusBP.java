package iih.en.pv.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;

/**
 * 获取就诊状态
 * 
 * @author yank
 *
 */
public class GetEnStatusBP {
	/**
	 * 获取就诊状态
	 * 
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException
	 */
	public String exec(String entId) throws BizException {
		EnValidator.validateParam("就诊ID", entId);
		PatiVisitDO pvDO = new PvEP().getPvById(entId);
		if (pvDO == null) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_EXIST);
		}
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(pvDO.getCode_entp())
			|| IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(pvDO.getCode_entp())) {			
			OutpatientDO opDO = new OpEP().getOpByEntId(entId);// 如果是门急诊
			return opDO.getSd_status();
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(pvDO.getCode_entp())) {
			// 如果是住院
			InpatientDO ipDO = new IpEP().getIpByEntId(entId);
			return ipDO.getSd_status();
		} else {
			throw new BizException(IEnMsgConst.ERROR_ENTP_NOT_ASSIST);
		}
	}
}
