package iih.bd.fc.querule.s.bp;

import iih.bd.fc.pub.IBdFcConst;
import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.d.QueruleAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;

/**
 * 批量计算优先级
 * @author yank
 *
 */
public class BatchCalcPriorityBP {
	/**
	 * 计算优先级
	 * @param ruleAggDO 规则Agg
	 * @param priDTOs 优先级DTO
	 * @return 计算完成在DTO中Level_pri获取
	 * @throws BizException
	 */
	public PriorityDTO[] exec(QueruleAggDO ruleAggDO, PriorityDTO[] priDTOs) throws BizException {
		if (ArrayUtil.isEmpty(priDTOs)) {
			return null;
		}
		CalcPriBP calcBP = new CalcPriBP();
		int levelPri = IBdFcConst.DEFAULT_PRIORITY_LEVEL;
		for (PriorityDTO priDTO : priDTOs) {
			levelPri = calcBP.exec(ruleAggDO, priDTO);
			priDTO.setLevel_pri(levelPri);
		}
		return priDTOs;
	}
}
