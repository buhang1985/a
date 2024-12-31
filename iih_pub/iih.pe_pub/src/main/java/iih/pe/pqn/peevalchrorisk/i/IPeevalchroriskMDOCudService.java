package iih.pe.pqn.peevalchrorisk.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.peevalchrorisk.d.PeChroRiskDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检慢病风险因素数据维护服务
*/
public interface IPeevalchroriskMDOCudService {
	/**
	*  体检慢病风险因素数据真删除
	*/
    public abstract void delete(PeChroRiskDO[] aggdos) throws BizException;
    
    /**
	*  体检慢病风险因素数据插入保存
	*/
	public abstract PeChroRiskDO[] insert(PeChroRiskDO[] aggdos) throws BizException;
	
    /**
	*  体检慢病风险因素数据保存
	*/
	public abstract PeChroRiskDO[] save(PeChroRiskDO[] aggdos) throws BizException;
	
    /**
	*  体检慢病风险因素数据更新
	*/
	public abstract PeChroRiskDO[] update(PeChroRiskDO[] aggdos) throws BizException;
	
	/**
	*  体检慢病风险因素数据逻辑删除
	*/
	public abstract void logicDelete(PeChroRiskDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeChroRiskDO[] enableWithoutFilter(PeChroRiskDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeChroRiskDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeChroRiskDO[] disableVOWithoutFilter(PeChroRiskDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeChroRiskDO[] aggdos) throws BizException ;
	
}