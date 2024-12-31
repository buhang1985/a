package iih.bd.mhi.hpdetailuploadexclude.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.hpdetailuploadexclude.d.HpDetailUploadExcludeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保项目明细上传排斥数据维护服务
*/
public interface IHpdetailuploadexcludeCudService {
	/**
	*  医保项目明细上传排斥数据真删除
	*/
    public abstract void delete(HpDetailUploadExcludeDO[] aggdos) throws BizException;
    
    /**
	*  医保项目明细上传排斥数据插入保存
	*/
	public abstract HpDetailUploadExcludeDO[] insert(HpDetailUploadExcludeDO[] aggdos) throws BizException;
	
    /**
	*  医保项目明细上传排斥数据保存
	*/
	public abstract HpDetailUploadExcludeDO[] save(HpDetailUploadExcludeDO[] aggdos) throws BizException;
	
    /**
	*  医保项目明细上传排斥数据更新
	*/
	public abstract HpDetailUploadExcludeDO[] update(HpDetailUploadExcludeDO[] aggdos) throws BizException;
	
	/**
	*  医保项目明细上传排斥数据逻辑删除
	*/
	public abstract void logicDelete(HpDetailUploadExcludeDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpDetailUploadExcludeDO[] enableWithoutFilter(HpDetailUploadExcludeDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpDetailUploadExcludeDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpDetailUploadExcludeDO[] disableVOWithoutFilter(HpDetailUploadExcludeDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpDetailUploadExcludeDO[] dos) throws BizException ;
}
