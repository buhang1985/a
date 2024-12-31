package iih.pe.por.peorder.i;

import xap.mw.core.data.BizException;
import iih.pe.por.peorder.d.PeOrderDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检销售订单数据维护服务
*/
public interface IPeorderCudService {
	/**
	*  体检销售订单数据真删除
	*/
    public abstract void delete(PeOrderDO[] aggdos) throws BizException;
    
    /**
	*  体检销售订单数据插入保存
	*/
	public abstract PeOrderDO[] insert(PeOrderDO[] aggdos) throws BizException;
	
    /**
	*  体检销售订单数据保存
	*/
	public abstract PeOrderDO[] save(PeOrderDO[] aggdos) throws BizException;
	
    /**
	*  体检销售订单数据更新
	*/
	public abstract PeOrderDO[] update(PeOrderDO[] aggdos) throws BizException;
	
	/**
	*  体检销售订单数据逻辑删除
	*/
	public abstract void logicDelete(PeOrderDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeOrderDO[] enableWithoutFilter(PeOrderDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeOrderDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeOrderDO[] disableVOWithoutFilter(PeOrderDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeOrderDO[] dos) throws BizException ;
}
