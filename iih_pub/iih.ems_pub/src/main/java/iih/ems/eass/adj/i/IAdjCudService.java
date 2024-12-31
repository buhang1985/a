package iih.ems.eass.adj.i;

import xap.mw.core.data.BizException;
import iih.ems.eass.adj.d.EmsAdjDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 资产价值变更数据维护服务
*/
public interface IAdjCudService {
	/**
	*  资产价值变更数据真删除
	*/
    public abstract void delete(EmsAdjDO[] aggdos) throws BizException;
    
    /**
	*  资产价值变更数据插入保存
	*/
	public abstract EmsAdjDO[] insert(EmsAdjDO[] aggdos) throws BizException;
	
    /**
	*  资产价值变更数据保存
	*/
	public abstract EmsAdjDO[] save(EmsAdjDO[] aggdos) throws BizException;
	
    /**
	*  资产价值变更数据更新
	*/
	public abstract EmsAdjDO[] update(EmsAdjDO[] aggdos) throws BizException;
	
	/**
	*  资产价值变更数据逻辑删除
	*/
	public abstract void logicDelete(EmsAdjDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmsAdjDO[] enableWithoutFilter(EmsAdjDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmsAdjDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmsAdjDO[] disableVOWithoutFilter(EmsAdjDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmsAdjDO[] dos) throws BizException ;
}
