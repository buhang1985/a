package iih.sc.apt.aptip.i;

import xap.mw.core.data.BizException;
import iih.sc.apt.aptip.d.AptIpMatchDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 住院预约匹配数据维护服务
*/
public interface IAptipmatchCudService {
	/**
	*  住院预约匹配数据真删除
	*/
    public abstract void delete(AptIpMatchDO[] aggdos) throws BizException;
    
    /**
	*  住院预约匹配数据插入保存
	*/
	public abstract AptIpMatchDO[] insert(AptIpMatchDO[] aggdos) throws BizException;
	
    /**
	*  住院预约匹配数据保存
	*/
	public abstract AptIpMatchDO[] save(AptIpMatchDO[] aggdos) throws BizException;
	
    /**
	*  住院预约匹配数据更新
	*/
	public abstract AptIpMatchDO[] update(AptIpMatchDO[] aggdos) throws BizException;
	
	/**
	*  住院预约匹配数据逻辑删除
	*/
	public abstract void logicDelete(AptIpMatchDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public AptIpMatchDO[] enableWithoutFilter(AptIpMatchDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(AptIpMatchDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public AptIpMatchDO[] disableVOWithoutFilter(AptIpMatchDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(AptIpMatchDO[] dos) throws BizException ;
}
