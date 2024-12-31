package iih.ems.eass.emshift.i;

import xap.mw.core.data.BizException;
import iih.ems.eass.emshift.d.EmsEmShiftDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 设备资产保管变更数据维护服务
*/
public interface IEmshiftMDOCudService {
	/**
	*  设备资产保管变更数据真删除
	*/
    public abstract void delete(EmsEmShiftDO[] aggdos) throws BizException;
    
    /**
	*  设备资产保管变更数据插入保存
	*/
	public abstract EmsEmShiftDO[] insert(EmsEmShiftDO[] aggdos) throws BizException;
	
    /**
	*  设备资产保管变更数据保存
	*/
	public abstract EmsEmShiftDO[] save(EmsEmShiftDO[] aggdos) throws BizException;
	
    /**
	*  设备资产保管变更数据更新
	*/
	public abstract EmsEmShiftDO[] update(EmsEmShiftDO[] aggdos) throws BizException;
	
	/**
	*  设备资产保管变更数据逻辑删除
	*/
	public abstract void logicDelete(EmsEmShiftDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmsEmShiftDO[] enableWithoutFilter(EmsEmShiftDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmsEmShiftDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmsEmShiftDO[] disableVOWithoutFilter(EmsEmShiftDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmsEmShiftDO[] aggdos) throws BizException ;
	
}
