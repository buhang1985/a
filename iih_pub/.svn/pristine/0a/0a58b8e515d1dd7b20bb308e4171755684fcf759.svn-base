package iih.sc.apt.scapt.i;

import xap.mw.core.data.BizException;
import iih.sc.apt.scapt.d.AptOpOralDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 口腔门诊预约数据维护服务
*/
public interface IAptoporalCudService {
	/**
	*  口腔门诊预约数据真删除
	*/
    public abstract void delete(AptOpOralDO[] aggdos) throws BizException;
    
    /**
	*  口腔门诊预约数据插入保存
	*/
	public abstract AptOpOralDO[] insert(AptOpOralDO[] aggdos) throws BizException;
	
    /**
	*  口腔门诊预约数据保存
	*/
	public abstract AptOpOralDO[] save(AptOpOralDO[] aggdos) throws BizException;
	
    /**
	*  口腔门诊预约数据更新
	*/
	public abstract AptOpOralDO[] update(AptOpOralDO[] aggdos) throws BizException;
	
	/**
	*  口腔门诊预约数据逻辑删除
	*/
	public abstract void logicDelete(AptOpOralDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public AptOpOralDO[] enableWithoutFilter(AptOpOralDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(AptOpOralDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public AptOpOralDO[] disableVOWithoutFilter(AptOpOralDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(AptOpOralDO[] dos) throws BizException ;
}
