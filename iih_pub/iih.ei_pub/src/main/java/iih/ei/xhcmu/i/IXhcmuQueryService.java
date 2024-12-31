package iih.ei.xhcmu.i;

import xap.mw.core.data.BizException;

public interface IXhcmuQueryService {

	/**
	 * 获取患者姓名
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract String getName(String firstName) throws BizException;
}
