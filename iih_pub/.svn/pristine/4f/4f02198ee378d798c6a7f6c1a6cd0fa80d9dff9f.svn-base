package iih.bd.srv.reviewtp.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.reviewtp.d.MrReviewtp;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗记录审签级别数据维护服务
*/
public interface IReviewtpCudService {
	/**
	*  医疗记录审签级别数据真删除
	*/
    public abstract void delete(MrReviewtp[] aggdos) throws BizException;
    
    /**
	*  医疗记录审签级别数据插入保存
	*/
	public abstract MrReviewtp[] insert(MrReviewtp[] aggdos) throws BizException;
	
    /**
	*  医疗记录审签级别数据保存
	*/
	public abstract MrReviewtp[] save(MrReviewtp[] aggdos) throws BizException;
	
    /**
	*  医疗记录审签级别数据更新
	*/
	public abstract MrReviewtp[] update(MrReviewtp[] aggdos) throws BizException;
	
	/**
	*  医疗记录审签级别数据逻辑删除
	*/
	public abstract void logicDelete(MrReviewtp[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MrReviewtp[] enableWithoutFilter(MrReviewtp[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MrReviewtp[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MrReviewtp[] disableVOWithoutFilter(MrReviewtp[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MrReviewtp[] dos) throws BizException ;
}
