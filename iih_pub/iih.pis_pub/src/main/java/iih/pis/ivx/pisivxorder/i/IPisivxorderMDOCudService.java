package iih.pis.ivx.pisivxorder.i;

import xap.mw.core.data.BizException;
import iih.pis.ivx.pisivxorder.d.PisIvxOrderDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 微信处方订单数据维护服务
*/
public interface IPisivxorderMDOCudService {
	/**
	*  微信处方订单数据真删除
	*/
    public abstract void delete(PisIvxOrderDO[] aggdos) throws BizException;
    
    /**
	*  微信处方订单数据插入保存
	*/
	public abstract PisIvxOrderDO[] insert(PisIvxOrderDO[] aggdos) throws BizException;
	
    /**
	*  微信处方订单数据保存
	*/
	public abstract PisIvxOrderDO[] save(PisIvxOrderDO[] aggdos) throws BizException;
	
    /**
	*  微信处方订单数据更新
	*/
	public abstract PisIvxOrderDO[] update(PisIvxOrderDO[] aggdos) throws BizException;
	
	/**
	*  微信处方订单数据逻辑删除
	*/
	public abstract void logicDelete(PisIvxOrderDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PisIvxOrderDO[] enableWithoutFilter(PisIvxOrderDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PisIvxOrderDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PisIvxOrderDO[] disableVOWithoutFilter(PisIvxOrderDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PisIvxOrderDO[] aggdos) throws BizException ;
	
}
