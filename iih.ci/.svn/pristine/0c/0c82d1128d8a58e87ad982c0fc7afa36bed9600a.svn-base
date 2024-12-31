package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class StrRoundmdNullException extends BizException {
	private static final long serialVersionUID = 1L;
	
	private String defaultMsg ="取整模式为空异常！请在关联服务策略配置节点维护！";

    public StrRoundmdNullException(String s) {
    	super(s);
    	defaultMsg=s+"取整模式为空异常！请在关联服务策略配置节点维护！";
    }
	
	public StrRoundmdNullException(Throwable t)
	{
		super(t);
	}
	
	public StrRoundmdNullException(String msg,Throwable t)
	{
		super(msg,t);
	}
	
	@Override
	public String getMessage() {
		String msg = super.getMessage();
		if(StringUtils.isBlank(msg))
			msg = defaultMsg;
		
		return msg;		
	}
}
