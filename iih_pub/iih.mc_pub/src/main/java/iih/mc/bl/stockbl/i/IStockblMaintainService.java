package iih.mc.bl.stockbl.i;

import iih.mc.mc.stockperinit.d.StockperinitAggDO;
import iih.mc.pl.deprequestap.d.DeprequestapAggDO;
import iih.mc.pl.deprequestap.d.McDepReqApOrderDO;
import iih.mc.st.stockin.d.StockinAggDO;
import iih.mc.st.stockout.d.StockoutAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * @author Administrator
 *
 */
public interface IStockblMaintainService {
	
	public static long Lock_time = 1000 * 60* 30;
	
	/**
	 * 期初月结生成结存数据
	 * @param perInitDO 期初月结数据
	 * @throws BizException
	 */
	public void dealStockperInit(StockperinitAggDO perInitAggDO) throws BizException;
	
	/**
	 * 取消期初月结删除结存数据
	 * @param perInitDO 期初月结数据
	 * @throws BizException
	 */
	public void cancelStockperInit(StockperinitAggDO perInitAggDO) throws BizException;
	
	/**
	 * 入库更新结存数据
	 * @param stockinAggDOS 入库单
	 * @throws BizException
	 */
	public void caculateStockIn(StockinAggDO[] stockinAggDOS) throws BizException;
	
	/**
	 * 出库更新结存数据
	 * @param stockoutAggDOS 出库单
	 * @throws BizException
	 */
	public void caculateStockOut(StockoutAggDO[] stockoutAggDOS) throws BizException;
	/**
	 * 耗材领用申请单提交完后对结存占用进行处理
	 * 
	 * @param mcDepReqApOrderDOs
	 * @param submitag
	 *            是否提交标识， true时为提交，false时为取消提交
	 * @throws BizException
	 */
	public void updateBlReserveForDepReqApOrderDO(McDepReqApOrderDO[] mcDepReqApOrderDOs, FBoolean submitag) throws BizException;
	/**
	 * 耗材领用申请单提交完后对结存占用进行处理
	 * 
	 * @param deprequestapAggDO
	 * @param submitag
	 *            是否提交标识， true时为提交，false时为取消提交
	 * @throws BizException
	 */
	public void updateBlReserveForDeprequestapAggDO(DeprequestapAggDO deprequestapAggDO, FBoolean submitag) throws BizException;
}
