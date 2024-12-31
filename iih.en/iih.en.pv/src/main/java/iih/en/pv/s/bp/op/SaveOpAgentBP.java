package iih.en.pv.s.bp.op;

import iih.en.pv.outpatient.dto.d.OpBasic4EditDTO;
import iih.en.pv.pativisit.d.EuEntContTp;
import xap.mw.core.data.BizException;

/**
 * 保存代办人信息
 * 
 * @author Administrator
 *
 */
public class SaveOpAgentBP {
	/**
	 * 保存代办人信息
	 * 
	 * @author zhengcm
	 * @param opBasicDTO
	 *            门诊基本信息维护DTO
	 * @throws BizException
	 */
	public void exec(OpBasic4EditDTO opBasicDTO) throws BizException {
		// 保存就诊联系人（代办人）
		new OpBasicInfoBP().saveEntContInfo(opBasicDTO, EuEntContTp.AGENT.intValue());
	}

}
