package iih.mp.dg.opinfu.i;

import xap.mw.core.data.BizException;
import iih.mp.dg.opinfu.d.OpInfuseDtDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 门诊输液数据维护服务
*/
public interface IOpInfuseDtDOCudService {
	/**
	*  门诊输液数据真删除
	*/
    public abstract void delete(OpInfuseDtDO[] aggdos) throws BizException;
    
    /**
	*  门诊输液数据插入保存
	*/
	public abstract OpInfuseDtDO[] insert(OpInfuseDtDO[] aggdos) throws BizException;
	
    /**
	*  门诊输液数据保存
	*/
	public abstract OpInfuseDtDO[] save(OpInfuseDtDO[] aggdos) throws BizException;
	
    /**
	*  门诊输液数据更新
	*/
	public abstract OpInfuseDtDO[] update(OpInfuseDtDO[] aggdos) throws BizException;
	
	/**
	*  门诊输液数据逻辑删除
	*/
	public abstract void logicDelete(OpInfuseDtDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OpInfuseDtDO[] enableWithoutFilter(OpInfuseDtDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OpInfuseDtDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OpInfuseDtDO[] disableVOWithoutFilter(OpInfuseDtDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OpInfuseDtDO[] aggdos) throws BizException ;
	
}
