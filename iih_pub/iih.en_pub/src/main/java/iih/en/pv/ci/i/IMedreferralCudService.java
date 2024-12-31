package iih.en.pv.ci.i;

import xap.mw.core.data.BizException;
import iih.en.pv.ci.d.MedReferralDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗转诊单数据维护服务
*/
public interface IMedreferralCudService {
	/**
	*  医疗转诊单数据真删除
	*/
    public abstract void delete(MedReferralDO[] aggdos) throws BizException;
    
    /**
	*  医疗转诊单数据插入保存
	*/
	public abstract MedReferralDO[] insert(MedReferralDO[] aggdos) throws BizException;
	
    /**
	*  医疗转诊单数据保存
	*/
	public abstract MedReferralDO[] save(MedReferralDO[] aggdos) throws BizException;
	
    /**
	*  医疗转诊单数据更新
	*/
	public abstract MedReferralDO[] update(MedReferralDO[] aggdos) throws BizException;
	
	/**
	*  医疗转诊单数据逻辑删除
	*/
	public abstract void logicDelete(MedReferralDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MedReferralDO[] enableWithoutFilter(MedReferralDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MedReferralDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MedReferralDO[] disableVOWithoutFilter(MedReferralDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MedReferralDO[] dos) throws BizException ;
}
