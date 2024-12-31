package iih.mi.mibd.dischargedstatus.i;

import xap.mw.core.data.BizException;
import iih.mi.mibd.dischargedstatus.d.DischargedStatusDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保平台_出院状态数据维护服务
*/
public interface IDischargedstatusCudService {
	/**
	*  医保平台_出院状态数据真删除
	*/
    public abstract void delete(DischargedStatusDO[] aggdos) throws BizException;
    
    /**
	*  医保平台_出院状态数据插入保存
	*/
	public abstract DischargedStatusDO[] insert(DischargedStatusDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_出院状态数据保存
	*/
	public abstract DischargedStatusDO[] save(DischargedStatusDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_出院状态数据更新
	*/
	public abstract DischargedStatusDO[] update(DischargedStatusDO[] aggdos) throws BizException;
	
	/**
	*  医保平台_出院状态数据逻辑删除
	*/
	public abstract void logicDelete(DischargedStatusDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DischargedStatusDO[] enableWithoutFilter(DischargedStatusDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DischargedStatusDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DischargedStatusDO[] disableVOWithoutFilter(DischargedStatusDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DischargedStatusDO[] dos) throws BizException ;
}
