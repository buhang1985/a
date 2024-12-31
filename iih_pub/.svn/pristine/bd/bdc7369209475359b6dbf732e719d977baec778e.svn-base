package iih.bl.hp.blputexrxpres.i;

import xap.mw.core.data.BizException;
import iih.bl.hp.blputexrxpres.d.BlPutExRxPresDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 外配处方上传记录数据维护服务
*/
public interface IBlputexrxpresCudService {
	/**
	*  外配处方上传记录数据真删除
	*/
    public abstract void delete(BlPutExRxPresDO[] aggdos) throws BizException;
    
    /**
	*  外配处方上传记录数据插入保存
	*/
	public abstract BlPutExRxPresDO[] insert(BlPutExRxPresDO[] aggdos) throws BizException;
	
    /**
	*  外配处方上传记录数据保存
	*/
	public abstract BlPutExRxPresDO[] save(BlPutExRxPresDO[] aggdos) throws BizException;
	
    /**
	*  外配处方上传记录数据更新
	*/
	public abstract BlPutExRxPresDO[] update(BlPutExRxPresDO[] aggdos) throws BizException;
	
	/**
	*  外配处方上传记录数据逻辑删除
	*/
	public abstract void logicDelete(BlPutExRxPresDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlPutExRxPresDO[] enableWithoutFilter(BlPutExRxPresDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlPutExRxPresDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlPutExRxPresDO[] disableVOWithoutFilter(BlPutExRxPresDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlPutExRxPresDO[] dos) throws BizException ;
}
