package iih.ci.mr.nu.pipeslip.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.pipeslip.d.PipeSlipCritDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 管道滑脱危险因素评估数据维护服务
*/
public interface IPipeSlipCritDOCudService {
	/**
	*  管道滑脱危险因素评估数据真删除
	*/
    public abstract void delete(PipeSlipCritDO[] aggdos) throws BizException;
    
    /**
	*  管道滑脱危险因素评估数据插入保存
	*/
	public abstract PipeSlipCritDO[] insert(PipeSlipCritDO[] aggdos) throws BizException;
	
    /**
	*  管道滑脱危险因素评估数据保存
	*/
	public abstract PipeSlipCritDO[] save(PipeSlipCritDO[] aggdos) throws BizException;
	
    /**
	*  管道滑脱危险因素评估数据更新
	*/
	public abstract PipeSlipCritDO[] update(PipeSlipCritDO[] aggdos) throws BizException;
	
	/**
	*  管道滑脱危险因素评估数据逻辑删除
	*/
	public abstract void logicDelete(PipeSlipCritDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PipeSlipCritDO[] enableWithoutFilter(PipeSlipCritDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PipeSlipCritDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PipeSlipCritDO[] disableVOWithoutFilter(PipeSlipCritDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PipeSlipCritDO[] aggdos) throws BizException ;
	
}
