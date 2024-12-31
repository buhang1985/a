package iih.bd.res.depcont.i;

import xap.mw.core.data.BizException;
import iih.bd.res.depcont.d.DepContDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医技科室对照数据维护服务
*/
public interface IDepcontMDOCudService {
	/**
	*  医技科室对照数据真删除
	*/
    public abstract void delete(DepContDO[] aggdos) throws BizException;
    
    /**
	*  医技科室对照数据插入保存
	*/
	public abstract DepContDO[] insert(DepContDO[] aggdos) throws BizException;
	
    /**
	*  医技科室对照数据保存
	*/
	public abstract DepContDO[] save(DepContDO[] aggdos) throws BizException;
	
    /**
	*  医技科室对照数据更新
	*/
	public abstract DepContDO[] update(DepContDO[] aggdos) throws BizException;
	
	/**
	*  医技科室对照数据逻辑删除
	*/
	public abstract void logicDelete(DepContDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DepContDO[] enableWithoutFilter(DepContDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DepContDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DepContDO[] disableVOWithoutFilter(DepContDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DepContDO[] aggdos) throws BizException ;
	
}
