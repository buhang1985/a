package iih.bd.fc.querule.s.validate;

import java.util.LinkedList;

import iih.bd.fc.querule.d.QueRuleItmDO;
import iih.bd.fc.querule.d.QueruleAggDO;
import iih.bd.fc.querule.s.validate.bp.QueRuleItmValidateBp;
import xap.mw.core.data.BaseDO;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 队列规则数据校验
 * @author guoyang
 *
 */
public class QueruleEuctrltpValidate implements Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6641633890651703732L;

	@Override
	public ValidationFailure validate(Object... arg0) {
		LinkedList<QueRuleItmDO> queRuleItmDOs = getItem(arg0);
		QueRuleItmValidateBp bp = new QueRuleItmValidateBp();
		return bp.exec(queRuleItmDOs);
	}

	/**
     * 获取agg的子DO
     * @param arg0
     * @return
     */
	private LinkedList<QueRuleItmDO> getItem(Object[] arg0) {
		LinkedList<QueRuleItmDO> allItmDOs = new LinkedList<QueRuleItmDO>();
		for (Object object : arg0) {
			if (object instanceof QueruleAggDO) {
				QueruleAggDO queruleAggDO = (QueruleAggDO) object;
				BaseDO[] queRuleItmDOArr = queruleAggDO.getAllChildrenDO();
				LinkedList<QueRuleItmDO> queRuleItmDOs =convertToBdBedArr(queRuleItmDOArr);
				if (queRuleItmDOArr != null && queRuleItmDOArr.length > 0) {
					allItmDOs.addAll(queRuleItmDOs);
				}
			}
			return allItmDOs;
		}
		return null;
	}

	
	private LinkedList<QueRuleItmDO> convertToBdBedArr(BaseDO[] allChildrenDO) {
		LinkedList<QueRuleItmDO> queRuleItmDOs = new LinkedList<QueRuleItmDO>();
		if (allChildrenDO != null && allChildrenDO.length > 0) {
			for (BaseDO baseDO : allChildrenDO) {
				queRuleItmDOs.add((QueRuleItmDO)baseDO);
			}
			return queRuleItmDOs;
		}
		return null;
	}

}
