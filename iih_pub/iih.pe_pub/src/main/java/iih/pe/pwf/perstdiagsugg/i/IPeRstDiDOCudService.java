package iih.pe.pwf.perstdiagsugg.i;

import xap.mw.core.data.BizException;
import iih.pe.pwf.perstdiagsugg.d.PeRstDiDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检结果诊断建议数据维护服务
*/
public interface IPeRstDiDOCudService {
	/**
	*  体检结果诊断建议数据真删除
	*/
    public abstract void delete(PeRstDiDO[] aggdos) throws BizException;
    
    /**
	*  体检结果诊断建议数据插入保存
	*/
	public abstract PeRstDiDO[] insert(PeRstDiDO[] aggdos) throws BizException;
	
    /**
	*  体检结果诊断建议数据保存
	*/
	public abstract PeRstDiDO[] save(PeRstDiDO[] aggdos) throws BizException;
	
    /**
	*  体检结果诊断建议数据更新
	*/
	public abstract PeRstDiDO[] update(PeRstDiDO[] aggdos) throws BizException;
	
	/**
	*  体检结果诊断建议数据逻辑删除
	*/
	public abstract void logicDelete(PeRstDiDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeRstDiDO[] enableWithoutFilter(PeRstDiDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeRstDiDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeRstDiDO[] disableVOWithoutFilter(PeRstDiDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeRstDiDO[] aggdos) throws BizException ;
	
}