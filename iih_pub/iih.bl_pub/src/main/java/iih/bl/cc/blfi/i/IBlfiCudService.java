package iih.bl.cc.blfi.i;

import xap.mw.core.data.BizException;
import iih.bl.cc.blfi.d.BlFiDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 财务交割数据维护服务
*/
public interface IBlfiCudService {
	/**
	*  财务交割数据真删除
	*/
    public abstract void delete(BlFiDO[] aggdos) throws BizException;
    
    /**
	*  财务交割数据插入保存
	*/
	public abstract BlFiDO[] insert(BlFiDO[] aggdos) throws BizException;
	
    /**
	*  财务交割数据保存
	*/
	public abstract BlFiDO[] save(BlFiDO[] aggdos) throws BizException;
	
    /**
	*  财务交割数据更新
	*/
	public abstract BlFiDO[] update(BlFiDO[] aggdos) throws BizException;
	
	/**
	*  财务交割数据逻辑删除
	*/
	public abstract void logicDelete(BlFiDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlFiDO[] enableWithoutFilter(BlFiDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlFiDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlFiDO[] disableVOWithoutFilter(BlFiDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlFiDO[] dos) throws BizException ;
}
