package iih.en.pv.enhpreferral.i;

import xap.mw.core.data.BizException;
import iih.en.pv.enhpreferral.d.EnHpReferralDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保转诊单数据维护服务
*/
public interface IEnhpreferralCudService {
	/**
	*  医保转诊单数据真删除
	*/
    public abstract void delete(EnHpReferralDO[] aggdos) throws BizException;
    
    /**
	*  医保转诊单数据插入保存
	*/
	public abstract EnHpReferralDO[] insert(EnHpReferralDO[] aggdos) throws BizException;
	
    /**
	*  医保转诊单数据保存
	*/
	public abstract EnHpReferralDO[] save(EnHpReferralDO[] aggdos) throws BizException;
	
    /**
	*  医保转诊单数据更新
	*/
	public abstract EnHpReferralDO[] update(EnHpReferralDO[] aggdos) throws BizException;
	
	/**
	*  医保转诊单数据逻辑删除
	*/
	public abstract void logicDelete(EnHpReferralDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnHpReferralDO[] enableWithoutFilter(EnHpReferralDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnHpReferralDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnHpReferralDO[] disableVOWithoutFilter(EnHpReferralDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnHpReferralDO[] dos) throws BizException ;
}
