package iih.bd.fc.orpltp.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.orpltp.d.OrpltpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医嘱执行计划状态数据维护服务
*/
public interface IOrpltpMDOCudService {
	/**
	*  医嘱执行计划状态数据真删除
	*/
    public abstract void delete(OrpltpDO[] aggdos) throws BizException;
    
    /**
	*  医嘱执行计划状态数据插入保存
	*/
	public abstract OrpltpDO[] insert(OrpltpDO[] aggdos) throws BizException;
	
    /**
	*  医嘱执行计划状态数据保存
	*/
	public abstract OrpltpDO[] save(OrpltpDO[] aggdos) throws BizException;
	
    /**
	*  医嘱执行计划状态数据更新
	*/
	public abstract OrpltpDO[] update(OrpltpDO[] aggdos) throws BizException;
	
	/**
	*  医嘱执行计划状态数据逻辑删除
	*/
	public abstract void logicDelete(OrpltpDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OrpltpDO[] enableWithoutFilter(OrpltpDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OrpltpDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OrpltpDO[] disableVOWithoutFilter(OrpltpDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OrpltpDO[] aggdos) throws BizException ;
	
}
