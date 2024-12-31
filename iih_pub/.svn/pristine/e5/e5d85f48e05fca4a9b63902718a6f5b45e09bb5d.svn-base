package iih.mc.pl.trrequestap.i;

import iih.mc.pl.trrequestap.d.McTrReqApItemDO;
import iih.mc.pl.trrequestap.d.McTrReqApOrderDO;
import iih.mc.pl.trrequestap.d.TrrequestapAggDO;
import xap.mw.core.data.BizException;

public interface ITrreqapMaintainService {
	
	/**
	 * 初始化调拨申请单
	 * @param 
	 * @throws BizException
	 */
	public TrrequestapAggDO initAggDo() throws BizException;
	
	/**
	 * 填充调拨申请明细信息
	 * @param purOrderDO 调拨申请单
	 * @param purOrderItemDO 调拨申请单明细
	 * @throws BizException
	 */
	public McTrReqApItemDO initDepreqItemInfo(McTrReqApOrderDO trReqOrderDO, McTrReqApItemDO trReqItemDO) throws BizException;
	
	/**
	 * 领用申请单提交
	 * @param depReqOrderDOS 领用申请单
	 * @throws BizException
	 */
	public void submitMainDO(McTrReqApOrderDO[] trReqOrderDOS) throws BizException;
	
	/**
	 * 领用申请单取消提交
	 * @param depReqOrderDOS 领用申请单
	 * @throws BizException
	 */
	public void cancelSubmitMainDO(McTrReqApOrderDO[] trReqOrderDOS) throws BizException;
	
	/**
	 * 领用申请单提交
	 * @param depReqAggDO 领用申请单
	 * @throws BizException
	 */
	public TrrequestapAggDO submitAggDO(TrrequestapAggDO trReqAggDO) throws BizException;
	
	/**
	 * 领用申请单取消提交
	 * @param depReqAggDO 领用申请单
	 * @throws BizException
	 */
	public TrrequestapAggDO cancelSubmitAggDO(TrrequestapAggDO trReqAggDO) throws BizException;
	
	/**
	 * 根据id数组更新申请单状态
	 * @param ids
	 * @param status
	 * @throws BizException
	 */
	public void updateTrrequestStatusByIds(String[] ids, String status) throws BizException;
}
