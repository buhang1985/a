package iih.nmr.ha.tcho.hemodiasis.i;

import xap.mw.core.data.BizException;
import iih.nmr.ha.tcho.hemodiasis.d.HemodialysisDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 血液透析护理记录数据维护服务
*/
public interface IHemodiasisMDOCudService {
	/**
	*  血液透析护理记录数据真删除
	*/
    public abstract void delete(HemodialysisDO[] aggdos) throws BizException;
    
    /**
	*  血液透析护理记录数据插入保存
	*/
	public abstract HemodialysisDO[] insert(HemodialysisDO[] aggdos) throws BizException;
	
    /**
	*  血液透析护理记录数据保存
	*/
	public abstract HemodialysisDO[] save(HemodialysisDO[] aggdos) throws BizException;
	
    /**
	*  血液透析护理记录数据更新
	*/
	public abstract HemodialysisDO[] update(HemodialysisDO[] aggdos) throws BizException;
	
	/**
	*  血液透析护理记录数据逻辑删除
	*/
	public abstract void logicDelete(HemodialysisDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HemodialysisDO[] enableWithoutFilter(HemodialysisDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HemodialysisDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HemodialysisDO[] disableVOWithoutFilter(HemodialysisDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HemodialysisDO[] aggdos) throws BizException ;
	
}
