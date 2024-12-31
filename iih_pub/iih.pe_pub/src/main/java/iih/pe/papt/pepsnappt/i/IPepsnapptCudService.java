package iih.pe.papt.pepsnappt.i;

import xap.mw.core.data.BizException;
import iih.pe.papt.pepsnappt.d.PePsnApptDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检个人预约单数据维护服务
*/
public interface IPepsnapptCudService {
	/**
	*  体检个人预约单数据真删除
	*/
    public abstract void delete(PePsnApptDO[] aggdos) throws BizException;
    
    /**
	*  体检个人预约单数据插入保存
	*/
	public abstract PePsnApptDO[] insert(PePsnApptDO[] aggdos) throws BizException;
	
    /**
	*  体检个人预约单数据保存
	*/
	public abstract PePsnApptDO[] save(PePsnApptDO[] aggdos) throws BizException;
	
    /**
	*  体检个人预约单数据更新
	*/
	public abstract PePsnApptDO[] update(PePsnApptDO[] aggdos) throws BizException;
	
	/**
	*  体检个人预约单数据逻辑删除
	*/
	public abstract void logicDelete(PePsnApptDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PePsnApptDO[] enableWithoutFilter(PePsnApptDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PePsnApptDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PePsnApptDO[] disableVOWithoutFilter(PePsnApptDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PePsnApptDO[] dos) throws BizException ;
}
