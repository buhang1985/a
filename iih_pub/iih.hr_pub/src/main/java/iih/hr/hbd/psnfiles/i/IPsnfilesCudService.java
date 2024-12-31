package iih.hr.hbd.psnfiles.i;

import xap.mw.core.data.BizException;
import iih.hr.hbd.psnfiles.d.HbdPsnFilesDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 人员文件数据维护服务
*/
public interface IPsnfilesCudService {
	/**
	*  人员文件数据真删除
	*/
    public abstract void delete(HbdPsnFilesDO[] aggdos) throws BizException;
    
    /**
	*  人员文件数据插入保存
	*/
	public abstract HbdPsnFilesDO[] insert(HbdPsnFilesDO[] aggdos) throws BizException;
	
    /**
	*  人员文件数据保存
	*/
	public abstract HbdPsnFilesDO[] save(HbdPsnFilesDO[] aggdos) throws BizException;
	
    /**
	*  人员文件数据更新
	*/
	public abstract HbdPsnFilesDO[] update(HbdPsnFilesDO[] aggdos) throws BizException;
	
	/**
	*  人员文件数据逻辑删除
	*/
	public abstract void logicDelete(HbdPsnFilesDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HbdPsnFilesDO[] enableWithoutFilter(HbdPsnFilesDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HbdPsnFilesDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HbdPsnFilesDO[] disableVOWithoutFilter(HbdPsnFilesDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HbdPsnFilesDO[] dos) throws BizException ;
}
