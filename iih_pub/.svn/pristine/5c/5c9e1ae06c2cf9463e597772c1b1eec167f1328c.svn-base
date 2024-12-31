package iih.cssd.dpbd.pkg.i;

import xap.mw.core.data.BizException;
import iih.cssd.dpbd.pkg.d.CssdPkgDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 消毒包定义数据维护服务
*/
public interface IPkgMDOCudService {
	/**
	*  消毒包定义数据真删除
	*/
    public abstract void delete(CssdPkgDO[] aggdos) throws BizException;
    
    /**
	*  消毒包定义数据插入保存
	*/
	public abstract CssdPkgDO[] insert(CssdPkgDO[] aggdos) throws BizException;
	
    /**
	*  消毒包定义数据保存
	*/
	public abstract CssdPkgDO[] save(CssdPkgDO[] aggdos) throws BizException;
	
    /**
	*  消毒包定义数据更新
	*/
	public abstract CssdPkgDO[] update(CssdPkgDO[] aggdos) throws BizException;
	
	/**
	*  消毒包定义数据逻辑删除
	*/
	public abstract void logicDelete(CssdPkgDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CssdPkgDO[] enableWithoutFilter(CssdPkgDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CssdPkgDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CssdPkgDO[] disableVOWithoutFilter(CssdPkgDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CssdPkgDO[] aggdos) throws BizException ;
	
}
