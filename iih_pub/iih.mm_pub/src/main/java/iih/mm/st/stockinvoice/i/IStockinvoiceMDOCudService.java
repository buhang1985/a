package iih.mm.st.stockinvoice.i;

import xap.mw.core.data.BizException;
import iih.mm.st.stockinvoice.d.StockInvoiceDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 采购发票数据维护服务
*/
public interface IStockinvoiceMDOCudService {
	/**
	*  采购发票数据真删除
	*/
    public abstract void delete(StockInvoiceDO[] aggdos) throws BizException;
    
    /**
	*  采购发票数据插入保存
	*/
	public abstract StockInvoiceDO[] insert(StockInvoiceDO[] aggdos) throws BizException;
	
    /**
	*  采购发票数据保存
	*/
	public abstract StockInvoiceDO[] save(StockInvoiceDO[] aggdos) throws BizException;
	
    /**
	*  采购发票数据更新
	*/
	public abstract StockInvoiceDO[] update(StockInvoiceDO[] aggdos) throws BizException;
	
	/**
	*  采购发票数据逻辑删除
	*/
	public abstract void logicDelete(StockInvoiceDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public StockInvoiceDO[] enableWithoutFilter(StockInvoiceDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(StockInvoiceDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public StockInvoiceDO[] disableVOWithoutFilter(StockInvoiceDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(StockInvoiceDO[] aggdos) throws BizException ;
	
}