package iih.bd.pp.modifypriplan.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.modifypriplan.d.ModifyPriPlanDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 调价计划数据维护服务
*/
public interface IModifypriplanMDOCudService {
	/**
	*  调价计划数据真删除
	*/
    public abstract void delete(ModifyPriPlanDO[] aggdos) throws BizException;
    
    /**
	*  调价计划数据插入保存
	*/
	public abstract ModifyPriPlanDO[] insert(ModifyPriPlanDO[] aggdos) throws BizException;
	
    /**
	*  调价计划数据保存
	*/
	public abstract ModifyPriPlanDO[] save(ModifyPriPlanDO[] aggdos) throws BizException;
	
    /**
	*  调价计划数据更新
	*/
	public abstract ModifyPriPlanDO[] update(ModifyPriPlanDO[] aggdos) throws BizException;
	
	/**
	*  调价计划数据逻辑删除
	*/
	public abstract void logicDelete(ModifyPriPlanDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ModifyPriPlanDO[] enableWithoutFilter(ModifyPriPlanDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ModifyPriPlanDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ModifyPriPlanDO[] disableVOWithoutFilter(ModifyPriPlanDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ModifyPriPlanDO[] aggdos) throws BizException ;
	
}
