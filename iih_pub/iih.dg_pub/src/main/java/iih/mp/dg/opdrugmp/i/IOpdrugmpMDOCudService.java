package iih.mp.dg.opdrugmp.i;

import xap.mw.core.data.BizException;
import iih.mp.dg.opdrugmp.d.OpDrugExeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 门诊药品服务数据维护服务
*/
public interface IOpdrugmpMDOCudService {
	/**
	*  门诊药品服务数据真删除
	*/
    public abstract void delete(OpDrugExeDO[] aggdos) throws BizException;
    
    /**
	*  门诊药品服务数据插入保存
	*/
	public abstract OpDrugExeDO[] insert(OpDrugExeDO[] aggdos) throws BizException;
	
    /**
	*  门诊药品服务数据保存
	*/
	public abstract OpDrugExeDO[] save(OpDrugExeDO[] aggdos) throws BizException;
	
    /**
	*  门诊药品服务数据更新
	*/
	public abstract OpDrugExeDO[] update(OpDrugExeDO[] aggdos) throws BizException;
	
	/**
	*  门诊药品服务数据逻辑删除
	*/
	public abstract void logicDelete(OpDrugExeDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OpDrugExeDO[] enableWithoutFilter(OpDrugExeDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OpDrugExeDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OpDrugExeDO[] disableVOWithoutFilter(OpDrugExeDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OpDrugExeDO[] aggdos) throws BizException ;
	
}
