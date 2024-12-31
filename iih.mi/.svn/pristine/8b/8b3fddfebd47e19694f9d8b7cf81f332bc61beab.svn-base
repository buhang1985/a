package iih.mi.mc.s.ctrlcore.mimcwholecheck.rule;

import iih.mi.mc.dto.mimcwholerule.d.MiMcWholeRuleInParamDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcWholeRuleOutParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 单次执行医嘱领量限制校验规则(先空着，需要的时候再写)
 * @author LIM
 * @since 2019-09-23
 *
 */
public class MiCheckPickByOnePerformRule {
	/**
	 * 单次执行医嘱领量限制
	 * @param inParamDto
	 * @return
	 * @throws BizException
	 */
	public MiMcWholeRuleOutParamDTO exec(MiMcWholeRuleInParamDTO inParamDto)throws BizException{
		MiMcWholeRuleOutParamDTO outParamDto= new MiMcWholeRuleOutParamDTO();
		outParamDto.setFg_checkflag(FBoolean.TRUE);//默认通过校验	
		
		return outParamDto;
	}
}
