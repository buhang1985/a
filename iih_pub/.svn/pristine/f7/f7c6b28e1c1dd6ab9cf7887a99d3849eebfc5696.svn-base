package iih.cssd.dpp.dfp.i;

import xap.mw.core.data.BizException;
import iih.cssd.dpp.dfp.d.CssdDfpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 消毒包生产数据维护服务
*/
public interface IDfpMDOCudService {
	/**
	*  消毒包生产数据真删除
	*/
    public abstract void delete(CssdDfpDO[] aggdos) throws BizException;
    
    /**
	*  消毒包生产数据插入保存
	*/
	public abstract CssdDfpDO[] insert(CssdDfpDO[] aggdos) throws BizException;
	
    /**
	*  消毒包生产数据保存
	*/
	public abstract CssdDfpDO[] save(CssdDfpDO[] aggdos) throws BizException;
	
    /**
	*  消毒包生产数据更新
	*/
	public abstract CssdDfpDO[] update(CssdDfpDO[] aggdos) throws BizException;
	
	/**
	*  消毒包生产数据逻辑删除
	*/
	public abstract void logicDelete(CssdDfpDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CssdDfpDO[] enableWithoutFilter(CssdDfpDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CssdDfpDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CssdDfpDO[] disableVOWithoutFilter(CssdDfpDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CssdDfpDO[] aggdos) throws BizException ;
	
}
