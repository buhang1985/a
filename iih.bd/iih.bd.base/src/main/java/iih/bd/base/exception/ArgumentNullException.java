package iih.bd.base.exception;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 参数为空异常
 * @author yankan
 *
 */
public class ArgumentNullException extends BizException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3435995867184499464L;
	
	private String methodName;
	private String paramName;
	
	public ArgumentNullException(String paramName){
		this.paramName = paramName;
	}
	/**
	 * 构造函数
	 * @param methodName
	 * @param paramName
	 */
	public ArgumentNullException(String methodName,String paramName){
		this.methodName = methodName;
		this.paramName = paramName;
	}
	/**
	 * 异常消息
	 */
	@Override
	public String getMessage(){
		if(!StringUtil.isEmpty(this.methodName)){
			return String.format("方法：%s的参数：%s为空", this.methodName,this.paramName);
		}else{
			return String.format("参数：%s为空", this.paramName);
		}		
	}
}
