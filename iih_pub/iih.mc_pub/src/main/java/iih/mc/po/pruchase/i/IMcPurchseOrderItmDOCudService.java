package iih.mc.po.pruchase.i;

import xap.mw.core.data.BizException;
import iih.mc.po.pruchase.d.McPurchseOrderItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 采购订单数据维护服务
*/
public interface IMcPurchseOrderItmDOCudService {
	/**
	*  采购订单数据真删除
	*/
    public abstract void delete(McPurchseOrderItmDO[] aggdos) throws BizException;
    
    /**
	*  采购订单数据插入保存
	*/
	public abstract McPurchseOrderItmDO[] insert(McPurchseOrderItmDO[] aggdos) throws BizException;
	
    /**
	*  采购订单数据保存
	*/
	public abstract McPurchseOrderItmDO[] save(McPurchseOrderItmDO[] aggdos) throws BizException;
	
    /**
	*  采购订单数据更新
	*/
	public abstract McPurchseOrderItmDO[] update(McPurchseOrderItmDO[] aggdos) throws BizException;
	
	/**
	*  采购订单数据逻辑删除
	*/
	public abstract void logicDelete(McPurchseOrderItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public McPurchseOrderItmDO[] enableWithoutFilter(McPurchseOrderItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(McPurchseOrderItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public McPurchseOrderItmDO[] disableVOWithoutFilter(McPurchseOrderItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(McPurchseOrderItmDO[] aggdos) throws BizException ;
	
}
