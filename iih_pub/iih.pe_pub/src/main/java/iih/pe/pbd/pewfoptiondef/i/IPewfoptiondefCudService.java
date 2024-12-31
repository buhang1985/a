package iih.pe.pbd.pewfoptiondef.i;

import xap.mw.core.data.BizException;
import iih.pe.pbd.pewfoptiondef.d.PeWfOptionDefDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检流程选项定义数据维护服务
*/
public interface IPewfoptiondefCudService {
	/**
	*  体检流程选项定义数据真删除
	*/
    public abstract void delete(PeWfOptionDefDO[] aggdos) throws BizException;
    
    /**
	*  体检流程选项定义数据插入保存
	*/
	public abstract PeWfOptionDefDO[] insert(PeWfOptionDefDO[] aggdos) throws BizException;
	
    /**
	*  体检流程选项定义数据保存
	*/
	public abstract PeWfOptionDefDO[] save(PeWfOptionDefDO[] aggdos) throws BizException;
	
    /**
	*  体检流程选项定义数据更新
	*/
	public abstract PeWfOptionDefDO[] update(PeWfOptionDefDO[] aggdos) throws BizException;
	
	/**
	*  体检流程选项定义数据逻辑删除
	*/
	public abstract void logicDelete(PeWfOptionDefDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeWfOptionDefDO[] enableWithoutFilter(PeWfOptionDefDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeWfOptionDefDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeWfOptionDefDO[] disableVOWithoutFilter(PeWfOptionDefDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeWfOptionDefDO[] dos) throws BizException ;
}
