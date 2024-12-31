package iih.bd.mhi.admstatus.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.admstatus.d.AdmStatusDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 入院状态数据维护服务
*/
public interface IAdmstatusCudService {
	/**
	*  入院状态数据真删除
	*/
    public abstract void delete(AdmStatusDO[] aggdos) throws BizException;
    
    /**
	*  入院状态数据插入保存
	*/
	public abstract AdmStatusDO[] insert(AdmStatusDO[] aggdos) throws BizException;
	
    /**
	*  入院状态数据保存
	*/
	public abstract AdmStatusDO[] save(AdmStatusDO[] aggdos) throws BizException;
	
    /**
	*  入院状态数据更新
	*/
	public abstract AdmStatusDO[] update(AdmStatusDO[] aggdos) throws BizException;
	
	/**
	*  入院状态数据逻辑删除
	*/
	public abstract void logicDelete(AdmStatusDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public AdmStatusDO[] enableWithoutFilter(AdmStatusDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(AdmStatusDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public AdmStatusDO[] disableVOWithoutFilter(AdmStatusDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(AdmStatusDO[] dos) throws BizException ;
}
