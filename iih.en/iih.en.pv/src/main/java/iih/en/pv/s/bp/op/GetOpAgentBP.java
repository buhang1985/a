package iih.en.pv.s.bp.op;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.OpBasic4EditDTO;
import iih.en.pv.pativisit.d.EuEntContTp;
import xap.mw.core.data.BizException;

/**
 * 获取代办人信息
 * 
 * @author zhengcm
 *
 */
public class GetOpAgentBP {
	/**
	 * 获取代办人信息
	 * 
	 * @param entId
	 *            就诊id
	 * @return 门诊基本信息维护DTO
	 * @throws BizException
	 */
	public OpBasic4EditDTO exec(String entId) throws BizException {
		EnValidator.validateParam("就诊ID", entId);
		OpBasic4EditDTO dto = new OpBasic4EditDTO();
		dto.setId_ent(entId);
		new OpBasicInfoBP().setContactInfo(dto, EuEntContTp.AGENT.intValue());
		return dto;
	}
}
