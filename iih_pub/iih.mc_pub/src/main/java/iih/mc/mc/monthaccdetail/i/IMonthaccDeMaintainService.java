package iih.mc.mc.monthaccdetail.i;

import iih.mc.mc.monthaccflag.d.McMonthAccFlagDO;
import xap.mw.core.data.BizException;

public interface IMonthaccDeMaintainService {
	
	/**
	 * 月结账
	 * @param mcstIds 仓库月结标志对象ID
	 * @return 仓库月结标志对象列表
	 * @throws BizException
	 */
	public void dealMonthAccount(McMonthAccFlagDO[] accFlagDOS) throws BizException;
	
	/**
	 * 取消月结账
	 * @param mcstIds 仓库月结标志对象ID
	 * @return 仓库月结标志对象列表
	 * @throws BizException
	 */
	public void cancelMonthAccount(McMonthAccFlagDO[] accFlagDOS) throws BizException;
}
