package iih.bd.srv.usageselfcaitm.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.usageselfcaitm.d.UsageSelfCaItmRelDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 用法自定义分类项目数据维护服务
*/
public interface IUsageSelfCaItmRelDOCudService {
	/**
	*  用法自定义分类项目数据删除
	*/
    public abstract void delete(UsageSelfCaItmRelDO[] aggdos) throws BizException;
    
    /**
	*  用法自定义分类项目数据插入保存
	*/
	public abstract UsageSelfCaItmRelDO[] insert(UsageSelfCaItmRelDO[] aggdos) throws BizException;
	
    /**
	*  用法自定义分类项目数据保存
	*/
	public abstract UsageSelfCaItmRelDO[] save(UsageSelfCaItmRelDO[] aggdos) throws BizException;
	
    /**
	*  用法自定义分类项目数据更新
	*/
	public abstract UsageSelfCaItmRelDO[] update(UsageSelfCaItmRelDO[] aggdos) throws BizException;
	
	/**
	*  用法自定义分类项目数据真删
	*/
	public abstract void logicDelete(UsageSelfCaItmRelDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public UsageSelfCaItmRelDO[] enableWithoutFilter(UsageSelfCaItmRelDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(UsageSelfCaItmRelDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public UsageSelfCaItmRelDO[] disableVOWithoutFilter(UsageSelfCaItmRelDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(UsageSelfCaItmRelDO[] aggdos) throws BizException ;
	
}
