package iih.bd.mhi.operatorupload.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.operatorupload.d.OperatorUploadDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医院操作员上传数据维护服务
*/
public interface IOperatoruploadCudService {
	/**
	*  医院操作员上传数据真删除
	*/
    public abstract void delete(OperatorUploadDO[] aggdos) throws BizException;
    
    /**
	*  医院操作员上传数据插入保存
	*/
	public abstract OperatorUploadDO[] insert(OperatorUploadDO[] aggdos) throws BizException;
	
    /**
	*  医院操作员上传数据保存
	*/
	public abstract OperatorUploadDO[] save(OperatorUploadDO[] aggdos) throws BizException;
	
    /**
	*  医院操作员上传数据更新
	*/
	public abstract OperatorUploadDO[] update(OperatorUploadDO[] aggdos) throws BizException;
	
	/**
	*  医院操作员上传数据逻辑删除
	*/
	public abstract void logicDelete(OperatorUploadDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OperatorUploadDO[] enableWithoutFilter(OperatorUploadDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OperatorUploadDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OperatorUploadDO[] disableVOWithoutFilter(OperatorUploadDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OperatorUploadDO[] dos) throws BizException ;
}
