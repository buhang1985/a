package iih.nmr.pkuf.nmrarchivmaint.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.nmrarchivmaint.d.NmrArchivMaintDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 文书归档维护数据维护服务
*/
public interface INmrarchivmaintCudService {
	/**
	*  文书归档维护数据真删除
	*/
    public abstract void delete(NmrArchivMaintDO[] aggdos) throws BizException;
    
    /**
	*  文书归档维护数据插入保存
	*/
	public abstract NmrArchivMaintDO[] insert(NmrArchivMaintDO[] aggdos) throws BizException;
	
    /**
	*  文书归档维护数据保存
	*/
	public abstract NmrArchivMaintDO[] save(NmrArchivMaintDO[] aggdos) throws BizException;
	
    /**
	*  文书归档维护数据更新
	*/
	public abstract NmrArchivMaintDO[] update(NmrArchivMaintDO[] aggdos) throws BizException;
	
	/**
	*  文书归档维护数据逻辑删除
	*/
	public abstract void logicDelete(NmrArchivMaintDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmrArchivMaintDO[] enableWithoutFilter(NmrArchivMaintDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmrArchivMaintDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmrArchivMaintDO[] disableVOWithoutFilter(NmrArchivMaintDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmrArchivMaintDO[] dos) throws BizException ;
}
