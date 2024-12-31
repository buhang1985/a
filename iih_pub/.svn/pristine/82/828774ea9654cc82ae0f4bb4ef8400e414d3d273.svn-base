package iih.en.que.enqueue.i;

import xap.mw.core.data.BizException;
import iih.en.que.enqueue.d.EnQueueDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 患者就诊_队列数据维护服务
*/
public interface IEnqueueCudService {
	/**
	*  患者就诊_队列数据真删除
	*/
    public abstract void delete(EnQueueDO[] aggdos) throws BizException;
    
    /**
	*  患者就诊_队列数据插入保存
	*/
	public abstract EnQueueDO[] insert(EnQueueDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_队列数据保存
	*/
	public abstract EnQueueDO[] save(EnQueueDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_队列数据更新
	*/
	public abstract EnQueueDO[] update(EnQueueDO[] aggdos) throws BizException;
	
	/**
	*  患者就诊_队列数据逻辑删除
	*/
	public abstract void logicDelete(EnQueueDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnQueueDO[] enableWithoutFilter(EnQueueDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnQueueDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnQueueDO[] disableVOWithoutFilter(EnQueueDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnQueueDO[] dos) throws BizException ;
}
