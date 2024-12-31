package iih.mi.device.serializedata.ruralcooperinsure;

import java.util.List;

import xap.mw.core.data.BizException;
import iih.mi.device.insurances.ruralcooperinsure.InsureServiceContext;
import iih.valueobject.country.ruralcooperinsure.dto.d.CommonMsgHeaderDTO;

public abstract class AbstractTransactProc {
	/**
	 * 交易是否成功标志
	 */
	protected boolean isSuccess;

	/**
	 * 错误信息
	 */
	protected String errMsg;
	/**
	 * 警告信息
	 */
	protected String warnMsg;
	/**
	 * 医保交易返回信息
	 */
	protected Object outputData;
	/**
	 * 交易参数个数，做校验用
	 */
	protected int paramCount;
	/**
	 * 解析返回结果xml的消息头
	 */
	protected CommonMsgHeaderDTO msgHeaderDto;
	/**
	 * 服务上下文
	 */
	protected InsureServiceContext serviceContext;
	/**
	 * 对应的平台接口函数名称
	 */
	protected String methodName;

	/**
	 * 入参的定义
	 * 
	 * @return
	 * @throws BizException 
	 */
	public abstract List<Object> convertTOInputDataParam() throws BizException;

	/**
	 * 转化为医保接口输出参数
	 * 
	 * @param strOutput
	 * @return
	 * @throws BizException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public abstract Object convertToOutputDataParam(String strOutput) throws BizException, InstantiationException, IllegalAccessException;

	/**
	 * 业务异常处理
	 */
	public static void exceptionHandle(){
		return ;
	}

	/**
	 * 日志记录
	 */
	public static void log(String strMsg){
		
	}
	public boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getWarnMsg() {
		return warnMsg;
	}

	public void setWarnMsg(String warnMsg) {
		this.warnMsg = warnMsg;
	}

	public Object getOutputData() {
		return outputData;
	}

	public void setOutputData(Object outputData) {
		this.outputData = outputData;
	}

	public int getParamCount() {
		return paramCount;
	}

	public void setParamCount(int paramCount) {
		this.paramCount = paramCount;
	}

	public CommonMsgHeaderDTO getMsgHeaderDto() {
		return msgHeaderDto;
	}

	public void setMsgHeaderDto(CommonMsgHeaderDTO msgHeaderDto) {
		this.msgHeaderDto = msgHeaderDto;
	}

	public InsureServiceContext getServiceContext() {
		return serviceContext;
	}

	public void setServiceContext(InsureServiceContext serviceContext) {
		this.serviceContext = serviceContext;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
}
