package iih.ci.sdk.splitpres;

public class DefaultRuleExecutor<T> extends AbstractRuleExecutor<T>{

	@Override
	public void setDefaultVal(T t) {
		
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
