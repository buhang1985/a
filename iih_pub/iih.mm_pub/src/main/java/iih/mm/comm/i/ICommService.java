package iih.mm.comm.i;

import iih.mm.pl.trapimpl.d.TrapImplDO;
import iih.mm.st.stockcheck.d.StockCheckDO;
import iih.mm.st.stockinvoice.d.StockInvoiceDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.bdfw.bbd.d.PsndocAggDO;

public interface ICommService {
	/**
	 * 获取用户ID所属的人员信息.
	 * @param userId
	 * @return
	 * @throws BizException
	 */
	public PsndocAggDO getEmployeeInfoByUserId(String userId) throws BizException;
	
	/**
	 * 获取物品管理模块使用的会计期间方案ID
	 */
	public String getAccPeriodSchemeId() throws BizException;
	
	/**
	 * 出入库时，对制单日期和确认日期进行验证
	 * @param whouseID 仓库ID
	 * @param dtSt 制单日期
	 * @param dtConf 确认日期
	 * @param orderStstus 单据状态
	 * @return
	 * @throws BizException
	 */
	public String checkStockStDt(String whouseID, FDateTime dtSt, FDateTime dtConf, String orderStstus) throws BizException;
	
	/**
	 * 调拨时，对制单日期和确认日期进行验证
	 * @param trapImplDO 调拨单
	 * @return
	 * @throws BizException
	 */
	public String checkTrapImStDt(TrapImplDO trapImplDO) throws BizException;
	
	/**
	 * 盘点时，对制单日期和审批日期进行验证
	 * @param stockCheckDO 盘点单
	 * @return
	 * @throws BizException
	 */
	public String checkInventoryStDt(StockCheckDO stockCheckDO) throws BizException;
	
	/**
	 * 制作发票时，对开票日期和审批日期进行验证
	 * @param stockCheckDO 盘点单
	 * @return
	 * @throws BizException
	 */
	public String checkInvoiceStDt(StockInvoiceDO stockInvoiceDO) throws BizException;
}
