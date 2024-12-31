package iih.bl.pay.blpaypat.i;

import xap.mw.core.data.BizException;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗费用_收付款_患者数据维护服务
*/
public interface IBlpaypatCudService {
	/**
	*  医疗费用_收付款_患者数据真删除
	*/
    public abstract void delete(BlPrePayPatDO[] aggdos) throws BizException;
    
    /**
	*  医疗费用_收付款_患者数据插入保存
	*/
	public abstract BlPrePayPatDO[] insert(BlPrePayPatDO[] aggdos) throws BizException;
	
    /**
	*  医疗费用_收付款_患者数据保存
	*/
	public abstract BlPrePayPatDO[] save(BlPrePayPatDO[] aggdos) throws BizException;
	
    /**
	*  医疗费用_收付款_患者数据更新
	*/
	public abstract BlPrePayPatDO[] update(BlPrePayPatDO[] aggdos) throws BizException;
	
	/**
	*  医疗费用_收付款_患者数据逻辑删除
	*/
	public abstract void logicDelete(BlPrePayPatDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlPrePayPatDO[] enableWithoutFilter(BlPrePayPatDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlPrePayPatDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlPrePayPatDO[] disableVOWithoutFilter(BlPrePayPatDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlPrePayPatDO[] dos) throws BizException ;
}
