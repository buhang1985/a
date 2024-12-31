package iih.bd.mm.supplier.i;

import xap.mw.core.data.BizException;
import iih.bd.mm.supplier.d.SupplierDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 供应商与厂商数据维护服务
*/
public interface ISupplierCudService {
	/**
	*  供应商与厂商数据真删除
	*/
    public abstract void delete(SupplierDO[] aggdos) throws BizException;
    
    /**
	*  供应商与厂商数据插入保存
	*/
	public abstract SupplierDO[] insert(SupplierDO[] aggdos) throws BizException;
	
    /**
	*  供应商与厂商数据保存
	*/
	public abstract SupplierDO[] save(SupplierDO[] aggdos) throws BizException;
	
    /**
	*  供应商与厂商数据更新
	*/
	public abstract SupplierDO[] update(SupplierDO[] aggdos) throws BizException;
	
	/**
	*  供应商与厂商数据逻辑删除
	*/
	public abstract void logicDelete(SupplierDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SupplierDO[] enableWithoutFilter(SupplierDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SupplierDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SupplierDO[] disableVOWithoutFilter(SupplierDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SupplierDO[] dos) throws BizException ;
}
