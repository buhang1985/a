package iih.pmp.pay.paychannels.i;

import xap.mw.core.data.BizException;
import iih.pmp.pay.paychannels.d.PaychannelsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 支付渠道数据维护服务
*/
public interface IPaychannelsCudService {
	/**
	*  支付渠道数据真删除
	*/
    public abstract void delete(PaychannelsDO[] aggdos) throws BizException;
    
    /**
	*  支付渠道数据插入保存
	*/
	public abstract PaychannelsDO[] insert(PaychannelsDO[] aggdos) throws BizException;
	
    /**
	*  支付渠道数据保存
	*/
	public abstract PaychannelsDO[] save(PaychannelsDO[] aggdos) throws BizException;
	
    /**
	*  支付渠道数据更新
	*/
	public abstract PaychannelsDO[] update(PaychannelsDO[] aggdos) throws BizException;
	
	/**
	*  支付渠道数据逻辑删除
	*/
	public abstract void logicDelete(PaychannelsDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PaychannelsDO[] enableWithoutFilter(PaychannelsDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PaychannelsDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PaychannelsDO[] disableVOWithoutFilter(PaychannelsDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PaychannelsDO[] dos) throws BizException ;
}
