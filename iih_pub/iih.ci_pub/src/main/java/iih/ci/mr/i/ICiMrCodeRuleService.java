package iih.ci.mr.i;

import xap.mw.core.data.BizException;

public interface ICiMrCodeRuleService {

	/**
	 * 根据DO的全路径名获取编码
	 * @param fullName
	 * @return
	 * @throws BizException
	 */
	public abstract String getCodeByFullName(String fullName) throws BizException;
	
}
