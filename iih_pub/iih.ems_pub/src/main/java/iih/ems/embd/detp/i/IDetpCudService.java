package iih.ems.embd.detp.i;

import xap.mw.core.data.BizException;
import iih.ems.embd.detp.d.EmsDeTpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 折旧方式数据维护服务
*/
public interface IDetpCudService {
	/**
	*  折旧方式数据真删除
	*/
    public abstract void delete(EmsDeTpDO[] aggdos) throws BizException;
    
    /**
	*  折旧方式数据插入保存
	*/
	public abstract EmsDeTpDO[] insert(EmsDeTpDO[] aggdos) throws BizException;
	
    /**
	*  折旧方式数据保存
	*/
	public abstract EmsDeTpDO[] save(EmsDeTpDO[] aggdos) throws BizException;
	
    /**
	*  折旧方式数据更新
	*/
	public abstract EmsDeTpDO[] update(EmsDeTpDO[] aggdos) throws BizException;
	
	/**
	*  折旧方式数据逻辑删除
	*/
	public abstract void logicDelete(EmsDeTpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmsDeTpDO[] enableWithoutFilter(EmsDeTpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmsDeTpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmsDeTpDO[] disableVOWithoutFilter(EmsDeTpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmsDeTpDO[] dos) throws BizException ;
}
