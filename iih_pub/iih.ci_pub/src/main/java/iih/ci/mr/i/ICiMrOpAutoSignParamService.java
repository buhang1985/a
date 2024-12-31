package iih.ci.mr.i;

import xap.mw.core.data.BizException;

public interface ICiMrOpAutoSignParamService {

	/**
	 * 门诊自动签名方式
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	public abstract String GetSysParamOpAutoSign(String id_org) throws BizException;
}
