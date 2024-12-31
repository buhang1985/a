package iih.pe.pbd.pewfroute.i;

import xap.mw.core.data.BizException;
import iih.pe.pbd.pewfroute.d.PeChkRouteCondDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检流程路线定义数据维护服务
*/
public interface IPeChkRouteCondDOCudService {
	/**
	*  体检流程路线定义数据真删除
	*/
    public abstract void delete(PeChkRouteCondDO[] aggdos) throws BizException;
    
    /**
	*  体检流程路线定义数据插入保存
	*/
	public abstract PeChkRouteCondDO[] insert(PeChkRouteCondDO[] aggdos) throws BizException;
	
    /**
	*  体检流程路线定义数据保存
	*/
	public abstract PeChkRouteCondDO[] save(PeChkRouteCondDO[] aggdos) throws BizException;
	
    /**
	*  体检流程路线定义数据更新
	*/
	public abstract PeChkRouteCondDO[] update(PeChkRouteCondDO[] aggdos) throws BizException;
	
	/**
	*  体检流程路线定义数据逻辑删除
	*/
	public abstract void logicDelete(PeChkRouteCondDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeChkRouteCondDO[] enableWithoutFilter(PeChkRouteCondDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeChkRouteCondDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeChkRouteCondDO[] disableVOWithoutFilter(PeChkRouteCondDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeChkRouteCondDO[] aggdos) throws BizException ;
	
}
