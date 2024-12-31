package iih.bl.cg.blcgquery.i;

import xap.mw.core.data.BizException;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 住院记账数据维护服务
*/
public interface IBlcgqueryCudService {
	/**
	*  住院记账数据真删除
	*/
    public abstract void delete(BlCgIpDO[] aggdos) throws BizException;
    
    /**
	*  住院记账数据插入保存
	*/
	public abstract BlCgIpDO[] insert(BlCgIpDO[] aggdos) throws BizException;
	
    /**
	*  住院记账数据保存
	*/
	public abstract BlCgIpDO[] save(BlCgIpDO[] aggdos) throws BizException;
	
    /**
	*  住院记账数据更新
	*/
	public abstract BlCgIpDO[] update(BlCgIpDO[] aggdos) throws BizException;
	
	/**
	*  住院记账数据逻辑删除
	*/
	public abstract void logicDelete(BlCgIpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlCgIpDO[] enableWithoutFilter(BlCgIpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlCgIpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlCgIpDO[] disableVOWithoutFilter(BlCgIpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlCgIpDO[] dos) throws BizException ;
}
