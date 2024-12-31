package iih.bd.srv.routedosage.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.routedosage.d.RouteDosageRefDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 用法关联剂型数据维护服务
*/
public interface IRoutedosageCudService {
	/**
	*  用法关联剂型数据真删除
	*/
    public abstract void delete(RouteDosageRefDO[] aggdos) throws BizException;
    
    /**
	*  用法关联剂型数据插入保存
	*/
	public abstract RouteDosageRefDO[] insert(RouteDosageRefDO[] aggdos) throws BizException;
	
    /**
	*  用法关联剂型数据保存
	*/
	public abstract RouteDosageRefDO[] save(RouteDosageRefDO[] aggdos) throws BizException;
	
    /**
	*  用法关联剂型数据更新
	*/
	public abstract RouteDosageRefDO[] update(RouteDosageRefDO[] aggdos) throws BizException;
	
	/**
	*  用法关联剂型数据逻辑删除
	*/
	public abstract void logicDelete(RouteDosageRefDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public RouteDosageRefDO[] enableWithoutFilter(RouteDosageRefDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(RouteDosageRefDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public RouteDosageRefDO[] disableVOWithoutFilter(RouteDosageRefDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(RouteDosageRefDO[] dos) throws BizException ;
}
