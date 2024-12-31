package iih.mm.po.purchase.i;

import xap.mw.core.data.BizException;
import iih.mm.po.purchase.d.PurchaseOrderDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 采购单数据维护服务
*/
public interface IPurchaseMDOCudService {
	/**
	*  采购单数据真删除
	*/
    public abstract void delete(PurchaseOrderDO[] aggdos) throws BizException;
    
    /**
	*  采购单数据插入保存
	*/
	public abstract PurchaseOrderDO[] insert(PurchaseOrderDO[] aggdos) throws BizException;
	
    /**
	*  采购单数据保存
	*/
	public abstract PurchaseOrderDO[] save(PurchaseOrderDO[] aggdos) throws BizException;
	
    /**
	*  采购单数据更新
	*/
	public abstract PurchaseOrderDO[] update(PurchaseOrderDO[] aggdos) throws BizException;
	
	/**
	*  采购单数据逻辑删除
	*/
	public abstract void logicDelete(PurchaseOrderDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PurchaseOrderDO[] enableWithoutFilter(PurchaseOrderDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PurchaseOrderDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PurchaseOrderDO[] disableVOWithoutFilter(PurchaseOrderDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PurchaseOrderDO[] aggdos) throws BizException ;
	
}
