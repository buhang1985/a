package iih.bd.pp.cust.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.cust.d.CustDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 付款客户数据维护服务
*/
public interface ICustDOCudService {
	/**
	*  付款客户数据真删除
	*/
    public abstract void delete(CustDO[] aggdos) throws BizException;
    
    /**
	*  付款客户数据插入保存
	*/
	public abstract CustDO[] insert(CustDO[] aggdos) throws BizException;
	
    /**
	*  付款客户数据保存
	*/
	public abstract CustDO[] save(CustDO[] aggdos) throws BizException;
	
    /**
	*  付款客户数据更新
	*/
	public abstract CustDO[] update(CustDO[] aggdos) throws BizException;
	
	/**
	*  付款客户数据逻辑删除
	*/
	public abstract void logicDelete(CustDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CustDO[] enableWithoutFilter(CustDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CustDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CustDO[] disableVOWithoutFilter(CustDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CustDO[] aggdos) throws BizException ;
	
}
