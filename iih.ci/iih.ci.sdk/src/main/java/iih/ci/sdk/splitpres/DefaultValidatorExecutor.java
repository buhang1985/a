package iih.ci.sdk.splitpres;

import iih.ci.ord.cfg.dto.msg.d.RuleMsgDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;

/**
 * 
 * @author HUMS
 *
 */
public class DefaultValidatorExecutor<T> extends AbstractRuleValidator<T> {

	@Override
	public void setDefaultVal(T t) {

	}

	@Override
	public boolean validate(CiEnContextDTO ctx, T t) {

		return true;
	}

	@Override
	public RuleMsgDTO getValidateMsg() {
		return null;
	}

	@Override
	public T executeRule(T t) {

		return t;
	}

	@Override
	protected boolean isExecuteNext() {
		
		return true;
	}

}
