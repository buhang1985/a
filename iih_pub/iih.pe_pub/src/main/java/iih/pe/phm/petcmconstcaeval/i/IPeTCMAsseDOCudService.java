package iih.pe.phm.petcmconstcaeval.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.petcmconstcaeval.d.PeTCMAsseDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检中医体质评估数据维护服务
*/
public interface IPeTCMAsseDOCudService {
	/**
	*  体检中医体质评估数据真删除
	*/
    public abstract void delete(PeTCMAsseDO[] aggdos) throws BizException;
    
    /**
	*  体检中医体质评估数据插入保存
	*/
	public abstract PeTCMAsseDO[] insert(PeTCMAsseDO[] aggdos) throws BizException;
	
    /**
	*  体检中医体质评估数据保存
	*/
	public abstract PeTCMAsseDO[] save(PeTCMAsseDO[] aggdos) throws BizException;
	
    /**
	*  体检中医体质评估数据更新
	*/
	public abstract PeTCMAsseDO[] update(PeTCMAsseDO[] aggdos) throws BizException;
	
	/**
	*  体检中医体质评估数据逻辑删除
	*/
	public abstract void logicDelete(PeTCMAsseDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeTCMAsseDO[] enableWithoutFilter(PeTCMAsseDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeTCMAsseDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeTCMAsseDO[] disableVOWithoutFilter(PeTCMAsseDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeTCMAsseDO[] aggdos) throws BizException ;
	
}
