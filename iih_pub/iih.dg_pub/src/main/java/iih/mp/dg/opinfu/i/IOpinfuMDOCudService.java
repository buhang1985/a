package iih.mp.dg.opinfu.i;

import xap.mw.core.data.BizException;
import iih.mp.dg.opinfu.d.OpInfuseDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 门诊输液数据维护服务
*/
public interface IOpinfuMDOCudService {
	/**
	*  门诊输液数据真删除
	*/
    public abstract void delete(OpInfuseDO[] aggdos) throws BizException;
    
    /**
	*  门诊输液数据插入保存
	*/
	public abstract OpInfuseDO[] insert(OpInfuseDO[] aggdos) throws BizException;
	
    /**
	*  门诊输液数据保存
	*/
	public abstract OpInfuseDO[] save(OpInfuseDO[] aggdos) throws BizException;
	
    /**
	*  门诊输液数据更新
	*/
	public abstract OpInfuseDO[] update(OpInfuseDO[] aggdos) throws BizException;
	
	/**
	*  门诊输液数据逻辑删除
	*/
	public abstract void logicDelete(OpInfuseDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OpInfuseDO[] enableWithoutFilter(OpInfuseDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OpInfuseDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OpInfuseDO[] disableVOWithoutFilter(OpInfuseDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OpInfuseDO[] aggdos) throws BizException ;
	
}
