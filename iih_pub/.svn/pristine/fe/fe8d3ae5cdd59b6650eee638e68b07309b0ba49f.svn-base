package iih.bd.srv.connonationitm.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.connonationitm.d.ConnonationItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* connonationitm数据维护服务
*/
public interface IConnonationitmCudService {
	/**
	*  connonationitm数据真删除
	*/
    public abstract void delete(ConnonationItmDO[] aggdos) throws BizException;
    
    /**
	*  connonationitm数据插入保存
	*/
	public abstract ConnonationItmDO[] insert(ConnonationItmDO[] aggdos) throws BizException;
	
    /**
	*  connonationitm数据保存
	*/
	public abstract ConnonationItmDO[] save(ConnonationItmDO[] aggdos) throws BizException;
	
    /**
	*  connonationitm数据更新
	*/
	public abstract ConnonationItmDO[] update(ConnonationItmDO[] aggdos) throws BizException;
	
	/**
	*  connonationitm数据逻辑删除
	*/
	public abstract void logicDelete(ConnonationItmDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ConnonationItmDO[] enableWithoutFilter(ConnonationItmDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ConnonationItmDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ConnonationItmDO[] disableVOWithoutFilter(ConnonationItmDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ConnonationItmDO[] dos) throws BizException ;
}
