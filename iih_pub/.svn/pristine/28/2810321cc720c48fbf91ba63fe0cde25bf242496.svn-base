package iih.pe.pbd.pewfregqueuedef.i;

import xap.mw.core.data.BizException;
import iih.pe.pbd.pewfregqueuedef.d.PeWfRegQDefDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检登记队列定义数据维护服务
*/
public interface IPewfregqueuedefCudService {
	/**
	*  体检登记队列定义数据真删除
	*/
    public abstract void delete(PeWfRegQDefDO[] aggdos) throws BizException;
    
    /**
	*  体检登记队列定义数据插入保存
	*/
	public abstract PeWfRegQDefDO[] insert(PeWfRegQDefDO[] aggdos) throws BizException;
	
    /**
	*  体检登记队列定义数据保存
	*/
	public abstract PeWfRegQDefDO[] save(PeWfRegQDefDO[] aggdos) throws BizException;
	
    /**
	*  体检登记队列定义数据更新
	*/
	public abstract PeWfRegQDefDO[] update(PeWfRegQDefDO[] aggdos) throws BizException;
	
	/**
	*  体检登记队列定义数据逻辑删除
	*/
	public abstract void logicDelete(PeWfRegQDefDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeWfRegQDefDO[] enableWithoutFilter(PeWfRegQDefDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeWfRegQDefDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeWfRegQDefDO[] disableVOWithoutFilter(PeWfRegQDefDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeWfRegQDefDO[] dos) throws BizException ;
}
