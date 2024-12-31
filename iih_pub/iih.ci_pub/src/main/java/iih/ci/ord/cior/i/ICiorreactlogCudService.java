package iih.ci.ord.cior.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.cior.d.CiOrReactLogDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医嘱互斥日志记录数据维护服务
*/
public interface ICiorreactlogCudService {
	/**
	*  医嘱互斥日志记录数据删除
	*/
    public abstract void delete(CiOrReactLogDO[] aggdos) throws BizException;
    
    /**
	*  医嘱互斥日志记录数据插入保存
	*/
	public abstract CiOrReactLogDO[] insert(CiOrReactLogDO[] aggdos) throws BizException;
	
    /**
	*  医嘱互斥日志记录数据保存
	*/
	public abstract CiOrReactLogDO[] save(CiOrReactLogDO[] aggdos) throws BizException;
	
    /**
	*  医嘱互斥日志记录数据更新
	*/
	public abstract CiOrReactLogDO[] update(CiOrReactLogDO[] aggdos) throws BizException;
	
	/**
	*  医嘱互斥日志记录数据真删
	*/
	public abstract void logicDelete(CiOrReactLogDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiOrReactLogDO[] enableWithoutFilter(CiOrReactLogDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiOrReactLogDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiOrReactLogDO[] disableVOWithoutFilter(CiOrReactLogDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiOrReactLogDO[] dos) throws BizException ;
}
