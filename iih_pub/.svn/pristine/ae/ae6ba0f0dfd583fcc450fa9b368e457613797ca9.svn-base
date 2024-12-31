package iih.nmr.pkuf.fcapp.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.fcapp.d.FiveColorAppDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 孕产妇五色卡信息数据维护服务
*/
public interface IFcappCudService {
	/**
	*  孕产妇五色卡信息数据真删除
	*/
    public abstract void delete(FiveColorAppDO[] aggdos) throws BizException;
    
    /**
	*  孕产妇五色卡信息数据插入保存
	*/
	public abstract FiveColorAppDO[] insert(FiveColorAppDO[] aggdos) throws BizException;
	
    /**
	*  孕产妇五色卡信息数据保存
	*/
	public abstract FiveColorAppDO[] save(FiveColorAppDO[] aggdos) throws BizException;
	
    /**
	*  孕产妇五色卡信息数据更新
	*/
	public abstract FiveColorAppDO[] update(FiveColorAppDO[] aggdos) throws BizException;
	
	/**
	*  孕产妇五色卡信息数据逻辑删除
	*/
	public abstract void logicDelete(FiveColorAppDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public FiveColorAppDO[] enableWithoutFilter(FiveColorAppDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(FiveColorAppDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public FiveColorAppDO[] disableVOWithoutFilter(FiveColorAppDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(FiveColorAppDO[] dos) throws BizException ;
}
