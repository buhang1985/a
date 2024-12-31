package iih.bl.st.blauditip.i;

import xap.mw.core.data.BizException;
import iih.bl.st.blauditip.d.BlAuditIp;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 住院费用审核数据维护服务
*/
public interface IBlauditipMDOCudService {
	/**
	*  住院费用审核数据真删除
	*/
    public abstract void delete(BlAuditIp[] aggdos) throws BizException;
    
    /**
	*  住院费用审核数据插入保存
	*/
	public abstract BlAuditIp[] insert(BlAuditIp[] aggdos) throws BizException;
	
    /**
	*  住院费用审核数据保存
	*/
	public abstract BlAuditIp[] save(BlAuditIp[] aggdos) throws BizException;
	
    /**
	*  住院费用审核数据更新
	*/
	public abstract BlAuditIp[] update(BlAuditIp[] aggdos) throws BizException;
	
	/**
	*  住院费用审核数据逻辑删除
	*/
	public abstract void logicDelete(BlAuditIp[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlAuditIp[] enableWithoutFilter(BlAuditIp[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlAuditIp[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlAuditIp[] disableVOWithoutFilter(BlAuditIp[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlAuditIp[] aggdos) throws BizException ;
	
}
