package iih.ci.sdk.splitpres;

import java.util.HashMap;

/**
 * 规则执行器抽象实现<br>
 * 用于构造链，设置默认配置值
 * 
 * @author HUMS
 *
 * @param <T>
 */
public abstract class AbstractRuleExecutor<T> extends AbstractExecutorChain<T> {

	/**
	 * 下一个规则
	 *//*
	private AbstractRuleExecutor<T> nextExecutor;

	*//**
	 * 配置结果的json数据
	 *//*
	protected JSONObject cfgJsonResult = null;

	public Map<String, Object> request;
	public Map<String, Object> response;*/

	/**
	 * 开始执行规则
	 * 
	 * @param <T>
	 * @param presList
	 * @return
	 */
	public T startExecuteRule(T t) {

		if(t == null){
			return t;
		}
		
		if (this.request == null) {
			this.request = new HashMap<String, Object>();

		}

		if (this.response == null) {
			this.response = new HashMap<String, Object>();
		}

		// 执行当前规则处理方法t
		T result = this.executeRule(t);

		// 如果存在下一个规则，执行下一个规则
		if (nextExecutor != null) {

			nextExecutor.request = this.request;
			nextExecutor.response = this.response;

			result = ((AbstractRuleExecutor<T>)nextExecutor).startExecuteRule(result);
		}

		return result;
	}

	/**
	 * 是否执行下一个
	 * 
	 * @return true 执行下一个， false 不执行
	 *//*
	protected abstract boolean isExecuteNext();

	public void setNextExecutor(AbstractRuleExecutor<T> nextExecutor) {
		this.nextExecutor = nextExecutor;
	}

	*//**
	 * 设置默认json数据
	 * 
	 * @param defaultJsonVal 配置的默认值
	 *//*
	protected void setDefaultJsonVal(String defaultJsonVal) {

		if (StringUtils.isNotEmpty(defaultJsonVal)) {
			try {
				cfgJsonResult = (JSONObject) JSONObject.parse(defaultJsonVal);
			} catch (Exception e) {
				throw new BizRuntimeException("设置规则执行器默认值失败", e);
			}
		} else {
			cfgJsonResult = new JSONObject();
		}
	}*/
}
