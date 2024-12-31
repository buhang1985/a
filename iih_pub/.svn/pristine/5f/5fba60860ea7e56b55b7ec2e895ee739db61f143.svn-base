package iih.bd.srv.deptsrvlimit.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.deptsrvlimit.d.DeptSrvLimitItemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 科室服务白黑名单数据维护服务
*/
public interface IDeptSrvLimitItemDOCudService {
	/**
	*  科室服务白黑名单数据真删除
	*/
    public abstract void delete(DeptSrvLimitItemDO[] aggdos) throws BizException;
    
    /**
	*  科室服务白黑名单数据插入保存
	*/
	public abstract DeptSrvLimitItemDO[] insert(DeptSrvLimitItemDO[] aggdos) throws BizException;
	
    /**
	*  科室服务白黑名单数据保存
	*/
	public abstract DeptSrvLimitItemDO[] save(DeptSrvLimitItemDO[] aggdos) throws BizException;
	
    /**
	*  科室服务白黑名单数据更新
	*/
	public abstract DeptSrvLimitItemDO[] update(DeptSrvLimitItemDO[] aggdos) throws BizException;
	
	/**
	*  科室服务白黑名单数据逻辑删除
	*/
	public abstract void logicDelete(DeptSrvLimitItemDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DeptSrvLimitItemDO[] enableWithoutFilter(DeptSrvLimitItemDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DeptSrvLimitItemDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DeptSrvLimitItemDO[] disableVOWithoutFilter(DeptSrvLimitItemDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DeptSrvLimitItemDO[] aggdos) throws BizException ;
	
}
