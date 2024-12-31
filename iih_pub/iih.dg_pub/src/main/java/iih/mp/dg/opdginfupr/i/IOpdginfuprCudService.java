package iih.mp.dg.opdginfupr.i;

import xap.mw.core.data.BizException;
import iih.mp.dg.opdginfupr.d.OpDgInfuPrDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 门急诊输液执行数据维护服务
*/
public interface IOpdginfuprCudService {
	/**
	*  门急诊输液执行数据真删除
	*/
    public abstract void delete(OpDgInfuPrDO[] aggdos) throws BizException;
    
    /**
	*  门急诊输液执行数据插入保存
	*/
	public abstract OpDgInfuPrDO[] insert(OpDgInfuPrDO[] aggdos) throws BizException;
	
    /**
	*  门急诊输液执行数据保存
	*/
	public abstract OpDgInfuPrDO[] save(OpDgInfuPrDO[] aggdos) throws BizException;
	
    /**
	*  门急诊输液执行数据更新
	*/
	public abstract OpDgInfuPrDO[] update(OpDgInfuPrDO[] aggdos) throws BizException;
	
	/**
	*  门急诊输液执行数据逻辑删除
	*/
	public abstract void logicDelete(OpDgInfuPrDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OpDgInfuPrDO[] enableWithoutFilter(OpDgInfuPrDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OpDgInfuPrDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OpDgInfuPrDO[] disableVOWithoutFilter(OpDgInfuPrDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OpDgInfuPrDO[] dos) throws BizException ;
}
