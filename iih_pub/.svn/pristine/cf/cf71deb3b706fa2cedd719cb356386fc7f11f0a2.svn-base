package iih.bd.fc.orpltpstafunc.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.orpltpstafunc.d.OrpltpStaFuncDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医嘱闭环状态与功能对照数据维护服务
*/
public interface IOrpltpstafuncCudService {
	/**
	*  医嘱闭环状态与功能对照数据真删除
	*/
    public abstract void delete(OrpltpStaFuncDO[] aggdos) throws BizException;
    
    /**
	*  医嘱闭环状态与功能对照数据插入保存
	*/
	public abstract OrpltpStaFuncDO[] insert(OrpltpStaFuncDO[] aggdos) throws BizException;
	
    /**
	*  医嘱闭环状态与功能对照数据保存
	*/
	public abstract OrpltpStaFuncDO[] save(OrpltpStaFuncDO[] aggdos) throws BizException;
	
    /**
	*  医嘱闭环状态与功能对照数据更新
	*/
	public abstract OrpltpStaFuncDO[] update(OrpltpStaFuncDO[] aggdos) throws BizException;
	
	/**
	*  医嘱闭环状态与功能对照数据逻辑删除
	*/
	public abstract void logicDelete(OrpltpStaFuncDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OrpltpStaFuncDO[] enableWithoutFilter(OrpltpStaFuncDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OrpltpStaFuncDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OrpltpStaFuncDO[] disableVOWithoutFilter(OrpltpStaFuncDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OrpltpStaFuncDO[] dos) throws BizException ;
}
