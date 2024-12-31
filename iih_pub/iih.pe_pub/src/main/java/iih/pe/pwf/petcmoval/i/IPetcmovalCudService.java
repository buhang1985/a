package iih.pe.pwf.petcmoval.i;

import xap.mw.core.data.BizException;
import iih.pe.pwf.petcmoval.d.PeTCMOvalDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检中医结论数据维护服务
*/
public interface IPetcmovalCudService {
	/**
	*  体检中医结论数据真删除
	*/
    public abstract void delete(PeTCMOvalDO[] aggdos) throws BizException;
    
    /**
	*  体检中医结论数据插入保存
	*/
	public abstract PeTCMOvalDO[] insert(PeTCMOvalDO[] aggdos) throws BizException;
	
    /**
	*  体检中医结论数据保存
	*/
	public abstract PeTCMOvalDO[] save(PeTCMOvalDO[] aggdos) throws BizException;
	
    /**
	*  体检中医结论数据更新
	*/
	public abstract PeTCMOvalDO[] update(PeTCMOvalDO[] aggdos) throws BizException;
	
	/**
	*  体检中医结论数据逻辑删除
	*/
	public abstract void logicDelete(PeTCMOvalDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeTCMOvalDO[] enableWithoutFilter(PeTCMOvalDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeTCMOvalDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeTCMOvalDO[] disableVOWithoutFilter(PeTCMOvalDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeTCMOvalDO[] dos) throws BizException ;
}