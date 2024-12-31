package iih.bd.fc.querule.s.validate.bp;

import java.util.LinkedList;

import iih.bd.fc.querule.d.QueRuleItmDO;
import xap.sys.appfw.bizrule.validation.ValidationFailure;

/**
 * 队列规则明细控制类型校验Bp
 * @author guoyang
 *
 */
public class QueRuleItmValidateBp {
	
	private int enctrtpl;

	public ValidationFailure exec(LinkedList<QueRuleItmDO> queRuleItmDOs) {
		if (queRuleItmDOs == null || queRuleItmDOs.size() <= 0) {
			return null;
		}
		ValidationFailure vFailure = queRuleItmValidate(queRuleItmDOs);
		return vFailure;
		
	}

	/**
	 * 遍历数组获取校验结果
	 * @param queRuleItmDOs
	 * @return
	 */
	private ValidationFailure queRuleItmValidate(LinkedList<QueRuleItmDO> queRuleItmDOs) {
		ValidationFailure validationFailure = null;
		for (int j = 0; j < queRuleItmDOs.size(); j++) {
			boolean result = queRuleItmValidate(j, queRuleItmDOs.get(j));
			if (result) {
				continue;
			}else {
				validationFailure = new ValidationFailure("控制类型必须唯一！");
				return validationFailure; 
			}
		}
		return validationFailure;
	}

	/**
	 * 对队列规则进行比较返回校验结果
	 * @param j
	 * @param queRuleItmDO
	 * @return
	 */
	private boolean queRuleItmValidate(int j, QueRuleItmDO queRuleItmDO) {

		
		if (j == 0) {
			enctrtpl = queRuleItmDO.getEu_ctrltp();
			return true;
		}else {
			
			if(enctrtpl == queRuleItmDO.getEu_ctrltp()){
				return true;
			}else {
				return false;
			}
		}
	}

}
