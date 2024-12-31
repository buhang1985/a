package iih.bl.cg.blrefundapplycanc.i;

import xap.mw.core.data.BizException;
import iih.bl.cg.blrefundapplycanc.d.BlRefundApplyCancDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 退费申请取消数据维护服务
*/
public interface IBlrefundapplycancCudService {
	/**
	*  退费申请取消数据真删除
	*/
    public abstract void delete(BlRefundApplyCancDO[] aggdos) throws BizException;
    
    /**
	*  退费申请取消数据插入保存
	*/
	public abstract BlRefundApplyCancDO[] insert(BlRefundApplyCancDO[] aggdos) throws BizException;
	
    /**
	*  退费申请取消数据保存
	*/
	public abstract BlRefundApplyCancDO[] save(BlRefundApplyCancDO[] aggdos) throws BizException;
	
    /**
	*  退费申请取消数据更新
	*/
	public abstract BlRefundApplyCancDO[] update(BlRefundApplyCancDO[] aggdos) throws BizException;
	
	/**
	*  退费申请取消数据逻辑删除
	*/
	public abstract void logicDelete(BlRefundApplyCancDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlRefundApplyCancDO[] enableWithoutFilter(BlRefundApplyCancDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlRefundApplyCancDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlRefundApplyCancDO[] disableVOWithoutFilter(BlRefundApplyCancDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlRefundApplyCancDO[] dos) throws BizException ;
}
