package iih.cssd.dpus.dfpuse.i;

import xap.mw.core.data.BizException;
import iih.cssd.dpus.dfpuse.d.DfpUseItmDo;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 消毒包使用数据维护服务
*/
public interface IDfpUseItmDoCudService {
	/**
	*  消毒包使用数据真删除
	*/
    public abstract void delete(DfpUseItmDo[] aggdos) throws BizException;
    
    /**
	*  消毒包使用数据插入保存
	*/
	public abstract DfpUseItmDo[] insert(DfpUseItmDo[] aggdos) throws BizException;
	
    /**
	*  消毒包使用数据保存
	*/
	public abstract DfpUseItmDo[] save(DfpUseItmDo[] aggdos) throws BizException;
	
    /**
	*  消毒包使用数据更新
	*/
	public abstract DfpUseItmDo[] update(DfpUseItmDo[] aggdos) throws BizException;
	
	/**
	*  消毒包使用数据逻辑删除
	*/
	public abstract void logicDelete(DfpUseItmDo[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DfpUseItmDo[] enableWithoutFilter(DfpUseItmDo[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DfpUseItmDo[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DfpUseItmDo[] disableVOWithoutFilter(DfpUseItmDo[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DfpUseItmDo[] aggdos) throws BizException ;
	
}
