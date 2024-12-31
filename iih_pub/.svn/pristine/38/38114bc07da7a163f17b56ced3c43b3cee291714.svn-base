package iih.mc.po.pruchase.i;

import iih.mc.po.pruchase.d.McPurchaseOrderDO;
import iih.mc.po.pruchase.d.PruchaseAggDO;
import xap.mw.core.data.BizException;

public interface IPruchaseExamFlowService {
	
	/**
	 * 盘点单提交
	 * @param stockCheckDOS 盘点单
	 * @throws BizException
	 */
	public McPurchaseOrderDO[] submit(McPurchaseOrderDO[] purChaseOrderODS) throws BizException;
	
	/**
	 * 盘点单审核通过
	 * @param stockCheckDOS 盘点单
	 * @throws BizException
	 */
	public PruchaseAggDO accept(PruchaseAggDO purChaseAggDO) throws BizException;
	
	/**
	 * 盘点单审核驳回
	 * @param stockCheckDOS 盘点单
	 * @throws BizException
	 */
	public PruchaseAggDO reject(PruchaseAggDO purChaseAggDO) throws BizException;
}
