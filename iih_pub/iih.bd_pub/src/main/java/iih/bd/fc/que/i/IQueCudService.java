package iih.bd.fc.que.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.que.d.QueDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 队列数据维护服务
*/
public interface IQueCudService {
	/**
	*  队列数据真删除
	*/
    public abstract void delete(QueDO[] aggdos) throws BizException;
    
    /**
	*  队列数据插入保存
	*/
	public abstract QueDO[] insert(QueDO[] aggdos) throws BizException;
	
    /**
	*  队列数据保存
	*/
	public abstract QueDO[] save(QueDO[] aggdos) throws BizException;
	
    /**
	*  队列数据更新
	*/
	public abstract QueDO[] update(QueDO[] aggdos) throws BizException;
	
	/**
	*  队列数据逻辑删除
	*/
	public abstract void logicDelete(QueDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public QueDO[] enableWithoutFilter(QueDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(QueDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public QueDO[] disableVOWithoutFilter(QueDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(QueDO[] dos) throws BizException ;
}
