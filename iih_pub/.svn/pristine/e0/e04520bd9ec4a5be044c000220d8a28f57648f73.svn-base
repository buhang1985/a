package iih.bd.mhi.hpinsurpres.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.hpinsurpres.d.HpInsurPresDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保计划医保处方权数据维护服务
*/
public interface IHpinsurpresCudService {
	/**
	*  医保计划医保处方权数据真删除
	*/
    public abstract void delete(HpInsurPresDO[] aggdos) throws BizException;
    
    /**
	*  医保计划医保处方权数据插入保存
	*/
	public abstract HpInsurPresDO[] insert(HpInsurPresDO[] aggdos) throws BizException;
	
    /**
	*  医保计划医保处方权数据保存
	*/
	public abstract HpInsurPresDO[] save(HpInsurPresDO[] aggdos) throws BizException;
	
    /**
	*  医保计划医保处方权数据更新
	*/
	public abstract HpInsurPresDO[] update(HpInsurPresDO[] aggdos) throws BizException;
	
	/**
	*  医保计划医保处方权数据逻辑删除
	*/
	public abstract void logicDelete(HpInsurPresDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpInsurPresDO[] enableWithoutFilter(HpInsurPresDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpInsurPresDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpInsurPresDO[] disableVOWithoutFilter(HpInsurPresDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpInsurPresDO[] dos) throws BizException ;
}
