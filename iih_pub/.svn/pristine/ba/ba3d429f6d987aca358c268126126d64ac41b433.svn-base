package iih.pe.phm.pepsyplan.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pepsyplan.d.PePsyPlanDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检心理干预计划数据维护服务
*/
public interface IPepsyplanCudService {
	/**
	*  体检心理干预计划数据真删除
	*/
    public abstract void delete(PePsyPlanDO[] aggdos) throws BizException;
    
    /**
	*  体检心理干预计划数据插入保存
	*/
	public abstract PePsyPlanDO[] insert(PePsyPlanDO[] aggdos) throws BizException;
	
    /**
	*  体检心理干预计划数据保存
	*/
	public abstract PePsyPlanDO[] save(PePsyPlanDO[] aggdos) throws BizException;
	
    /**
	*  体检心理干预计划数据更新
	*/
	public abstract PePsyPlanDO[] update(PePsyPlanDO[] aggdos) throws BizException;
	
	/**
	*  体检心理干预计划数据逻辑删除
	*/
	public abstract void logicDelete(PePsyPlanDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PePsyPlanDO[] enableWithoutFilter(PePsyPlanDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PePsyPlanDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PePsyPlanDO[] disableVOWithoutFilter(PePsyPlanDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PePsyPlanDO[] dos) throws BizException ;
}
