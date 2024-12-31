package iih.ci.mrm.cimrfpothercatado.i;

import xap.mw.core.data.BizException;
import iih.ci.mrm.cimrfpothercatado.d.CiMrFpIntencareCataDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 病案编目其他数据维护服务
*/
public interface ICiMrFpIntencareCataDOCudService {
	/**
	*  病案编目其他数据真删除
	*/
    public abstract void delete(CiMrFpIntencareCataDO[] aggdos) throws BizException;
    
    /**
	*  病案编目其他数据插入保存
	*/
	public abstract CiMrFpIntencareCataDO[] insert(CiMrFpIntencareCataDO[] aggdos) throws BizException;
	
    /**
	*  病案编目其他数据保存
	*/
	public abstract CiMrFpIntencareCataDO[] save(CiMrFpIntencareCataDO[] aggdos) throws BizException;
	
    /**
	*  病案编目其他数据更新
	*/
	public abstract CiMrFpIntencareCataDO[] update(CiMrFpIntencareCataDO[] aggdos) throws BizException;
	
	/**
	*  病案编目其他数据逻辑删除
	*/
	public abstract void logicDelete(CiMrFpIntencareCataDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrFpIntencareCataDO[] enableWithoutFilter(CiMrFpIntencareCataDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrFpIntencareCataDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrFpIntencareCataDO[] disableVOWithoutFilter(CiMrFpIntencareCataDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrFpIntencareCataDO[] aggdos) throws BizException ;
	
}
