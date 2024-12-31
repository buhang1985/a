package iih.mkr.ms.mkrms.i;

import xap.mw.core.data.BizException;
import iih.mkr.ms.mkrms.d.MkrMsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 组套定义数据维护服务
*/
public interface IMkrmsMDOCudService {
	/**
	*  组套定义数据真删除
	*/
    public abstract void delete(MkrMsDO[] aggdos) throws BizException;
    
    /**
	*  组套定义数据插入保存
	*/
	public abstract MkrMsDO[] insert(MkrMsDO[] aggdos) throws BizException;
	
    /**
	*  组套定义数据保存
	*/
	public abstract MkrMsDO[] save(MkrMsDO[] aggdos) throws BizException;
	
    /**
	*  组套定义数据更新
	*/
	public abstract MkrMsDO[] update(MkrMsDO[] aggdos) throws BizException;
	
	/**
	*  组套定义数据逻辑删除
	*/
	public abstract void logicDelete(MkrMsDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MkrMsDO[] enableWithoutFilter(MkrMsDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MkrMsDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MkrMsDO[] disableVOWithoutFilter(MkrMsDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MkrMsDO[] aggdos) throws BizException ;
	
}