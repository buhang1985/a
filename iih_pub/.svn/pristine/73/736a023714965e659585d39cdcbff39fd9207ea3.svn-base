package iih.ci.mrm.mrmarchiveinfo.i;

import xap.mw.core.data.BizException;
import iih.ci.mrm.mrmarchiveinfo.d.MrmArchiveInfoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病案归档信息数据维护服务
*/
public interface IMrmarchiveinfoCudService {
	/**
	*  病案归档信息数据真删除
	*/
    public abstract void delete(MrmArchiveInfoDO[] aggdos) throws BizException;
    
    /**
	*  病案归档信息数据插入保存
	*/
	public abstract MrmArchiveInfoDO[] insert(MrmArchiveInfoDO[] aggdos) throws BizException;
	
    /**
	*  病案归档信息数据保存
	*/
	public abstract MrmArchiveInfoDO[] save(MrmArchiveInfoDO[] aggdos) throws BizException;
	
    /**
	*  病案归档信息数据更新
	*/
	public abstract MrmArchiveInfoDO[] update(MrmArchiveInfoDO[] aggdos) throws BizException;
	
	/**
	*  病案归档信息数据逻辑删除
	*/
	public abstract void logicDelete(MrmArchiveInfoDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MrmArchiveInfoDO[] enableWithoutFilter(MrmArchiveInfoDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MrmArchiveInfoDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MrmArchiveInfoDO[] disableVOWithoutFilter(MrmArchiveInfoDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MrmArchiveInfoDO[] dos) throws BizException ;
}
