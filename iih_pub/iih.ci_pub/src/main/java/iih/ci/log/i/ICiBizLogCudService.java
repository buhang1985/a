package iih.ci.log.i;

import xap.mw.core.data.BizException;
import iih.ci.log.d.CiBizLogDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 临床操作日志数据维护服务
*/
public interface ICiBizLogCudService {
	/**
	*  临床操作日志数据真删除
	*/
    public abstract void delete(CiBizLogDO[] aggdos) throws BizException;
    
    /**
	*  临床操作日志数据插入保存
	*/
	public abstract CiBizLogDO[] insert(CiBizLogDO[] aggdos) throws BizException;
	
    /**
	*  临床操作日志数据保存
	*/
	public abstract CiBizLogDO[] save(CiBizLogDO[] aggdos) throws BizException;
	
    /**
	*  临床操作日志数据更新
	*/
	public abstract CiBizLogDO[] update(CiBizLogDO[] aggdos) throws BizException;
	
	/**
	*  临床操作日志数据逻辑删除
	*/
	public abstract void logicDelete(CiBizLogDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiBizLogDO[] enableWithoutFilter(CiBizLogDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiBizLogDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiBizLogDO[] disableVOWithoutFilter(CiBizLogDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiBizLogDO[] dos) throws BizException ;
}
