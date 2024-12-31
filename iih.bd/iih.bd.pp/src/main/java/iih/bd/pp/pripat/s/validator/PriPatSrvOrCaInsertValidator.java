package iih.bd.pp.pripat.s.validator;

import iih.bd.pp.pripat.s.validator.bp.PriPatSrvOrCaInsertValidatorBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者价格分类服务
 * PriPatSrvOrCaDO插入时校验
 * @author guoyang
 *
 */
public class PriPatSrvOrCaInsertValidator implements Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ValidationFailure validate(Object... arg0) {
		PriPatSrvOrCaInsertValidatorBp bp = new PriPatSrvOrCaInsertValidatorBp();
		try {
			return bp.exec(arg0);
		} catch (BizException e) {
			e.printStackTrace();
		}
		return null;
	}

}
