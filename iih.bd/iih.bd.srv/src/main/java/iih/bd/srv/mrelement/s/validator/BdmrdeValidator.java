package iih.bd.srv.mrelement.s.validator;

import iih.bd.srv.mrelement.d.BdmrdeAggDO;
import iih.bd.srv.mrelement.s.validator.bp.BdmrdeValidatorBp;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 病历元素校验器
 * @author guoyang
 *
 */
public class BdmrdeValidator implements Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5038620267198881042L;

	@Override
	public ValidationFailure validate(Object... arg0) {
		BdmrdeValidatorBp bp = new BdmrdeValidatorBp();
		for (Object object : arg0) {
			if(object instanceof BdmrdeAggDO){
				ValidationFailure vFailure = bp.exec((BdmrdeAggDO) object);
				if (vFailure != null) {
					return vFailure;
				}
			}
		}
		return null;
	}

}
