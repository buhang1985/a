package iih.bd.fc.bdwfdepctr.s.validator;

import iih.bd.fc.bdwfdepctr.s.validator.bp.WfDepCtrValidatorBp;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 流程配置_医嘱流向_整体控制校验
 * @author guoyang
 *
 */
public class WfDepCtrValidator implements Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ValidationFailure validate(Object... arg0) {
		WfDepCtrValidatorBp bp = new WfDepCtrValidatorBp();
		return bp.exec(arg0);
	}

}
