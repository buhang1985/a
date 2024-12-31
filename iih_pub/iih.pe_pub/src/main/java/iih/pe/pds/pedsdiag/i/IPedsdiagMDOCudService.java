package iih.pe.pds.pedsdiag.i;

import xap.mw.core.data.BizException;
import iih.pe.pds.pedsdiag.d.PeDsDiagDefDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检诊断决策支持数据维护服务
*/
public interface IPedsdiagMDOCudService {
	/**
	*  体检诊断决策支持数据真删除
	*/
    public abstract void delete(PeDsDiagDefDO[] aggdos) throws BizException;
    
    /**
	*  体检诊断决策支持数据插入保存
	*/
	public abstract PeDsDiagDefDO[] insert(PeDsDiagDefDO[] aggdos) throws BizException;
	
    /**
	*  体检诊断决策支持数据保存
	*/
	public abstract PeDsDiagDefDO[] save(PeDsDiagDefDO[] aggdos) throws BizException;
	
    /**
	*  体检诊断决策支持数据更新
	*/
	public abstract PeDsDiagDefDO[] update(PeDsDiagDefDO[] aggdos) throws BizException;
	
	/**
	*  体检诊断决策支持数据逻辑删除
	*/
	public abstract void logicDelete(PeDsDiagDefDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeDsDiagDefDO[] enableWithoutFilter(PeDsDiagDefDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeDsDiagDefDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeDsDiagDefDO[] disableVOWithoutFilter(PeDsDiagDefDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeDsDiagDefDO[] aggdos) throws BizException ;
	
}
