package iih.pe.pds.pedsdeptime.i;

import xap.mw.core.data.BizException;
import iih.pe.pds.pedsdeptime.d.PeDsDeptimeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检科室检查时间优化数据维护服务
*/
public interface IPedsdeptimeMDOCudService {
	/**
	*  体检科室检查时间优化数据真删除
	*/
    public abstract void delete(PeDsDeptimeDO[] aggdos) throws BizException;
    
    /**
	*  体检科室检查时间优化数据插入保存
	*/
	public abstract PeDsDeptimeDO[] insert(PeDsDeptimeDO[] aggdos) throws BizException;
	
    /**
	*  体检科室检查时间优化数据保存
	*/
	public abstract PeDsDeptimeDO[] save(PeDsDeptimeDO[] aggdos) throws BizException;
	
    /**
	*  体检科室检查时间优化数据更新
	*/
	public abstract PeDsDeptimeDO[] update(PeDsDeptimeDO[] aggdos) throws BizException;
	
	/**
	*  体检科室检查时间优化数据逻辑删除
	*/
	public abstract void logicDelete(PeDsDeptimeDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeDsDeptimeDO[] enableWithoutFilter(PeDsDeptimeDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeDsDeptimeDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeDsDeptimeDO[] disableVOWithoutFilter(PeDsDeptimeDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeDsDeptimeDO[] aggdos) throws BizException ;
	
}
