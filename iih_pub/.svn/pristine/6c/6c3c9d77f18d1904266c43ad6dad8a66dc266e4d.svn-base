package iih.pis.ivx.pisivxorder.i;

import xap.mw.core.data.BizException;
import iih.pis.ivx.pisivxorder.d.PisIvxOrderDtlDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 微信处方订单数据维护服务
*/
public interface IPisIvxOrderDtlDOCudService {
	/**
	*  微信处方订单数据真删除
	*/
    public abstract void delete(PisIvxOrderDtlDO[] aggdos) throws BizException;
    
    /**
	*  微信处方订单数据插入保存
	*/
	public abstract PisIvxOrderDtlDO[] insert(PisIvxOrderDtlDO[] aggdos) throws BizException;
	
    /**
	*  微信处方订单数据保存
	*/
	public abstract PisIvxOrderDtlDO[] save(PisIvxOrderDtlDO[] aggdos) throws BizException;
	
    /**
	*  微信处方订单数据更新
	*/
	public abstract PisIvxOrderDtlDO[] update(PisIvxOrderDtlDO[] aggdos) throws BizException;
	
	/**
	*  微信处方订单数据逻辑删除
	*/
	public abstract void logicDelete(PisIvxOrderDtlDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PisIvxOrderDtlDO[] enableWithoutFilter(PisIvxOrderDtlDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PisIvxOrderDtlDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PisIvxOrderDtlDO[] disableVOWithoutFilter(PisIvxOrderDtlDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PisIvxOrderDtlDO[] aggdos) throws BizException ;
	
}
