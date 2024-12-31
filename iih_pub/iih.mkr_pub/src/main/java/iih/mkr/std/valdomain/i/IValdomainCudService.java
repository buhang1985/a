package iih.mkr.std.valdomain.i;

import xap.mw.core.data.BizException;
import iih.mkr.std.valdomain.d.ValDomainDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 值域数据维护服务
*/
public interface IValdomainCudService {
	/**
	*  值域数据真删除
	*/
    public abstract void delete(ValDomainDO[] aggdos) throws BizException;
    
    /**
	*  值域数据插入保存
	*/
	public abstract ValDomainDO[] insert(ValDomainDO[] aggdos) throws BizException;
	
    /**
	*  值域数据保存
	*/
	public abstract ValDomainDO[] save(ValDomainDO[] aggdos) throws BizException;
	
    /**
	*  值域数据更新
	*/
	public abstract ValDomainDO[] update(ValDomainDO[] aggdos) throws BizException;
	
	/**
	*  值域数据逻辑删除
	*/
	public abstract void logicDelete(ValDomainDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ValDomainDO[] enableWithoutFilter(ValDomainDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ValDomainDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ValDomainDO[] disableVOWithoutFilter(ValDomainDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ValDomainDO[] dos) throws BizException ;
}
