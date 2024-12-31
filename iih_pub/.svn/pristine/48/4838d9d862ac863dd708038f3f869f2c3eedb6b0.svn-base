package iih.ci.mr.nu.pipeslip.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.pipeslip.d.PipeSlipDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 管道滑脱危险因素评估数据维护服务
*/
public interface IPipeslipMDOCudService {
	/**
	*  管道滑脱危险因素评估数据真删除
	*/
    public abstract void delete(PipeSlipDO[] aggdos) throws BizException;
    
    /**
	*  管道滑脱危险因素评估数据插入保存
	*/
	public abstract PipeSlipDO[] insert(PipeSlipDO[] aggdos) throws BizException;
	
    /**
	*  管道滑脱危险因素评估数据保存
	*/
	public abstract PipeSlipDO[] save(PipeSlipDO[] aggdos) throws BizException;
	
    /**
	*  管道滑脱危险因素评估数据更新
	*/
	public abstract PipeSlipDO[] update(PipeSlipDO[] aggdos) throws BizException;
	
	/**
	*  管道滑脱危险因素评估数据逻辑删除
	*/
	public abstract void logicDelete(PipeSlipDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PipeSlipDO[] enableWithoutFilter(PipeSlipDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PipeSlipDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PipeSlipDO[] disableVOWithoutFilter(PipeSlipDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PipeSlipDO[] aggdos) throws BizException ;
	
}
