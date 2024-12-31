package iih.bl.hp.blhptransbankpay.i;

import xap.mw.core.data.BizException;
import iih.bl.hp.blhptransbankpay.d.BlHpTransBankPayDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保登记记录银行交易扩展数据维护服务
*/
public interface IBlhptransbankpayCudService {
	/**
	*  医保登记记录银行交易扩展数据真删除
	*/
    public abstract void delete(BlHpTransBankPayDO[] aggdos) throws BizException;
    
    /**
	*  医保登记记录银行交易扩展数据插入保存
	*/
	public abstract BlHpTransBankPayDO[] insert(BlHpTransBankPayDO[] aggdos) throws BizException;
	
    /**
	*  医保登记记录银行交易扩展数据保存
	*/
	public abstract BlHpTransBankPayDO[] save(BlHpTransBankPayDO[] aggdos) throws BizException;
	
    /**
	*  医保登记记录银行交易扩展数据更新
	*/
	public abstract BlHpTransBankPayDO[] update(BlHpTransBankPayDO[] aggdos) throws BizException;
	
	/**
	*  医保登记记录银行交易扩展数据逻辑删除
	*/
	public abstract void logicDelete(BlHpTransBankPayDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlHpTransBankPayDO[] enableWithoutFilter(BlHpTransBankPayDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlHpTransBankPayDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlHpTransBankPayDO[] disableVOWithoutFilter(BlHpTransBankPayDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlHpTransBankPayDO[] dos) throws BizException ;
}
