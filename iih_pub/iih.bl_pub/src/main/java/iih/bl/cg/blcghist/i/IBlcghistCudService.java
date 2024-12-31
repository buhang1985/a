package iih.bl.cg.blcghist.i;

import xap.mw.core.data.BizException;
import iih.bl.cg.blcghist.d.BlCgIpHistDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 住院记账自费标识修改历史数据维护服务
*/
public interface IBlcghistCudService {
	/**
	*  住院记账自费标识修改历史数据真删除
	*/
    public abstract void delete(BlCgIpHistDO[] aggdos) throws BizException;
    
    /**
	*  住院记账自费标识修改历史数据插入保存
	*/
	public abstract BlCgIpHistDO[] insert(BlCgIpHistDO[] aggdos) throws BizException;
	
    /**
	*  住院记账自费标识修改历史数据保存
	*/
	public abstract BlCgIpHistDO[] save(BlCgIpHistDO[] aggdos) throws BizException;
	
    /**
	*  住院记账自费标识修改历史数据更新
	*/
	public abstract BlCgIpHistDO[] update(BlCgIpHistDO[] aggdos) throws BizException;
	
	/**
	*  住院记账自费标识修改历史数据逻辑删除
	*/
	public abstract void logicDelete(BlCgIpHistDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlCgIpHistDO[] enableWithoutFilter(BlCgIpHistDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlCgIpHistDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlCgIpHistDO[] disableVOWithoutFilter(BlCgIpHistDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlCgIpHistDO[] dos) throws BizException ;
}
