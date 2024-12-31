package iih.mm.bl.stockbl.i;

//import iih.mm.bl.balance.d.StockBalanceDO;
import iih.mm.bl.stockbl.d.StockBlDO;
import iih.mm.qy.stockblinfo.d.StockBlQueryView;
import iih.mm.st.stockin.d.StockinAggDO;
import iih.mm.st.stockout.d.StockoutAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 新版本结存服务接口
 * @author wu.junhui
 *
 */
public interface IStockBlCustService {
	/**
	 * 入库结存处理
	 * @param stockinAggDO 入库单
	 */
	public void caculateStockIn(StockinAggDO[] stockinAggDOS) throws BizException;
	
	/**
	 * 出库结存处理
	 * @param stockoutAggDO 出库单
	 * @param isReserveMode 是否是预留模式出库 
	 */
	public void caculateStockOut(StockoutAggDO[] stockoutAggDOS) throws BizException;
	
	/**
	 * 获取物品的结存信息
	 */
	public StockBlDO[] getMaterialBalanceItems(String materialId, String whId) throws BizException;
	
	/**
	 * 获取物品的总现库存量
	 * @param whId 仓库ID
	 * @param materialId 物品ID
	 * @param pkguId 物品包装单位
	 * @return 现库存量
	 * @throws BizException
	 */
	public FDouble getMaterialTotalBalance(String whId, String materialId, String pkguId) throws BizException;
	
	/**
	 * 获取物品的库存参考价格
	 * @param whId 仓库ID
	 * @param materialId 物品ID
	 * @param pkguId 物品包装单位
	 * @return 参考价格
	 * @throws BizException
	 */
	public FDouble getMaterialBalancePrice(String whId, String materialId, String pkguId) throws BizException;
	
	/**
	 * 手动修改结存信息
	 * @return 
	 * @throws BizException
	 */
	public void manualSetStockBlInfo(StockBlQueryView[] blViewDOS) throws BizException;
	
	/**
	 * 手动停用结存信息
	 * @return 
	 * @throws BizException
	 */
	public void manualStopBlInfo(StockBlQueryView[] blViewDOS, FBoolean fg_stop) throws BizException;
}
