package iih.bl.cg.blrefundaudit.i;

import xap.mw.core.data.BizException;
import iih.bl.cg.blrefundaudit.d.BlRefundAuditDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 退费审核数据维护服务
*/
public interface IBlrefundauditCudService {
	/**
	*  退费审核数据真删除
	*/
    public abstract void delete(BlRefundAuditDO[] aggdos) throws BizException;
    
    /**
	*  退费审核数据插入保存
	*/
	public abstract BlRefundAuditDO[] insert(BlRefundAuditDO[] aggdos) throws BizException;
	
    /**
	*  退费审核数据保存
	*/
	public abstract BlRefundAuditDO[] save(BlRefundAuditDO[] aggdos) throws BizException;
	
    /**
	*  退费审核数据更新
	*/
	public abstract BlRefundAuditDO[] update(BlRefundAuditDO[] aggdos) throws BizException;
	
	/**
	*  退费审核数据逻辑删除
	*/
	public abstract void logicDelete(BlRefundAuditDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlRefundAuditDO[] enableWithoutFilter(BlRefundAuditDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlRefundAuditDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlRefundAuditDO[] disableVOWithoutFilter(BlRefundAuditDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlRefundAuditDO[] dos) throws BizException ;
}
