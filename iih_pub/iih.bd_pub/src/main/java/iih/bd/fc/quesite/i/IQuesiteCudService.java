package iih.bd.fc.quesite.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.quesite.d.QueSiteDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 队列工作点数据维护服务
*/
public interface IQuesiteCudService {
	/**
	*  队列工作点数据真删除
	*/
    public abstract void delete(QueSiteDO[] aggdos) throws BizException;
    
    /**
	*  队列工作点数据插入保存
	*/
	public abstract QueSiteDO[] insert(QueSiteDO[] aggdos) throws BizException;
	
    /**
	*  队列工作点数据保存
	*/
	public abstract QueSiteDO[] save(QueSiteDO[] aggdos) throws BizException;
	
    /**
	*  队列工作点数据更新
	*/
	public abstract QueSiteDO[] update(QueSiteDO[] aggdos) throws BizException;
	
	/**
	*  队列工作点数据逻辑删除
	*/
	public abstract void logicDelete(QueSiteDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public QueSiteDO[] enableWithoutFilter(QueSiteDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(QueSiteDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public QueSiteDO[] disableVOWithoutFilter(QueSiteDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(QueSiteDO[] dos) throws BizException ;
}
