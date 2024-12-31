package iih.en.pv.s.bp.op;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 患者注册+挂号
 * @author yank
 *
 */
public class RegPatAndOpBP {
	/**
	 * 患者注册+挂号
	 * @param patDTO 患者信息
	 * @param regInfos 挂号信息
	 * @param payInfoDTO 支付信息
	 * @return
	 * @throws BizException
	 */
	public RegInfoDTO[] exec(OpRegPatDTO patDTO,RegInfoDTO[] regInfos,PayInfoDTO payInfoDTO) throws BizException{
		String patId = null;
		if(patDTO != null){
			RegPatBP regBP = new RegPatBP();
			patDTO = regBP.regPat(patDTO, new FBoolean(EnValidator.isEmpty(patDTO.getId_pat())));
			patId = patDTO.getId_pat();
		}
		else{
			patId = regInfos[0].getId_pat();
		}
		
		OpRegMutiBP opRegBP = new OpRegMutiBP();
		return opRegBP.exec(patId, regInfos, payInfoDTO);
	}
}
