package iih.pmp.pay.ord.i;

import xap.mw.core.data.BizException;
import iih.pmp.pay.ord.d.OrdDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 订单数据维护服务
*/
public interface IOrdCudService {
	/**
	*  订单数据真删除
	*/
    public abstract void delete(OrdDO[] aggdos) throws BizException;
    
    /**
	*  订单数据插入保存
	*/
	public abstract OrdDO[] insert(OrdDO[] aggdos) throws BizException;
	
    /**
	*  订单数据保存
	*/
	public abstract OrdDO[] save(OrdDO[] aggdos) throws BizException;
	
    /**
	*  订单数据更新
	*/
	public abstract OrdDO[] update(OrdDO[] aggdos) throws BizException;
	
	/**
	*  订单数据逻辑删除
	*/
	public abstract void logicDelete(OrdDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OrdDO[] enableWithoutFilter(OrdDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OrdDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OrdDO[] disableVOWithoutFilter(OrdDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OrdDO[] dos) throws BizException ;
}
