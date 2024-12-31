package iih.ems.einv.emout.i;

import xap.mw.core.data.BizException;
import iih.ems.einv.emout.d.EmsOutDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 设备出库数据维护服务
*/
public interface IEmoutMDOCudService {
	/**
	*  设备出库数据真删除
	*/
    public abstract void delete(EmsOutDO[] aggdos) throws BizException;
    
    /**
	*  设备出库数据插入保存
	*/
	public abstract EmsOutDO[] insert(EmsOutDO[] aggdos) throws BizException;
	
    /**
	*  设备出库数据保存
	*/
	public abstract EmsOutDO[] save(EmsOutDO[] aggdos) throws BizException;
	
    /**
	*  设备出库数据更新
	*/
	public abstract EmsOutDO[] update(EmsOutDO[] aggdos) throws BizException;
	
	/**
	*  设备出库数据逻辑删除
	*/
	public abstract void logicDelete(EmsOutDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmsOutDO[] enableWithoutFilter(EmsOutDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmsOutDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmsOutDO[] disableVOWithoutFilter(EmsOutDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmsOutDO[] aggdos) throws BizException ;
	
}
