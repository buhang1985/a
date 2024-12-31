package iih.bd.pp.bdprewarn.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.bdprewarn.d.BdPreWarnItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 预交金警告策略数据维护服务
*/
public interface IBdPreWarnItmDOCudService {
	/**
	*  预交金警告策略数据真删除
	*/
    public abstract void delete(BdPreWarnItmDO[] aggdos) throws BizException;
    
    /**
	*  预交金警告策略数据插入保存
	*/
	public abstract BdPreWarnItmDO[] insert(BdPreWarnItmDO[] aggdos) throws BizException;
	
    /**
	*  预交金警告策略数据保存
	*/
	public abstract BdPreWarnItmDO[] save(BdPreWarnItmDO[] aggdos) throws BizException;
	
    /**
	*  预交金警告策略数据更新
	*/
	public abstract BdPreWarnItmDO[] update(BdPreWarnItmDO[] aggdos) throws BizException;
	
	/**
	*  预交金警告策略数据逻辑删除
	*/
	public abstract void logicDelete(BdPreWarnItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdPreWarnItmDO[] enableWithoutFilter(BdPreWarnItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdPreWarnItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdPreWarnItmDO[] disableVOWithoutFilter(BdPreWarnItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdPreWarnItmDO[] aggdos) throws BizException ;
	
}
