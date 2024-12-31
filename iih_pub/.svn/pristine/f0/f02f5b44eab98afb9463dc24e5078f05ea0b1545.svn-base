package iih.bd.pp.primd.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.primd.d.PrimdDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 定价模式数据维护服务
*/
public interface IPrimdCudService {
	/**
	*  定价模式数据真删除
	*/
    public abstract void delete(PrimdDO[] aggdos) throws BizException;
    
    /**
	*  定价模式数据插入保存
	*/
	public abstract PrimdDO[] insert(PrimdDO[] aggdos) throws BizException;
	
    /**
	*  定价模式数据保存
	*/
	public abstract PrimdDO[] save(PrimdDO[] aggdos) throws BizException;
	
    /**
	*  定价模式数据更新
	*/
	public abstract PrimdDO[] update(PrimdDO[] aggdos) throws BizException;
	
	/**
	*  定价模式数据逻辑删除
	*/
	public abstract void logicDelete(PrimdDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PrimdDO[] enableWithoutFilter(PrimdDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PrimdDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PrimdDO[] disableVOWithoutFilter(PrimdDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PrimdDO[] dos) throws BizException ;
}
