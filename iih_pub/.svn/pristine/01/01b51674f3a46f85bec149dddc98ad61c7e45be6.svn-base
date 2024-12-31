package iih.pe.pwf.pepsninfodo.i;

import xap.mw.core.data.BizException;
import iih.pe.pwf.pepsninfodo.d.PePsnInfoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检分检个人基本资料显示数据维护服务
*/
public interface IPepsninfodoCudService {
	/**
	*  体检分检个人基本资料显示数据真删除
	*/
    public abstract void delete(PePsnInfoDO[] aggdos) throws BizException;
    
    /**
	*  体检分检个人基本资料显示数据插入保存
	*/
	public abstract PePsnInfoDO[] insert(PePsnInfoDO[] aggdos) throws BizException;
	
    /**
	*  体检分检个人基本资料显示数据保存
	*/
	public abstract PePsnInfoDO[] save(PePsnInfoDO[] aggdos) throws BizException;
	
    /**
	*  体检分检个人基本资料显示数据更新
	*/
	public abstract PePsnInfoDO[] update(PePsnInfoDO[] aggdos) throws BizException;
	
	/**
	*  体检分检个人基本资料显示数据逻辑删除
	*/
	public abstract void logicDelete(PePsnInfoDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PePsnInfoDO[] enableWithoutFilter(PePsnInfoDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PePsnInfoDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PePsnInfoDO[] disableVOWithoutFilter(PePsnInfoDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PePsnInfoDO[] dos) throws BizException ;
}
