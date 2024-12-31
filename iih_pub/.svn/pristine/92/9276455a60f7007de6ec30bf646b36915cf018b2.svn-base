package iih.nmr.ha.tcho.internalnur.i;

import xap.mw.core.data.BizException;
import iih.nmr.ha.tcho.internalnur.d.InternalNurDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 内科住院患者护理评估数据维护服务
*/
public interface IInternalnurCudService {
	/**
	*  内科住院患者护理评估数据真删除
	*/
    public abstract void delete(InternalNurDO[] aggdos) throws BizException;
    
    /**
	*  内科住院患者护理评估数据插入保存
	*/
	public abstract InternalNurDO[] insert(InternalNurDO[] aggdos) throws BizException;
	
    /**
	*  内科住院患者护理评估数据保存
	*/
	public abstract InternalNurDO[] save(InternalNurDO[] aggdos) throws BizException;
	
    /**
	*  内科住院患者护理评估数据更新
	*/
	public abstract InternalNurDO[] update(InternalNurDO[] aggdos) throws BizException;
	
	/**
	*  内科住院患者护理评估数据逻辑删除
	*/
	public abstract void logicDelete(InternalNurDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public InternalNurDO[] enableWithoutFilter(InternalNurDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(InternalNurDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public InternalNurDO[] disableVOWithoutFilter(InternalNurDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(InternalNurDO[] dos) throws BizException ;
}
