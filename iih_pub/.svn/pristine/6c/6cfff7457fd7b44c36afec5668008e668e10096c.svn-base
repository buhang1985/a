package iih.ci.mrm.cimrmmulmedfile.i;

import xap.mw.core.data.BizException;
import iih.ci.mrm.cimrmmulmedfile.d.CiMrmMulMedFile;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病案多媒体文件数据维护服务
*/
public interface ICimrmmulmedfileCudService {
	/**
	*  病案多媒体文件数据真删除
	*/
    public abstract void delete(CiMrmMulMedFile[] aggdos) throws BizException;
    
    /**
	*  病案多媒体文件数据插入保存
	*/
	public abstract CiMrmMulMedFile[] insert(CiMrmMulMedFile[] aggdos) throws BizException;
	
    /**
	*  病案多媒体文件数据保存
	*/
	public abstract CiMrmMulMedFile[] save(CiMrmMulMedFile[] aggdos) throws BizException;
	
    /**
	*  病案多媒体文件数据更新
	*/
	public abstract CiMrmMulMedFile[] update(CiMrmMulMedFile[] aggdos) throws BizException;
	
	/**
	*  病案多媒体文件数据逻辑删除
	*/
	public abstract void logicDelete(CiMrmMulMedFile[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrmMulMedFile[] enableWithoutFilter(CiMrmMulMedFile[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrmMulMedFile[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrmMulMedFile[] disableVOWithoutFilter(CiMrmMulMedFile[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrmMulMedFile[] dos) throws BizException ;
}
