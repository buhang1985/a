package iih.bl.cg.bldcevent.i;

import xap.mw.core.data.BizException;
import iih.bl.cg.bldcevent.d.BlDcEventDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 组件数据维护服务
*/
public interface IBldceventCudService {
	/**
	*  组件数据删除
	*/
    public abstract void delete(BlDcEventDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract BlDcEventDO[] insert(BlDcEventDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract BlDcEventDO[] save(BlDcEventDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract BlDcEventDO[] update(BlDcEventDO[] aggdos) throws BizException;
	
	/**
	*  组件数据逻辑删除
	*/
	public abstract void logicDelete(BlDcEventDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlDcEventDO[] enableWithoutFilter(BlDcEventDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlDcEventDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlDcEventDO[] disableVOWithoutFilter(BlDcEventDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlDcEventDO[] aggdos) throws BizException ;
}
