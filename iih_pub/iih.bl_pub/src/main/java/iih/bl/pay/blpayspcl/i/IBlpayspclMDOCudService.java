package iih.bl.pay.blpayspcl.i;

import xap.mw.core.data.BizException;
import iih.bl.pay.blpayspcl.d.BlPaySpclDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 收付款_专用款数据维护服务
*/
public interface IBlpayspclMDOCudService {
	/**
	*  收付款_专用款数据真删除
	*/
    public abstract void delete(BlPaySpclDO[] aggdos) throws BizException;
    
    /**
	*  收付款_专用款数据插入保存
	*/
	public abstract BlPaySpclDO[] insert(BlPaySpclDO[] aggdos) throws BizException;
	
    /**
	*  收付款_专用款数据保存
	*/
	public abstract BlPaySpclDO[] save(BlPaySpclDO[] aggdos) throws BizException;
	
    /**
	*  收付款_专用款数据更新
	*/
	public abstract BlPaySpclDO[] update(BlPaySpclDO[] aggdos) throws BizException;
	
	/**
	*  收付款_专用款数据逻辑删除
	*/
	public abstract void logicDelete(BlPaySpclDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlPaySpclDO[] enableWithoutFilter(BlPaySpclDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlPaySpclDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlPaySpclDO[] disableVOWithoutFilter(BlPaySpclDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlPaySpclDO[] aggdos) throws BizException ;
	
}
