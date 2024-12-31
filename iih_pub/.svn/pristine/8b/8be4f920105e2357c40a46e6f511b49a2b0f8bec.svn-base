package iih.sc.scbd.log.i;

import xap.mw.core.data.BizException;
import iih.sc.scbd.log.d.ScLogRecDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 日志记录数据维护服务
*/
public interface ISclogrecCudService {
	/**
	*  日志记录数据真删除
	*/
    public abstract void delete(ScLogRecDO[] aggdos) throws BizException;
    
    /**
	*  日志记录数据插入保存
	*/
	public abstract ScLogRecDO[] insert(ScLogRecDO[] aggdos) throws BizException;
	
    /**
	*  日志记录数据保存
	*/
	public abstract ScLogRecDO[] save(ScLogRecDO[] aggdos) throws BizException;
	
    /**
	*  日志记录数据更新
	*/
	public abstract ScLogRecDO[] update(ScLogRecDO[] aggdos) throws BizException;
	
	/**
	*  日志记录数据逻辑删除
	*/
	public abstract void logicDelete(ScLogRecDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScLogRecDO[] enableWithoutFilter(ScLogRecDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScLogRecDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScLogRecDO[] disableVOWithoutFilter(ScLogRecDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScLogRecDO[] dos) throws BizException ;
}
