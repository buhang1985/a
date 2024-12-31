package iih.bd.srv.mrelement.s.validator.bp;

import iih.bd.srv.mrelement.d.MrElementDO;
import xap.sys.appfw.bizrule.validation.ValidationFailure;

/**
 * 病历元素校验器主DO业务逻辑
 * @author guoyang
 *
 */
public class BdmrdeMDOCValidatorBp {

	public ValidationFailure exe(MrElementDO mrElementDO) {
		if(mrElementDO == null){
			return null;
		}
		ValidationFailure vfFailure = checkMaxAndMin(mrElementDO);
		if(vfFailure != null){
			return vfFailure;
		}
		return null;
	}
	/**
	 * 比较病历元素的最大值和最小值，最大长度和最小长度是否符合逻辑
	 * @param mrElementDO
	 * @return
	 */
	private ValidationFailure checkMaxAndMin(MrElementDO mrElementDO) {
		if(mrElementDO != null){
			if(mrElementDO.getLg_max() != null && mrElementDO.getLg_min() != null){
				if(mrElementDO.getLg_max() < mrElementDO.getLg_min()){
					return new ValidationFailure("病历元素的最大长度不能小于最小长度");
				}
			}
			if(mrElementDO.getNu_max() != null && mrElementDO.getNu_min() != null){
			 	int num = mrElementDO.getNu_max().compareTo(mrElementDO.getNu_max());
			 	if(num < 0){
			 		return new ValidationFailure("病历元素的最大值不能小于最小值");
			 	}
			}
		}
		return null;
	}

}
