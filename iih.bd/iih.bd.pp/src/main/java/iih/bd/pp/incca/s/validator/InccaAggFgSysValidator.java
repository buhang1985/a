package iih.bd.pp.incca.s.validator;

import iih.bd.pp.incca.d.InccaAggDO;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

public class InccaAggFgSysValidator implements Validator {


	@Override
	public ValidationFailure validate(Object... arg0) {
		// TODO 自动生成的方法存根
		if (arg0 != null && arg0.length == 1) {
			InccaAggDO aggdo = (InccaAggDO) arg0[0];
			if (aggdo.getParentDO().getFg_active().booleanValue()) {
				return new ValidationFailure("您所选的数据已被标记系统标识，不能被删除！");
			}
		}
		return null;
	}
}
