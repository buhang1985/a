package iih.bl.inc.blincoepcanclog.i;

import xap.mw.core.data.BizException;
import iih.bl.inc.blincoepcanclog.d.BlIncOepCancLogDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 门诊发票作废日志数据维护服务
*/
public interface IBlincoepcanclogCudService {
	/**
	*  门诊发票作废日志数据真删除
	*/
    public abstract void delete(BlIncOepCancLogDO[] aggdos) throws BizException;
    
    /**
	*  门诊发票作废日志数据插入保存
	*/
	public abstract BlIncOepCancLogDO[] insert(BlIncOepCancLogDO[] aggdos) throws BizException;
	
    /**
	*  门诊发票作废日志数据保存
	*/
	public abstract BlIncOepCancLogDO[] save(BlIncOepCancLogDO[] aggdos) throws BizException;
	
    /**
	*  门诊发票作废日志数据更新
	*/
	public abstract BlIncOepCancLogDO[] update(BlIncOepCancLogDO[] aggdos) throws BizException;
	
	/**
	*  门诊发票作废日志数据逻辑删除
	*/
	public abstract void logicDelete(BlIncOepCancLogDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlIncOepCancLogDO[] enableWithoutFilter(BlIncOepCancLogDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlIncOepCancLogDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlIncOepCancLogDO[] disableVOWithoutFilter(BlIncOepCancLogDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlIncOepCancLogDO[] dos) throws BizException ;
}
