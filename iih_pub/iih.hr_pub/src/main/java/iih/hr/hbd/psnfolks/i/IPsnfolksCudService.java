package iih.hr.hbd.psnfolks.i;

import xap.mw.core.data.BizException;
import iih.hr.hbd.psnfolks.d.HbdPsnFolksDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 家庭成员数据维护服务
*/
public interface IPsnfolksCudService {
	/**
	*  家庭成员数据真删除
	*/
    public abstract void delete(HbdPsnFolksDO[] aggdos) throws BizException;
    
    /**
	*  家庭成员数据插入保存
	*/
	public abstract HbdPsnFolksDO[] insert(HbdPsnFolksDO[] aggdos) throws BizException;
	
    /**
	*  家庭成员数据保存
	*/
	public abstract HbdPsnFolksDO[] save(HbdPsnFolksDO[] aggdos) throws BizException;
	
    /**
	*  家庭成员数据更新
	*/
	public abstract HbdPsnFolksDO[] update(HbdPsnFolksDO[] aggdos) throws BizException;
	
	/**
	*  家庭成员数据逻辑删除
	*/
	public abstract void logicDelete(HbdPsnFolksDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HbdPsnFolksDO[] enableWithoutFilter(HbdPsnFolksDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HbdPsnFolksDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HbdPsnFolksDO[] disableVOWithoutFilter(HbdPsnFolksDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HbdPsnFolksDO[] dos) throws BizException ;
}
