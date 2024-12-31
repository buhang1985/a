package iih.ci.ord.ciorder.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.ciorder.d.CiOrderReactDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医嘱互斥记录表数据维护服务
*/
public interface ICiorderreactCudService {
	/**
	*  医嘱互斥记录表数据真删除
	*/
    public abstract void delete(CiOrderReactDO[] aggdos) throws BizException;
    
    /**
	*  医嘱互斥记录表数据插入保存
	*/
	public abstract CiOrderReactDO[] insert(CiOrderReactDO[] aggdos) throws BizException;
	
    /**
	*  医嘱互斥记录表数据保存
	*/
	public abstract CiOrderReactDO[] save(CiOrderReactDO[] aggdos) throws BizException;
	
    /**
	*  医嘱互斥记录表数据更新
	*/
	public abstract CiOrderReactDO[] update(CiOrderReactDO[] aggdos) throws BizException;
	
	/**
	*  医嘱互斥记录表数据逻辑删除
	*/
	public abstract void logicDelete(CiOrderReactDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiOrderReactDO[] enableWithoutFilter(CiOrderReactDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiOrderReactDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiOrderReactDO[] disableVOWithoutFilter(CiOrderReactDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiOrderReactDO[] dos) throws BizException ;
}
