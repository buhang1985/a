package iih.crm.conm.crmcon.i;

import xap.mw.core.data.BizException;
import iih.crm.conm.crmcon.d.CrmConDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 合同数据维护服务
*/
public interface ICrmconCudService {
	/**
	*  合同数据真删除
	*/
    public abstract void delete(CrmConDO[] aggdos) throws BizException;
    
    /**
	*  合同数据插入保存
	*/
	public abstract CrmConDO[] insert(CrmConDO[] aggdos) throws BizException;
	
    /**
	*  合同数据保存
	*/
	public abstract CrmConDO[] save(CrmConDO[] aggdos) throws BizException;
	
    /**
	*  合同数据更新
	*/
	public abstract CrmConDO[] update(CrmConDO[] aggdos) throws BizException;
	
	/**
	*  合同数据逻辑删除
	*/
	public abstract void logicDelete(CrmConDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CrmConDO[] enableWithoutFilter(CrmConDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CrmConDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CrmConDO[] disableVOWithoutFilter(CrmConDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CrmConDO[] dos) throws BizException ;
}
