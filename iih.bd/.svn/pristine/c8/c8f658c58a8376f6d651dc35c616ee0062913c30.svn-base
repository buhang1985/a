package iih.bd.srv.mrcompleterule.s.validate;

import iih.bd.srv.mrcompleterule.d.MrCompleteRuleDO;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 病历完成书写规则数据校验
 * 
 * @author hao_wu
 *
 */
public class MrcompleteruleValidate implements Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3116662138239819878L;

	@Override
	public ValidationFailure validate(Object... arg0) {
		MrCompleteRuleDO mrCompleteRuleDO;
		for (Object object : arg0) {
			if (object instanceof MrCompleteRuleDO) {
				mrCompleteRuleDO = (MrCompleteRuleDO) object;
				if (mrCompleteRuleDO != null && mrCompleteRuleDO.getFg_change() != null
						&& mrCompleteRuleDO.getFg_change().booleanValue()
						&& mrCompleteRuleDO.getId_change_mrtps() == null) {
					return new ValidationFailure(
							"医疗记录类型：" + mrCompleteRuleDO.getMrtp_name() + "在替换的情况下，可替代医疗记录类型不可为空！");
				}
			}
		}
		return null;
	}

}
