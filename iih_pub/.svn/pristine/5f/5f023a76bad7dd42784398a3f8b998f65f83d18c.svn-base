package iih.ci.rcm.infectionoutbreakreport.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.infectionoutbreakreport.d.InfectionOutbreakReportDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医院感染暴发报告登记表数据维护服务
*/
public interface IInfectionoutbreakreportMDOCudService {
	/**
	*  医院感染暴发报告登记表数据真删除
	*/
    public abstract void delete(InfectionOutbreakReportDO[] aggdos) throws BizException;
    
    /**
	*  医院感染暴发报告登记表数据插入保存
	*/
	public abstract InfectionOutbreakReportDO[] insert(InfectionOutbreakReportDO[] aggdos) throws BizException;
	
    /**
	*  医院感染暴发报告登记表数据保存
	*/
	public abstract InfectionOutbreakReportDO[] save(InfectionOutbreakReportDO[] aggdos) throws BizException;
	
    /**
	*  医院感染暴发报告登记表数据更新
	*/
	public abstract InfectionOutbreakReportDO[] update(InfectionOutbreakReportDO[] aggdos) throws BizException;
	
	/**
	*  医院感染暴发报告登记表数据逻辑删除
	*/
	public abstract void logicDelete(InfectionOutbreakReportDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public InfectionOutbreakReportDO[] enableWithoutFilter(InfectionOutbreakReportDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(InfectionOutbreakReportDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public InfectionOutbreakReportDO[] disableVOWithoutFilter(InfectionOutbreakReportDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(InfectionOutbreakReportDO[] aggdos) throws BizException ;
	
}
