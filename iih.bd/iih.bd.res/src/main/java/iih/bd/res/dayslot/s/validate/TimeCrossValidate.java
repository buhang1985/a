package iih.bd.res.dayslot.s.validate;

import iih.bd.res.dayslot.s.bp.TimeCrossValidateBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 日期分组时间交叉校验
 * 
 * @author hao_wu
 *
 */
public class TimeCrossValidate implements Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3999659066482873130L;

	@Override
	public ValidationFailure validate(Object... arg0) {
		TimeCrossValidateBp bp = new TimeCrossValidateBp();
		ValidationFailure vFailure;
		try {
			vFailure = bp.exec(arg0);
			if (vFailure != null) {
				return vFailure;
			}
		} catch (BizException e) {
			e.printStackTrace();
		}
		return null;
	}

}
