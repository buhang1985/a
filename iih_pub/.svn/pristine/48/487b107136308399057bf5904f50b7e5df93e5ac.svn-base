package iih.pe.pds.pedsdiag.i;

import xap.mw.core.data.BizException;
import iih.pe.pds.pedsdiag.d.PeDsDiagDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检诊断决策支持数据维护服务
*/
public interface IPeDsDiagDOCudService {
	/**
	*  体检诊断决策支持数据真删除
	*/
    public abstract void delete(PeDsDiagDO[] aggdos) throws BizException;
    
    /**
	*  体检诊断决策支持数据插入保存
	*/
	public abstract PeDsDiagDO[] insert(PeDsDiagDO[] aggdos) throws BizException;
	
    /**
	*  体检诊断决策支持数据保存
	*/
	public abstract PeDsDiagDO[] save(PeDsDiagDO[] aggdos) throws BizException;
	
    /**
	*  体检诊断决策支持数据更新
	*/
	public abstract PeDsDiagDO[] update(PeDsDiagDO[] aggdos) throws BizException;
	
	/**
	*  体检诊断决策支持数据逻辑删除
	*/
	public abstract void logicDelete(PeDsDiagDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeDsDiagDO[] enableWithoutFilter(PeDsDiagDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeDsDiagDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeDsDiagDO[] disableVOWithoutFilter(PeDsDiagDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeDsDiagDO[] aggdos) throws BizException ;
	
}
