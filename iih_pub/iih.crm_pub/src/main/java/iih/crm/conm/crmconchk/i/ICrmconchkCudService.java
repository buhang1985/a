package iih.crm.conm.crmconchk.i;

import xap.mw.core.data.BizException;
import iih.crm.conm.crmconchk.d.CrmConChkDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 合同验证介质数据维护服务
*/
public interface ICrmconchkCudService {
	/**
	*  合同验证介质数据真删除
	*/
    public abstract void delete(CrmConChkDO[] aggdos) throws BizException;
    
    /**
	*  合同验证介质数据插入保存
	*/
	public abstract CrmConChkDO[] insert(CrmConChkDO[] aggdos) throws BizException;
	
    /**
	*  合同验证介质数据保存
	*/
	public abstract CrmConChkDO[] save(CrmConChkDO[] aggdos) throws BizException;
	
    /**
	*  合同验证介质数据更新
	*/
	public abstract CrmConChkDO[] update(CrmConChkDO[] aggdos) throws BizException;
	
	/**
	*  合同验证介质数据逻辑删除
	*/
	public abstract void logicDelete(CrmConChkDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CrmConChkDO[] enableWithoutFilter(CrmConChkDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CrmConChkDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CrmConChkDO[] disableVOWithoutFilter(CrmConChkDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CrmConChkDO[] dos) throws BizException ;
}
