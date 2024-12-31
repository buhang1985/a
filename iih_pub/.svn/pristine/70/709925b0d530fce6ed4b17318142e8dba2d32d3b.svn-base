package iih.mkr.std.devd.i;

import xap.mw.core.data.BizException;
import iih.mkr.std.devd.d.DeValDomainDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 数据元值域数据维护服务
*/
public interface IDevdCudService {
	/**
	*  数据元值域数据真删除
	*/
    public abstract void delete(DeValDomainDO[] aggdos) throws BizException;
    
    /**
	*  数据元值域数据插入保存
	*/
	public abstract DeValDomainDO[] insert(DeValDomainDO[] aggdos) throws BizException;
	
    /**
	*  数据元值域数据保存
	*/
	public abstract DeValDomainDO[] save(DeValDomainDO[] aggdos) throws BizException;
	
    /**
	*  数据元值域数据更新
	*/
	public abstract DeValDomainDO[] update(DeValDomainDO[] aggdos) throws BizException;
	
	/**
	*  数据元值域数据逻辑删除
	*/
	public abstract void logicDelete(DeValDomainDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DeValDomainDO[] enableWithoutFilter(DeValDomainDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DeValDomainDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DeValDomainDO[] disableVOWithoutFilter(DeValDomainDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DeValDomainDO[] dos) throws BizException ;
}
