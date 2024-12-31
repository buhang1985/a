package iih.bd.srv.mrarchivesrc.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrarchivesrc.d.MrArchiveSrcDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病案归档来源数据维护服务
*/
public interface IMrarchivesrcCudService {
	/**
	*  病案归档来源数据真删除
	*/
    public abstract void delete(MrArchiveSrcDO[] aggdos) throws BizException;
    
    /**
	*  病案归档来源数据插入保存
	*/
	public abstract MrArchiveSrcDO[] insert(MrArchiveSrcDO[] aggdos) throws BizException;
	
    /**
	*  病案归档来源数据保存
	*/
	public abstract MrArchiveSrcDO[] save(MrArchiveSrcDO[] aggdos) throws BizException;
	
    /**
	*  病案归档来源数据更新
	*/
	public abstract MrArchiveSrcDO[] update(MrArchiveSrcDO[] aggdos) throws BizException;
	
	/**
	*  病案归档来源数据逻辑删除
	*/
	public abstract void logicDelete(MrArchiveSrcDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MrArchiveSrcDO[] enableWithoutFilter(MrArchiveSrcDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MrArchiveSrcDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MrArchiveSrcDO[] disableVOWithoutFilter(MrArchiveSrcDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MrArchiveSrcDO[] dos) throws BizException ;
}
