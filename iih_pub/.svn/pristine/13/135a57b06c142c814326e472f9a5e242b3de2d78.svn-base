package iih.en.pv.enfee.i;

import xap.mw.core.data.BizException;
import iih.en.pv.enfee.d.EnAccountDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 患者就诊_就诊账户数据维护服务
*/
public interface IEnaccountMDOCudService {
	/**
	*  患者就诊_就诊账户数据真删除
	*/
    public abstract void delete(EnAccountDO[] aggdos) throws BizException;
    
    /**
	*  患者就诊_就诊账户数据插入保存
	*/
	public abstract EnAccountDO[] insert(EnAccountDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_就诊账户数据保存
	*/
	public abstract EnAccountDO[] save(EnAccountDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_就诊账户数据更新
	*/
	public abstract EnAccountDO[] update(EnAccountDO[] aggdos) throws BizException;
	
	/**
	*  患者就诊_就诊账户数据逻辑删除
	*/
	public abstract void logicDelete(EnAccountDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnAccountDO[] enableWithoutFilter(EnAccountDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnAccountDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnAccountDO[] disableVOWithoutFilter(EnAccountDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnAccountDO[] aggdos) throws BizException ;
	
}
