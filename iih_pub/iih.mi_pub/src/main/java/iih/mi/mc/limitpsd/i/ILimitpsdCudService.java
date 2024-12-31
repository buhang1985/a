package iih.mi.mc.limitpsd.i;

import xap.mw.core.data.BizException;
import iih.mi.mc.limitpsd.d.MiMcLimitPsdDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 禁止单方服务列表数据维护服务
*/
public interface ILimitpsdCudService {
	/**
	*  禁止单方服务列表数据真删除
	*/
    public abstract void delete(MiMcLimitPsdDO[] aggdos) throws BizException;
    
    /**
	*  禁止单方服务列表数据插入保存
	*/
	public abstract MiMcLimitPsdDO[] insert(MiMcLimitPsdDO[] aggdos) throws BizException;
	
    /**
	*  禁止单方服务列表数据保存
	*/
	public abstract MiMcLimitPsdDO[] save(MiMcLimitPsdDO[] aggdos) throws BizException;
	
    /**
	*  禁止单方服务列表数据更新
	*/
	public abstract MiMcLimitPsdDO[] update(MiMcLimitPsdDO[] aggdos) throws BizException;
	
	/**
	*  禁止单方服务列表数据逻辑删除
	*/
	public abstract void logicDelete(MiMcLimitPsdDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MiMcLimitPsdDO[] enableWithoutFilter(MiMcLimitPsdDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MiMcLimitPsdDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MiMcLimitPsdDO[] disableVOWithoutFilter(MiMcLimitPsdDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MiMcLimitPsdDO[] dos) throws BizException ;
}
