package iih.nm.nhr.institutabatch.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.institutabatch.d.NmBatchDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 院校批次管理数据维护服务
*/
public interface INmBatchDOCudService {
	/**
	*  院校批次管理数据真删除
	*/
    public abstract void delete(NmBatchDO[] aggdos) throws BizException;
    
    /**
	*  院校批次管理数据插入保存
	*/
	public abstract NmBatchDO[] insert(NmBatchDO[] aggdos) throws BizException;
	
    /**
	*  院校批次管理数据保存
	*/
	public abstract NmBatchDO[] save(NmBatchDO[] aggdos) throws BizException;
	
    /**
	*  院校批次管理数据更新
	*/
	public abstract NmBatchDO[] update(NmBatchDO[] aggdos) throws BizException;
	
	/**
	*  院校批次管理数据逻辑删除
	*/
	public abstract void logicDelete(NmBatchDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmBatchDO[] enableWithoutFilter(NmBatchDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmBatchDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmBatchDO[] disableVOWithoutFilter(NmBatchDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmBatchDO[] aggdos) throws BizException ;
	
}
