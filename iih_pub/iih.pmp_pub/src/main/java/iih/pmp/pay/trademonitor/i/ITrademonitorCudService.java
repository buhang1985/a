package iih.pmp.pay.trademonitor.i;

import xap.mw.core.data.BizException;
import iih.pmp.pay.trademonitor.d.TradeMonitorDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 交易监控数据维护服务
*/
public interface ITrademonitorCudService {
	/**
	*  交易监控数据真删除
	*/
    public abstract void delete(TradeMonitorDO[] aggdos) throws BizException;
    
    /**
	*  交易监控数据插入保存
	*/
	public abstract TradeMonitorDO[] insert(TradeMonitorDO[] aggdos) throws BizException;
	
    /**
	*  交易监控数据保存
	*/
	public abstract TradeMonitorDO[] save(TradeMonitorDO[] aggdos) throws BizException;
	
    /**
	*  交易监控数据更新
	*/
	public abstract TradeMonitorDO[] update(TradeMonitorDO[] aggdos) throws BizException;
	
	/**
	*  交易监控数据逻辑删除
	*/
	public abstract void logicDelete(TradeMonitorDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public TradeMonitorDO[] enableWithoutFilter(TradeMonitorDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(TradeMonitorDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public TradeMonitorDO[] disableVOWithoutFilter(TradeMonitorDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(TradeMonitorDO[] dos) throws BizException ;
}
