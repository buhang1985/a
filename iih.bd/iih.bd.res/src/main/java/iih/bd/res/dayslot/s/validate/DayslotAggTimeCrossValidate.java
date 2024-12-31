package iih.bd.res.dayslot.s.validate;

import iih.bd.res.dayslot.s.bp.DayslotAggTimeCrossValidateBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 日期分组Agg时间交叉校验
 * 
 * @author hao_wu
 *
 */
public class DayslotAggTimeCrossValidate implements Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6560221410492825932L;

	@Override
	public ValidationFailure validate(Object... aobj) {
		DayslotAggTimeCrossValidateBp bp = new DayslotAggTimeCrossValidateBp();
		ValidationFailure vFailure;
		try {
			vFailure = bp.exec(aobj);
			if (vFailure != null) {
				return vFailure;
			}
		} catch (BizException e) {
			e.printStackTrace();
		}

		return null;
	}

}
