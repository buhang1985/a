package iih.mc.pl.deprequestap.i;

import iih.mc.pl.deprequestap.d.DeprequestapAggDO;
import iih.mc.pl.deprequestap.d.McDepReqApItemDO;
import iih.mc.pl.deprequestap.d.McDepReqApOrderDO;
import iih.mc.st.stockout.d.McStockOutDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public interface IDepreqapMaintainService {
	
	/**
	 * 初始化领用申请单
	 * @param 
	 * @throws BizException
	 */
	public DeprequestapAggDO initAggDo() throws BizException;
	
	/**
	 * 填充领用申请明细信息
	 * @param purOrderDO 领用申请单
	 * @param purOrderItemDO 领用申请单明细
	 * @throws BizException
	 */
	public McDepReqApItemDO initDepreqItemInfo(McDepReqApOrderDO depReqOrderDO, McDepReqApItemDO depReqItemDO) throws BizException;
	
	/**
	 * 领用申请单提交
	 * @param depReqOrderDOS 领用申请单
	 * @throws BizException
	 */
	public void submitMainDO(McDepReqApOrderDO[] depReqOrderDOS) throws BizException;
	
	/**
	 * 领用申请单取消提交
	 * @param depReqOrderDOS 领用申请单
	 * @throws BizException
	 */
	public void cancelSubmitMainDO(McDepReqApOrderDO[] depReqOrderDOS) throws BizException;
	
	/**
	 * 领用申请单提交
	 * @param depReqAggDO 领用申请单
	 * @throws BizException
	 */
	public DeprequestapAggDO submitAggDO(DeprequestapAggDO depReqAggDO) throws BizException;
	
	/**
	 * 领用申请单取消提交
	 * @param depReqAggDO 领用申请单
	 * @throws BizException
	 */
	public DeprequestapAggDO cancelSubmitAggDO(DeprequestapAggDO depReqAggDO) throws BizException;
	
	/**
	 * 通过领用出库单更新领用申请单的状态 fg_delete 为Ture 时为删除单据
	 * @param mcStockOutDo
	 * @param fg_delete
	 * @throws BizException
	 */
	public void updateReqOrderStatusFromStockoutDo(McStockOutDO mcStockOutDos,FBoolean fg_delete,String sd_status)throws BizException;
	/**
	 * 通过领用出库单更新领用申请单的状态 fg_delete 为Ture 时为删除单据
	 * @param mcStockOutDo
	 * @param fg_delete
	 * @throws BizException
	 */
	public void updateReqOrderStatusFromStockoutDos(McStockOutDO[] mcStockOutDos,FBoolean fg_delete,String sd_status)throws BizException;
	/**
	 * 通过申领计划生成领用申请单
	 * @param depReqAggDO 领用申请单
	 * @throws BizException
	 */
	public DeprequestapAggDO InitTransOrderByCiaHvOrder(String[] ids)throws BizException;
}
