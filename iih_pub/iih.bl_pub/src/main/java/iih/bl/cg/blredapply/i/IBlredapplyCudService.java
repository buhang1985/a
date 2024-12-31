package iih.bl.cg.blredapply.i;

import xap.mw.core.data.BizException;
import iih.bl.cg.blredapply.d.BlRefundApplyDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 退费申请单数据维护服务
*/
public interface IBlredapplyCudService {
	/**
	*  退费申请单数据真删除
	*/
    public abstract void delete(BlRefundApplyDO[] aggdos) throws BizException;
    
    /**
	*  退费申请单数据插入保存
	*/
	public abstract BlRefundApplyDO[] insert(BlRefundApplyDO[] aggdos) throws BizException;
	
    /**
	*  退费申请单数据保存
	*/
	public abstract BlRefundApplyDO[] save(BlRefundApplyDO[] aggdos) throws BizException;
	
    /**
	*  退费申请单数据更新
	*/
	public abstract BlRefundApplyDO[] update(BlRefundApplyDO[] aggdos) throws BizException;
	
	/**
	*  退费申请单数据逻辑删除
	*/
	public abstract void logicDelete(BlRefundApplyDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlRefundApplyDO[] enableWithoutFilter(BlRefundApplyDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlRefundApplyDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlRefundApplyDO[] disableVOWithoutFilter(BlRefundApplyDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlRefundApplyDO[] dos) throws BizException ;
}
