package iih.ci.rcm.infectionrate.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.infectionrate.d.InfectionDiagnosisDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医院感染现患率数据维护服务
*/
public interface IInfectionDiagnosisDOCudService {
	/**
	*  医院感染现患率数据真删除
	*/
    public abstract void delete(InfectionDiagnosisDO[] aggdos) throws BizException;
    
    /**
	*  医院感染现患率数据插入保存
	*/
	public abstract InfectionDiagnosisDO[] insert(InfectionDiagnosisDO[] aggdos) throws BizException;
	
    /**
	*  医院感染现患率数据保存
	*/
	public abstract InfectionDiagnosisDO[] save(InfectionDiagnosisDO[] aggdos) throws BizException;
	
    /**
	*  医院感染现患率数据更新
	*/
	public abstract InfectionDiagnosisDO[] update(InfectionDiagnosisDO[] aggdos) throws BizException;
	
	/**
	*  医院感染现患率数据逻辑删除
	*/
	public abstract void logicDelete(InfectionDiagnosisDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public InfectionDiagnosisDO[] enableWithoutFilter(InfectionDiagnosisDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(InfectionDiagnosisDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public InfectionDiagnosisDO[] disableVOWithoutFilter(InfectionDiagnosisDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(InfectionDiagnosisDO[] aggdos) throws BizException ;
	
}
