package iih.ems.eass.emmc.i;

import xap.mw.core.data.BizException;
import iih.ems.eass.emmc.d.EmsMcDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 设备月结数据维护服务
*/
public interface IEmmcCudService {
	/**
	*  设备月结数据真删除
	*/
    public abstract void delete(EmsMcDO[] aggdos) throws BizException;
    
    /**
	*  设备月结数据插入保存
	*/
	public abstract EmsMcDO[] insert(EmsMcDO[] aggdos) throws BizException;
	
    /**
	*  设备月结数据保存
	*/
	public abstract EmsMcDO[] save(EmsMcDO[] aggdos) throws BizException;
	
    /**
	*  设备月结数据更新
	*/
	public abstract EmsMcDO[] update(EmsMcDO[] aggdos) throws BizException;
	
	/**
	*  设备月结数据逻辑删除
	*/
	public abstract void logicDelete(EmsMcDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmsMcDO[] enableWithoutFilter(EmsMcDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmsMcDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmsMcDO[] disableVOWithoutFilter(EmsMcDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmsMcDO[] dos) throws BizException ;
}
