package iih.bd.pp.pripm.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.pripm.d.PriPmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 付款方式数据维护服务
*/
public interface IPripmCudService {
	/**
	*  付款方式数据真删除
	*/
    public abstract void delete(PriPmDO[] aggdos) throws BizException;
    
    /**
	*  付款方式数据插入保存
	*/
	public abstract PriPmDO[] insert(PriPmDO[] aggdos) throws BizException;
	
    /**
	*  付款方式数据保存
	*/
	public abstract PriPmDO[] save(PriPmDO[] aggdos) throws BizException;
	
    /**
	*  付款方式数据更新
	*/
	public abstract PriPmDO[] update(PriPmDO[] aggdos) throws BizException;
	
	/**
	*  付款方式数据逻辑删除
	*/
	public abstract void logicDelete(PriPmDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PriPmDO[] enableWithoutFilter(PriPmDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PriPmDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PriPmDO[] disableVOWithoutFilter(PriPmDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PriPmDO[] dos) throws BizException ;
}
