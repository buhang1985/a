package iih.ci.mb.dcmo.i;

import xap.mw.core.data.BizException;
import iih.ci.mb.dcmo.d.DoctorMemoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医生备忘录数据维护服务
*/
public interface IDoctormemoMDOCudService {
	/**
	*  医生备忘录数据真删除
	*/
    public abstract void delete(DoctorMemoDO[] aggdos) throws BizException;
    
    /**
	*  医生备忘录数据插入保存
	*/
	public abstract DoctorMemoDO[] insert(DoctorMemoDO[] aggdos) throws BizException;
	
    /**
	*  医生备忘录数据保存
	*/
	public abstract DoctorMemoDO[] save(DoctorMemoDO[] aggdos) throws BizException;
	
    /**
	*  医生备忘录数据更新
	*/
	public abstract DoctorMemoDO[] update(DoctorMemoDO[] aggdos) throws BizException;
	
	/**
	*  医生备忘录数据逻辑删除
	*/
	public abstract void logicDelete(DoctorMemoDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DoctorMemoDO[] enableWithoutFilter(DoctorMemoDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DoctorMemoDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DoctorMemoDO[] disableVOWithoutFilter(DoctorMemoDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DoctorMemoDO[] aggdos) throws BizException ;
	
}
