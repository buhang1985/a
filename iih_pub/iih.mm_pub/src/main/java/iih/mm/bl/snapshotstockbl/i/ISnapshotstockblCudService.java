package iih.mm.bl.snapshotstockbl.i;

import xap.mw.core.data.BizException;
import iih.mm.bl.snapshotstockbl.d.SnapshotStockBlDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 结存快照数据维护服务
*/
public interface ISnapshotstockblCudService {
	/**
	*  结存快照数据真删除
	*/
    public abstract void delete(SnapshotStockBlDO[] aggdos) throws BizException;
    
    /**
	*  结存快照数据插入保存
	*/
	public abstract SnapshotStockBlDO[] insert(SnapshotStockBlDO[] aggdos) throws BizException;
	
    /**
	*  结存快照数据保存
	*/
	public abstract SnapshotStockBlDO[] save(SnapshotStockBlDO[] aggdos) throws BizException;
	
    /**
	*  结存快照数据更新
	*/
	public abstract SnapshotStockBlDO[] update(SnapshotStockBlDO[] aggdos) throws BizException;
	
	/**
	*  结存快照数据逻辑删除
	*/
	public abstract void logicDelete(SnapshotStockBlDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SnapshotStockBlDO[] enableWithoutFilter(SnapshotStockBlDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SnapshotStockBlDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SnapshotStockBlDO[] disableVOWithoutFilter(SnapshotStockBlDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SnapshotStockBlDO[] dos) throws BizException ;
}
