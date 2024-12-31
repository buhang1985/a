package iih.bd.mhi.hpreferraltp.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.hpreferraltp.d.HpReferralTpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保产品_转诊类型数据维护服务
*/
public interface IHpreferraltpCudService {
	/**
	*  医保产品_转诊类型数据真删除
	*/
    public abstract void delete(HpReferralTpDO[] aggdos) throws BizException;
    
    /**
	*  医保产品_转诊类型数据插入保存
	*/
	public abstract HpReferralTpDO[] insert(HpReferralTpDO[] aggdos) throws BizException;
	
    /**
	*  医保产品_转诊类型数据保存
	*/
	public abstract HpReferralTpDO[] save(HpReferralTpDO[] aggdos) throws BizException;
	
    /**
	*  医保产品_转诊类型数据更新
	*/
	public abstract HpReferralTpDO[] update(HpReferralTpDO[] aggdos) throws BizException;
	
	/**
	*  医保产品_转诊类型数据逻辑删除
	*/
	public abstract void logicDelete(HpReferralTpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpReferralTpDO[] enableWithoutFilter(HpReferralTpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpReferralTpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpReferralTpDO[] disableVOWithoutFilter(HpReferralTpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpReferralTpDO[] dos) throws BizException ;
}
