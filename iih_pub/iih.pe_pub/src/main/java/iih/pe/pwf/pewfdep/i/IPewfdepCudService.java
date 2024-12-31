package iih.pe.pwf.pewfdep.i;

import xap.mw.core.data.BizException;
import iih.pe.pwf.pewfdep.d.PeWfDepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检登记科室数据维护服务
*/
public interface IPewfdepCudService {
	/**
	*  体检登记科室数据真删除
	*/
    public abstract void delete(PeWfDepDO[] aggdos) throws BizException;
    
    /**
	*  体检登记科室数据插入保存
	*/
	public abstract PeWfDepDO[] insert(PeWfDepDO[] aggdos) throws BizException;
	
    /**
	*  体检登记科室数据保存
	*/
	public abstract PeWfDepDO[] save(PeWfDepDO[] aggdos) throws BizException;
	
    /**
	*  体检登记科室数据更新
	*/
	public abstract PeWfDepDO[] update(PeWfDepDO[] aggdos) throws BizException;
	
	/**
	*  体检登记科室数据逻辑删除
	*/
	public abstract void logicDelete(PeWfDepDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeWfDepDO[] enableWithoutFilter(PeWfDepDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeWfDepDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeWfDepDO[] disableVOWithoutFilter(PeWfDepDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeWfDepDO[] dos) throws BizException ;
}
