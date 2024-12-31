package iih.mm.pl.departrequest.i;

import iih.mm.pl.departrequest.d.DepartReqItemDO;
import iih.mm.pl.departrequest.d.DepartReqOrderDO;
import iih.mm.pl.departrequest.d.DepartrequestAggDO;
import iih.mm.st.stockout.d.StockoutAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public interface IDepartrequestService {
	
	/**
	 * 根据物品ID生成申请单明细
	 * @param materialIDList 物品ID列表
	 * @param whouseID 仓库
	 */
	public DepartReqItemDO[] initDepReqItemList(String[] materialIDList, String whouseID) throws BizException;
	
	/**
	 * 初始化调拨申请明细
	 * @param depReqItem 调拨申请明细
	 * @param whouseID 仓库
	 */
	public DepartReqItemDO initDepReqItemInfo(DepartReqItemDO depReqItem, String whouseID) throws BizException;
	
	/**
	 * 自动生成科室基数药请领明细.
	 * @param depReqOrderDO 领用申请主信息
	 * @return 领用申请明细
	 * @throws BizException
	 */
	public DepartReqItemDO[] autoInitDepReqItem(DepartReqOrderDO depReqOrderDO) throws BizException;
	
	/**
	 * 提交申请单.
	 * @param ids 领用申请单ID
	 * @return 领用申请单
	 * @throws BizException
	 */
	public DepartrequestAggDO[] submit(String[] ids) throws BizException;
	
	/**
	 * 取消提交申请单.
	 * @param ids 领用申请单ID
	 * @return 领用申请单
	 * @throws BizException
	 */
	public DepartrequestAggDO[] cancelSubmit(String[] ids) throws BizException;
	
	/**
	 * 领用申请单删除 .
	 * @param ids 领用申请单ID
	 */
	public void delete(String[] ids) throws BizException;
	
	/**
	 * 根据出库ID和出库关联更新申请单状态
	 * @param outDO 出库单
	 */
	public void updateTrapReqStatus(StockoutAggDO[] outAggDOS, FBoolean fg_delete) throws BizException;
}
