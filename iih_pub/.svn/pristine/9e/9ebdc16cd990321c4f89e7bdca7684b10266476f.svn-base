package iih.ems.eass.emde.i;

import xap.mw.core.data.BizException;
import iih.ems.eass.emde.d.EmsDeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 设备折旧数据维护服务
*/
public interface IEmdeCudService {
	/**
	*  设备折旧数据真删除
	*/
    public abstract void delete(EmsDeDO[] aggdos) throws BizException;
    
    /**
	*  设备折旧数据插入保存
	*/
	public abstract EmsDeDO[] insert(EmsDeDO[] aggdos) throws BizException;
	
    /**
	*  设备折旧数据保存
	*/
	public abstract EmsDeDO[] save(EmsDeDO[] aggdos) throws BizException;
	
    /**
	*  设备折旧数据更新
	*/
	public abstract EmsDeDO[] update(EmsDeDO[] aggdos) throws BizException;
	
	/**
	*  设备折旧数据逻辑删除
	*/
	public abstract void logicDelete(EmsDeDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmsDeDO[] enableWithoutFilter(EmsDeDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmsDeDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmsDeDO[] disableVOWithoutFilter(EmsDeDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmsDeDO[] dos) throws BizException ;
}
