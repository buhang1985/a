package iih.bd.srv.mrelement.s.validator.bp;

import iih.bd.srv.mrelement.d.BdmrdeAggDO;
import iih.bd.srv.mrelement.d.MrElementDO;
import xap.sys.appfw.bizrule.validation.ValidationFailure;

/**
 * 病历元素校验器业务逻辑
 * @author guoyang
 *
 */
public class BdmrdeValidatorBp {

	public ValidationFailure exec(BdmrdeAggDO object) {
		if(object == null){
			return null;
		}
		ValidationFailure vfFailure = checkMaxAndMin(object);
		if(vfFailure != null){
			return vfFailure;
		}
		return null;
	}
	/**
	 * 最值得校验
	 * @param object
	 * @return
	 */
	private ValidationFailure checkMaxAndMin(BdmrdeAggDO object) {
		MrElementDO mrElementDO = object.getParentDO();
		BdmrdeMDOCValidatorBp bp = new BdmrdeMDOCValidatorBp();
		ValidationFailure vfFailure = bp.exe(mrElementDO);
		if(vfFailure != null){
			return vfFailure;
		}
		return null;
	}

}
