package iih.mc.mc.monthaccflag.i;

import iih.mc.mc.monthaccflag.d.McMonthAccFlagDO;
import iih.mc.mc.stockperinit.d.McStockPerInitDO;
import xap.mw.core.data.BizException;

public interface IMonthAccFlagMaintainService {
	
	/**
	 * 月结账
	 * @param accFlagDOS 仓库月结标志数据
	 * @throws BizException
	 */
	public void dealMonthAccount(McMonthAccFlagDO[] accFlagDOS) throws BizException;
	
	/**
	 * 取消月结账
     * @param accFlagDOS 仓库月结标志数据
	 * @throws BizException
	 */
	public void cancelMonthAccount(McMonthAccFlagDO[] accFlagDOS) throws BizException;
	
	/**
	 * 期初月结生成月结标志表数据
	 * @param perInitDO 期初月结数据
	 * @throws BizException
	 */
	public void dealStockperInit(McStockPerInitDO perInitDO) throws BizException;
	
	/**
	 * 取消期初月结删除月结标志表数据
	 * @param perInitDO 期初月结数据
	 * @throws BizException
	 */
	public void cancelStockperInit(McStockPerInitDO perInitDO) throws BizException;
}
