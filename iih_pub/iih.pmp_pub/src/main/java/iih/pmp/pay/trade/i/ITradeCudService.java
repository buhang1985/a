package iih.pmp.pay.trade.i;

import xap.mw.core.data.BizException;
import iih.pmp.pay.trade.d.TradeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 交易流水数据维护服务
*/
public interface ITradeCudService {
	/**
	*  交易流水数据真删除
	*/
    public abstract void delete(TradeDO[] aggdos) throws BizException;
    
    /**
	*  交易流水数据插入保存
	*/
	public abstract TradeDO[] insert(TradeDO[] aggdos) throws BizException;
	
    /**
	*  交易流水数据保存
	*/
	public abstract TradeDO[] save(TradeDO[] aggdos) throws BizException;
	
    /**
	*  交易流水数据更新
	*/
	public abstract TradeDO[] update(TradeDO[] aggdos) throws BizException;
	
	/**
	*  交易流水数据逻辑删除
	*/
	public abstract void logicDelete(TradeDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public TradeDO[] enableWithoutFilter(TradeDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(TradeDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public TradeDO[] disableVOWithoutFilter(TradeDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(TradeDO[] dos) throws BizException ;
}
