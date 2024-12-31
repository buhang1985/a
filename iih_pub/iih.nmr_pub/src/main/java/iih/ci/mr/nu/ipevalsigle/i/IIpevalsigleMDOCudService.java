package iih.ci.mr.nu.ipevalsigle.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.ipevalsigle.d.EvaluateDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 住院患者评价单数据维护服务
*/
public interface IIpevalsigleMDOCudService {
	/**
	*  住院患者评价单数据真删除
	*/
    public abstract void delete(EvaluateDO[] aggdos) throws BizException;
    
    /**
	*  住院患者评价单数据插入保存
	*/
	public abstract EvaluateDO[] insert(EvaluateDO[] aggdos) throws BizException;
	
    /**
	*  住院患者评价单数据保存
	*/
	public abstract EvaluateDO[] save(EvaluateDO[] aggdos) throws BizException;
	
    /**
	*  住院患者评价单数据更新
	*/
	public abstract EvaluateDO[] update(EvaluateDO[] aggdos) throws BizException;
	
	/**
	*  住院患者评价单数据逻辑删除
	*/
	public abstract void logicDelete(EvaluateDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EvaluateDO[] enableWithoutFilter(EvaluateDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EvaluateDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EvaluateDO[] disableVOWithoutFilter(EvaluateDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EvaluateDO[] aggdos) throws BizException ;
	
}
