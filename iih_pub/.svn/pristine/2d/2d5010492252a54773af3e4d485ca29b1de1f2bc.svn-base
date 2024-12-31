package iih.mm.pl.departrequest.i;

import xap.mw.core.data.BizException;
import iih.mm.pl.departrequest.d.DepartReqOrderDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 部门领用申请数据维护服务
*/
public interface IDepartrequestMDOCudService {
	/**
	*  部门领用申请数据真删除
	*/
    public abstract void delete(DepartReqOrderDO[] aggdos) throws BizException;
    
    /**
	*  部门领用申请数据插入保存
	*/
	public abstract DepartReqOrderDO[] insert(DepartReqOrderDO[] aggdos) throws BizException;
	
    /**
	*  部门领用申请数据保存
	*/
	public abstract DepartReqOrderDO[] save(DepartReqOrderDO[] aggdos) throws BizException;
	
    /**
	*  部门领用申请数据更新
	*/
	public abstract DepartReqOrderDO[] update(DepartReqOrderDO[] aggdos) throws BizException;
	
	/**
	*  部门领用申请数据逻辑删除
	*/
	public abstract void logicDelete(DepartReqOrderDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DepartReqOrderDO[] enableWithoutFilter(DepartReqOrderDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DepartReqOrderDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DepartReqOrderDO[] disableVOWithoutFilter(DepartReqOrderDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DepartReqOrderDO[] aggdos) throws BizException ;
	
}
