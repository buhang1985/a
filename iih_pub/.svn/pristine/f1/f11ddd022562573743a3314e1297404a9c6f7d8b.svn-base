package iih.ems.einv.emda.i;

import xap.mw.core.data.BizException;
import iih.ems.einv.emda.d.EmsDaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 设备领用申请数据维护服务
*/
public interface IEmdaMDOCudService {
	/**
	*  设备领用申请数据真删除
	*/
    public abstract void delete(EmsDaDO[] aggdos) throws BizException;
    
    /**
	*  设备领用申请数据插入保存
	*/
	public abstract EmsDaDO[] insert(EmsDaDO[] aggdos) throws BizException;
	
    /**
	*  设备领用申请数据保存
	*/
	public abstract EmsDaDO[] save(EmsDaDO[] aggdos) throws BizException;
	
    /**
	*  设备领用申请数据更新
	*/
	public abstract EmsDaDO[] update(EmsDaDO[] aggdos) throws BizException;
	
	/**
	*  设备领用申请数据逻辑删除
	*/
	public abstract void logicDelete(EmsDaDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmsDaDO[] enableWithoutFilter(EmsDaDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmsDaDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmsDaDO[] disableVOWithoutFilter(EmsDaDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmsDaDO[] aggdos) throws BizException ;
	
}
