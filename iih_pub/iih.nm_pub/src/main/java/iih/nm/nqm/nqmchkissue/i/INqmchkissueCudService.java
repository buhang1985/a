package iih.nm.nqm.nqmchkissue.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nqmchkissue.d.NmNqmChkIssueDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 质量检查问题数据维护服务
*/
public interface INqmchkissueCudService {
	/**
	*  质量检查问题数据真删除
	*/
    public abstract void delete(NmNqmChkIssueDO[] aggdos) throws BizException;
    
    /**
	*  质量检查问题数据插入保存
	*/
	public abstract NmNqmChkIssueDO[] insert(NmNqmChkIssueDO[] aggdos) throws BizException;
	
    /**
	*  质量检查问题数据保存
	*/
	public abstract NmNqmChkIssueDO[] save(NmNqmChkIssueDO[] aggdos) throws BizException;
	
    /**
	*  质量检查问题数据更新
	*/
	public abstract NmNqmChkIssueDO[] update(NmNqmChkIssueDO[] aggdos) throws BizException;
	
	/**
	*  质量检查问题数据逻辑删除
	*/
	public abstract void logicDelete(NmNqmChkIssueDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNqmChkIssueDO[] enableWithoutFilter(NmNqmChkIssueDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNqmChkIssueDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNqmChkIssueDO[] disableVOWithoutFilter(NmNqmChkIssueDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNqmChkIssueDO[] dos) throws BizException ;
}
