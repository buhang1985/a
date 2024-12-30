package iih.sc.comm.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

/**
 * 参数为空异常
 * @author yank
 *
 */
public class ArgumentNullException extends BizException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3435995867184499464L;
	
	private String methodName;
	private String paramName;
	private String paramDesc;
	
	public ArgumentNullException(String paramName){
		this.paramName = paramName;
	}
	/**
	 * 构造函数
	 * @param methodName
	 * @param paramName
	 * @param paramDesc
	 */
	public ArgumentNullException(String methodName,String paramName,String paramDesc){
		this.methodName = methodName;
		this.paramName = paramName;
		this.paramDesc = paramDesc;
	}
	/**
	 * 异常消息
	 */
	@Override
	public String getMessage(){
		if(!StringUtils.isEmpty(this.methodName)){
			return String.format("方法：%s的参数：%s为空", this.methodName,this.paramName);
		}else if(!StringUtils.isEmpty(paramDesc)){
			return String.format("%s：%s为空", this.paramDesc,this.paramName);
		}else{
			return String.format("参数：%s为空", this.paramName);
		}		
	}
}
