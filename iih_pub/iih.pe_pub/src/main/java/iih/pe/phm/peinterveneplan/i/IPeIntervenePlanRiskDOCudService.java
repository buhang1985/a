package iih.pe.phm.peinterveneplan.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.peinterveneplan.d.PeIntervenePlanRiskDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 健康干预个人计划数据维护服务
*/
public interface IPeIntervenePlanRiskDOCudService {
	/**
	*  健康干预个人计划数据真删除
	*/
    public abstract void delete(PeIntervenePlanRiskDO[] aggdos) throws BizException;
    
    /**
	*  健康干预个人计划数据插入保存
	*/
	public abstract PeIntervenePlanRiskDO[] insert(PeIntervenePlanRiskDO[] aggdos) throws BizException;
	
    /**
	*  健康干预个人计划数据保存
	*/
	public abstract PeIntervenePlanRiskDO[] save(PeIntervenePlanRiskDO[] aggdos) throws BizException;
	
    /**
	*  健康干预个人计划数据更新
	*/
	public abstract PeIntervenePlanRiskDO[] update(PeIntervenePlanRiskDO[] aggdos) throws BizException;
	
	/**
	*  健康干预个人计划数据逻辑删除
	*/
	public abstract void logicDelete(PeIntervenePlanRiskDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeIntervenePlanRiskDO[] enableWithoutFilter(PeIntervenePlanRiskDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeIntervenePlanRiskDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeIntervenePlanRiskDO[] disableVOWithoutFilter(PeIntervenePlanRiskDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeIntervenePlanRiskDO[] aggdos) throws BizException ;
	
}