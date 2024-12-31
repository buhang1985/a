package iih.bd.fc.queben.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.queben.d.QueBenDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 队列工作台数据维护服务
*/
public interface IQuebenCudService {
	/**
	*  队列工作台数据真删除
	*/
    public abstract void delete(QueBenDO[] aggdos) throws BizException;
    
    /**
	*  队列工作台数据插入保存
	*/
	public abstract QueBenDO[] insert(QueBenDO[] aggdos) throws BizException;
	
    /**
	*  队列工作台数据保存
	*/
	public abstract QueBenDO[] save(QueBenDO[] aggdos) throws BizException;
	
    /**
	*  队列工作台数据更新
	*/
	public abstract QueBenDO[] update(QueBenDO[] aggdos) throws BizException;
	
	/**
	*  队列工作台数据逻辑删除
	*/
	public abstract void logicDelete(QueBenDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public QueBenDO[] enableWithoutFilter(QueBenDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(QueBenDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public QueBenDO[] disableVOWithoutFilter(QueBenDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(QueBenDO[] dos) throws BizException ;
}
