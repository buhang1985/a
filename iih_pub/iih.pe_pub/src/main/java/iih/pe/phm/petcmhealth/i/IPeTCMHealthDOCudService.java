package iih.pe.phm.petcmhealth.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.petcmhealth.d.PeTCMHealthDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检中医养生数据维护服务
*/
public interface IPeTCMHealthDOCudService {
	/**
	*  体检中医养生数据真删除
	*/
    public abstract void delete(PeTCMHealthDO[] aggdos) throws BizException;
    
    /**
	*  体检中医养生数据插入保存
	*/
	public abstract PeTCMHealthDO[] insert(PeTCMHealthDO[] aggdos) throws BizException;
	
    /**
	*  体检中医养生数据保存
	*/
	public abstract PeTCMHealthDO[] save(PeTCMHealthDO[] aggdos) throws BizException;
	
    /**
	*  体检中医养生数据更新
	*/
	public abstract PeTCMHealthDO[] update(PeTCMHealthDO[] aggdos) throws BizException;
	
	/**
	*  体检中医养生数据逻辑删除
	*/
	public abstract void logicDelete(PeTCMHealthDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeTCMHealthDO[] enableWithoutFilter(PeTCMHealthDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeTCMHealthDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeTCMHealthDO[] disableVOWithoutFilter(PeTCMHealthDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeTCMHealthDO[] aggdos) throws BizException ;
	
}
