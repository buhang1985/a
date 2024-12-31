package iih.bd.srv.mrwp.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrwp.d.MrWritePowerDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* mrwp数据维护服务
*/
public interface IMrwpMDOCudService {
	/**
	*  mrwp数据真删除
	*/
    public abstract void delete(MrWritePowerDO[] aggdos) throws BizException;
    
    /**
	*  mrwp数据插入保存
	*/
	public abstract MrWritePowerDO[] insert(MrWritePowerDO[] aggdos) throws BizException;
	
    /**
	*  mrwp数据保存
	*/
	public abstract MrWritePowerDO[] save(MrWritePowerDO[] aggdos) throws BizException;
	
    /**
	*  mrwp数据更新
	*/
	public abstract MrWritePowerDO[] update(MrWritePowerDO[] aggdos) throws BizException;
	
	/**
	*  mrwp数据逻辑删除
	*/
	public abstract void logicDelete(MrWritePowerDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MrWritePowerDO[] enableWithoutFilter(MrWritePowerDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MrWritePowerDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MrWritePowerDO[] disableVOWithoutFilter(MrWritePowerDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MrWritePowerDO[] aggdos) throws BizException ;
	
}
