package iih.bd.mhi.referralapprcate.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.referralapprcate.d.ReferralApprCateDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保产品_转诊审批类别数据维护服务
*/
public interface IReferralapprcateCudService {
	/**
	*  医保产品_转诊审批类别数据真删除
	*/
    public abstract void delete(ReferralApprCateDO[] aggdos) throws BizException;
    
    /**
	*  医保产品_转诊审批类别数据插入保存
	*/
	public abstract ReferralApprCateDO[] insert(ReferralApprCateDO[] aggdos) throws BizException;
	
    /**
	*  医保产品_转诊审批类别数据保存
	*/
	public abstract ReferralApprCateDO[] save(ReferralApprCateDO[] aggdos) throws BizException;
	
    /**
	*  医保产品_转诊审批类别数据更新
	*/
	public abstract ReferralApprCateDO[] update(ReferralApprCateDO[] aggdos) throws BizException;
	
	/**
	*  医保产品_转诊审批类别数据逻辑删除
	*/
	public abstract void logicDelete(ReferralApprCateDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ReferralApprCateDO[] enableWithoutFilter(ReferralApprCateDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ReferralApprCateDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ReferralApprCateDO[] disableVOWithoutFilter(ReferralApprCateDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ReferralApprCateDO[] dos) throws BizException ;
}
