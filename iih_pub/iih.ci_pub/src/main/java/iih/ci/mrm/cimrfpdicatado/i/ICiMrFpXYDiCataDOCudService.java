package iih.ci.mrm.cimrfpdicatado.i;

import xap.mw.core.data.BizException;
import iih.ci.mrm.cimrfpdicatado.d.CiMrFpXYDiCataDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 病案编目诊断数据维护服务
*/
public interface ICiMrFpXYDiCataDOCudService {
	/**
	*  病案编目诊断数据真删除
	*/
    public abstract void delete(CiMrFpXYDiCataDO[] aggdos) throws BizException;
    
    /**
	*  病案编目诊断数据插入保存
	*/
	public abstract CiMrFpXYDiCataDO[] insert(CiMrFpXYDiCataDO[] aggdos) throws BizException;
	
    /**
	*  病案编目诊断数据保存
	*/
	public abstract CiMrFpXYDiCataDO[] save(CiMrFpXYDiCataDO[] aggdos) throws BizException;
	
    /**
	*  病案编目诊断数据更新
	*/
	public abstract CiMrFpXYDiCataDO[] update(CiMrFpXYDiCataDO[] aggdos) throws BizException;
	
	/**
	*  病案编目诊断数据逻辑删除
	*/
	public abstract void logicDelete(CiMrFpXYDiCataDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrFpXYDiCataDO[] enableWithoutFilter(CiMrFpXYDiCataDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrFpXYDiCataDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrFpXYDiCataDO[] disableVOWithoutFilter(CiMrFpXYDiCataDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrFpXYDiCataDO[] aggdos) throws BizException ;
	
}
