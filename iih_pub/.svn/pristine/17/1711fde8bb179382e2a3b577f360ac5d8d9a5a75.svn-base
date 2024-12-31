package iih.mi.mibd.medpaytp.i;

import xap.mw.core.data.BizException;
import iih.mi.mibd.medpaytp.d.MedPayTpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保平台_医疗付款方式数据维护服务
*/
public interface IMedpaytpCudService {
	/**
	*  医保平台_医疗付款方式数据真删除
	*/
    public abstract void delete(MedPayTpDO[] aggdos) throws BizException;
    
    /**
	*  医保平台_医疗付款方式数据插入保存
	*/
	public abstract MedPayTpDO[] insert(MedPayTpDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_医疗付款方式数据保存
	*/
	public abstract MedPayTpDO[] save(MedPayTpDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_医疗付款方式数据更新
	*/
	public abstract MedPayTpDO[] update(MedPayTpDO[] aggdos) throws BizException;
	
	/**
	*  医保平台_医疗付款方式数据逻辑删除
	*/
	public abstract void logicDelete(MedPayTpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MedPayTpDO[] enableWithoutFilter(MedPayTpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MedPayTpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MedPayTpDO[] disableVOWithoutFilter(MedPayTpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MedPayTpDO[] dos) throws BizException ;
}
