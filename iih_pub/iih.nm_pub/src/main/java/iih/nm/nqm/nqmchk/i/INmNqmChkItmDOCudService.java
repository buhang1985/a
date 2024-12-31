package iih.nm.nqm.nqmchk.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nqmchk.d.NmNqmChkItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 质量检查数据维护服务
*/
public interface INmNqmChkItmDOCudService {
	/**
	*  质量检查数据真删除
	*/
    public abstract void delete(NmNqmChkItmDO[] aggdos) throws BizException;
    
    /**
	*  质量检查数据插入保存
	*/
	public abstract NmNqmChkItmDO[] insert(NmNqmChkItmDO[] aggdos) throws BizException;
	
    /**
	*  质量检查数据保存
	*/
	public abstract NmNqmChkItmDO[] save(NmNqmChkItmDO[] aggdos) throws BizException;
	
    /**
	*  质量检查数据更新
	*/
	public abstract NmNqmChkItmDO[] update(NmNqmChkItmDO[] aggdos) throws BizException;
	
	/**
	*  质量检查数据逻辑删除
	*/
	public abstract void logicDelete(NmNqmChkItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNqmChkItmDO[] enableWithoutFilter(NmNqmChkItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNqmChkItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNqmChkItmDO[] disableVOWithoutFilter(NmNqmChkItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNqmChkItmDO[] aggdos) throws BizException ;
	
}
