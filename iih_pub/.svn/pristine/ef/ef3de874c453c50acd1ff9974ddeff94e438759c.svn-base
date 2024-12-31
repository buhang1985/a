package iih.nm.nqm.nqmadev.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nqmadev.d.NqmAdEvDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 不良事件数据维护服务
*/
public interface INqmadevCudService {
	/**
	*  不良事件数据真删除
	*/
    public abstract void delete(NqmAdEvDO[] aggdos) throws BizException;
    
    /**
	*  不良事件数据插入保存
	*/
	public abstract NqmAdEvDO[] insert(NqmAdEvDO[] aggdos) throws BizException;
	
    /**
	*  不良事件数据保存
	*/
	public abstract NqmAdEvDO[] save(NqmAdEvDO[] aggdos) throws BizException;
	
    /**
	*  不良事件数据更新
	*/
	public abstract NqmAdEvDO[] update(NqmAdEvDO[] aggdos) throws BizException;
	
	/**
	*  不良事件数据逻辑删除
	*/
	public abstract void logicDelete(NqmAdEvDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NqmAdEvDO[] enableWithoutFilter(NqmAdEvDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NqmAdEvDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NqmAdEvDO[] disableVOWithoutFilter(NqmAdEvDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NqmAdEvDO[] dos) throws BizException ;
}
