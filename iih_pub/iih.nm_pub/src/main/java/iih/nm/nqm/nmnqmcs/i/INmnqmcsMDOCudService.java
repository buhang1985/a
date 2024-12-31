package iih.nm.nqm.nmnqmcs.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nmnqmcs.d.NmNqmCsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 检查标准数据维护服务
*/
public interface INmnqmcsMDOCudService {
	/**
	*  检查标准数据真删除
	*/
    public abstract void delete(NmNqmCsDO[] aggdos) throws BizException;
    
    /**
	*  检查标准数据插入保存
	*/
	public abstract NmNqmCsDO[] insert(NmNqmCsDO[] aggdos) throws BizException;
	
    /**
	*  检查标准数据保存
	*/
	public abstract NmNqmCsDO[] save(NmNqmCsDO[] aggdos) throws BizException;
	
    /**
	*  检查标准数据更新
	*/
	public abstract NmNqmCsDO[] update(NmNqmCsDO[] aggdos) throws BizException;
	
	/**
	*  检查标准数据逻辑删除
	*/
	public abstract void logicDelete(NmNqmCsDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNqmCsDO[] enableWithoutFilter(NmNqmCsDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNqmCsDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNqmCsDO[] disableVOWithoutFilter(NmNqmCsDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNqmCsDO[] aggdos) throws BizException ;
	
}
