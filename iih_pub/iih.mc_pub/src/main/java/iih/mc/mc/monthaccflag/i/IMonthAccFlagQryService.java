package iih.mc.mc.monthaccflag.i;

import iih.mc.mc.monthaccflag.d.McMonthAccFlagDO;
import xap.mw.core.data.BizException;

public interface IMonthAccFlagQryService {
	
	/**
	 * 获取仓库指定财务月的仓库月结信息。
	 * @param whId 仓库ID
	 * @param yearMonth 财务月
	 * @return 仓库月结信息
	 * @throws BizException
	 */
	public McMonthAccFlagDO getMonthAccFlag(String whId, String yearMonth) throws BizException;
}
