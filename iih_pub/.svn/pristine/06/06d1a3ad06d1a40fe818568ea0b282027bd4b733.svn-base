package iih.bl.st.blstoep.i;

import xap.mw.core.data.BizException;
import iih.bl.st.blstoep.d.BlStOepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 门急诊结算数据维护服务
*/
public interface IBlstoepCudService {
	/**
	*  门急诊结算数据真删除
	*/
    public abstract void delete(BlStOepDO[] aggdos) throws BizException;
    
    /**
	*  门急诊结算数据插入保存
	*/
	public abstract BlStOepDO[] insert(BlStOepDO[] aggdos) throws BizException;
	
    /**
	*  门急诊结算数据保存
	*/
	public abstract BlStOepDO[] save(BlStOepDO[] aggdos) throws BizException;
	
    /**
	*  门急诊结算数据更新
	*/
	public abstract BlStOepDO[] update(BlStOepDO[] aggdos) throws BizException;
	
	/**
	*  门急诊结算数据逻辑删除
	*/
	public abstract void logicDelete(BlStOepDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlStOepDO[] enableWithoutFilter(BlStOepDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlStOepDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlStOepDO[] disableVOWithoutFilter(BlStOepDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlStOepDO[] dos) throws BizException ;
}
