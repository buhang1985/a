package iih.cssd.dpus.dfpapp.i;

import xap.mw.core.data.BizException;
import iih.cssd.dpus.dfpapp.d.DfpAppDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 请领消毒包数据维护服务
*/
public interface IDfpappMDOCudService {
	/**
	*  请领消毒包数据真删除
	*/
    public abstract void delete(DfpAppDO[] aggdos) throws BizException;
    
    /**
	*  请领消毒包数据插入保存
	*/
	public abstract DfpAppDO[] insert(DfpAppDO[] aggdos) throws BizException;
	
    /**
	*  请领消毒包数据保存
	*/
	public abstract DfpAppDO[] save(DfpAppDO[] aggdos) throws BizException;
	
    /**
	*  请领消毒包数据更新
	*/
	public abstract DfpAppDO[] update(DfpAppDO[] aggdos) throws BizException;
	
	/**
	*  请领消毒包数据逻辑删除
	*/
	public abstract void logicDelete(DfpAppDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DfpAppDO[] enableWithoutFilter(DfpAppDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DfpAppDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DfpAppDO[] disableVOWithoutFilter(DfpAppDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DfpAppDO[] aggdos) throws BizException ;
	
}
