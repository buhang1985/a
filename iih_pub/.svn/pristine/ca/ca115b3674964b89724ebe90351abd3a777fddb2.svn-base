package iih.mc.st.stockcheck.i;

import iih.mc.st.stockcheck.d.McStockCheckDO;
import iih.mc.st.stockcheck.d.StockcheckAggDO;
import xap.mw.core.data.BizException;

public interface IStockcheckExamFlowService {
	
	/**
	 * 盘点单提交
	 * @param stockCheckDOS 盘点单
	 * @throws BizException
	 */
	public void submit(McStockCheckDO[] stockCheckDOS) throws BizException;
	
	/**
	 * 盘点单取消提交
	 * @param stockCheckDOS 盘点单
	 * @throws BizException
	 */
	public void cancelSubmit(McStockCheckDO[] stockCheckDOS) throws BizException;
	
	/**
	 * 盘点单审核通过
	 * @param stockCheckDOS 盘点单
	 * @throws BizException
	 */
	public StockcheckAggDO accept(StockcheckAggDO checkAggDO) throws BizException;
	
	/**
	 * 盘点单审核驳回
	 * @param stockCheckDOS 盘点单
	 * @throws BizException
	 */
	public StockcheckAggDO reject(StockcheckAggDO checkAggDO) throws BizException;
}
