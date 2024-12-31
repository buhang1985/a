package iih.ci.rcm.infectionrate.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.infectionrate.d.InfectionSiteDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医院感染现患率数据维护服务
*/
public interface IInfectionSiteDOCudService {
	/**
	*  医院感染现患率数据真删除
	*/
    public abstract void delete(InfectionSiteDO[] aggdos) throws BizException;
    
    /**
	*  医院感染现患率数据插入保存
	*/
	public abstract InfectionSiteDO[] insert(InfectionSiteDO[] aggdos) throws BizException;
	
    /**
	*  医院感染现患率数据保存
	*/
	public abstract InfectionSiteDO[] save(InfectionSiteDO[] aggdos) throws BizException;
	
    /**
	*  医院感染现患率数据更新
	*/
	public abstract InfectionSiteDO[] update(InfectionSiteDO[] aggdos) throws BizException;
	
	/**
	*  医院感染现患率数据逻辑删除
	*/
	public abstract void logicDelete(InfectionSiteDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public InfectionSiteDO[] enableWithoutFilter(InfectionSiteDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(InfectionSiteDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public InfectionSiteDO[] disableVOWithoutFilter(InfectionSiteDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(InfectionSiteDO[] aggdos) throws BizException ;
	
}
