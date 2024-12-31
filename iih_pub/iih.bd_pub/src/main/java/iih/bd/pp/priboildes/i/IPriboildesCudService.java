package iih.bd.pp.priboildes.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.priboildes.d.BdPriBoilDesDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 煎法要求费用对照数据维护服务
*/
public interface IPriboildesCudService {
	/**
	*  煎法要求费用对照数据真删除
	*/
    public abstract void delete(BdPriBoilDesDO[] aggdos) throws BizException;
    
    /**
	*  煎法要求费用对照数据插入保存
	*/
	public abstract BdPriBoilDesDO[] insert(BdPriBoilDesDO[] aggdos) throws BizException;
	
    /**
	*  煎法要求费用对照数据保存
	*/
	public abstract BdPriBoilDesDO[] save(BdPriBoilDesDO[] aggdos) throws BizException;
	
    /**
	*  煎法要求费用对照数据更新
	*/
	public abstract BdPriBoilDesDO[] update(BdPriBoilDesDO[] aggdos) throws BizException;
	
	/**
	*  煎法要求费用对照数据逻辑删除
	*/
	public abstract void logicDelete(BdPriBoilDesDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdPriBoilDesDO[] enableWithoutFilter(BdPriBoilDesDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdPriBoilDesDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdPriBoilDesDO[] disableVOWithoutFilter(BdPriBoilDesDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdPriBoilDesDO[] dos) throws BizException ;
}
