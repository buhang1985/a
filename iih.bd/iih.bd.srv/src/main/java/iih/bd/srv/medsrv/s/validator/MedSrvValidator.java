package iih.bd.srv.medsrv.s.validator;

import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.s.validator.bp.MedSrvValidateBp;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医疗服务校验器
 * 
 * @author hao_wu
 *
 */
public class MedSrvValidator implements Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6845780060029471471L;

	@Override
	public ValidationFailure validate(Object... arg0) {
		MedSrvValidateBp bp = new MedSrvValidateBp();
		for (Object object : arg0) {
			if (object instanceof MedsrvAggDO) {
				ValidationFailure vFailure = bp.exec((MedsrvAggDO) object);
				if (vFailure != null) {
					return vFailure;
				}
			}
		}
		return null;
	}

}
