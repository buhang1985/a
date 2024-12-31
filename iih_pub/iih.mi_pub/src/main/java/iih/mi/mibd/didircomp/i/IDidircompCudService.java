package iih.mi.mibd.didircomp.i;

import xap.mw.core.data.BizException;
import iih.mi.mibd.didircomp.d.DidircompDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保平台_病种对照数据维护服务
*/
public interface IDidircompCudService {
	/**
	*  医保平台_病种对照数据真删除
	*/
    public abstract void delete(DidircompDO[] aggdos) throws BizException;
    
    /**
	*  医保平台_病种对照数据插入保存
	*/
	public abstract DidircompDO[] insert(DidircompDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_病种对照数据保存
	*/
	public abstract DidircompDO[] save(DidircompDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_病种对照数据更新
	*/
	public abstract DidircompDO[] update(DidircompDO[] aggdos) throws BizException;
	
	/**
	*  医保平台_病种对照数据逻辑删除
	*/
	public abstract void logicDelete(DidircompDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DidircompDO[] enableWithoutFilter(DidircompDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DidircompDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DidircompDO[] disableVOWithoutFilter(DidircompDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DidircompDO[] dos) throws BizException ;
}
