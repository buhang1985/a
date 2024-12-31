package iih.bd.res.warehouse.i;

import xap.mw.core.data.BizException;
import iih.bd.res.warehouse.d.WarehouseDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 仓库数据维护服务
*/
public interface IWarehouseCudService {
	/**
	*  仓库数据真删除
	*/
    public abstract void delete(WarehouseDO[] aggdos) throws BizException;
    
    /**
	*  仓库数据插入保存
	*/
	public abstract WarehouseDO[] insert(WarehouseDO[] aggdos) throws BizException;
	
    /**
	*  仓库数据保存
	*/
	public abstract WarehouseDO[] save(WarehouseDO[] aggdos) throws BizException;
	
    /**
	*  仓库数据更新
	*/
	public abstract WarehouseDO[] update(WarehouseDO[] aggdos) throws BizException;
	
	/**
	*  仓库数据逻辑删除
	*/
	public abstract void logicDelete(WarehouseDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public WarehouseDO[] enableWithoutFilter(WarehouseDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(WarehouseDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public WarehouseDO[] disableVOWithoutFilter(WarehouseDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(WarehouseDO[] dos) throws BizException ;
}
