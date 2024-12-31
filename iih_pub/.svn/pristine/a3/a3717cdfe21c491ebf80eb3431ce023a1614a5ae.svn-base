package iih.bl.inc.blincip.i;

import xap.mw.core.data.BizException;
import iih.bl.inc.blincip.d.BlIncItmIpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 住院发票数据维护服务
*/
public interface IBlIncItmIpDOCudService {
	/**
	*  住院发票数据真删除
	*/
    public abstract void delete(BlIncItmIpDO[] aggdos) throws BizException;
    
    /**
	*  住院发票数据插入保存
	*/
	public abstract BlIncItmIpDO[] insert(BlIncItmIpDO[] aggdos) throws BizException;
	
    /**
	*  住院发票数据保存
	*/
	public abstract BlIncItmIpDO[] save(BlIncItmIpDO[] aggdos) throws BizException;
	
    /**
	*  住院发票数据更新
	*/
	public abstract BlIncItmIpDO[] update(BlIncItmIpDO[] aggdos) throws BizException;
	
	/**
	*  住院发票数据逻辑删除
	*/
	public abstract void logicDelete(BlIncItmIpDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlIncItmIpDO[] enableWithoutFilter(BlIncItmIpDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlIncItmIpDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlIncItmIpDO[] disableVOWithoutFilter(BlIncItmIpDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlIncItmIpDO[] aggdos) throws BizException ;
	
}
