package iih.ci.mr.nu.contprn.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.contprn.d.CiMrContPrnDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 文书续打数据维护服务
*/
public interface IContprnCudService {
	/**
	*  文书续打数据真删除
	*/
    public abstract void delete(CiMrContPrnDO[] aggdos) throws BizException;
    
    /**
	*  文书续打数据插入保存
	*/
	public abstract CiMrContPrnDO[] insert(CiMrContPrnDO[] aggdos) throws BizException;
	
    /**
	*  文书续打数据保存
	*/
	public abstract CiMrContPrnDO[] save(CiMrContPrnDO[] aggdos) throws BizException;
	
    /**
	*  文书续打数据更新
	*/
	public abstract CiMrContPrnDO[] update(CiMrContPrnDO[] aggdos) throws BizException;
	
	/**
	*  文书续打数据逻辑删除
	*/
	public abstract void logicDelete(CiMrContPrnDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrContPrnDO[] enableWithoutFilter(CiMrContPrnDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrContPrnDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrContPrnDO[] disableVOWithoutFilter(CiMrContPrnDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrContPrnDO[] dos) throws BizException ;
}
