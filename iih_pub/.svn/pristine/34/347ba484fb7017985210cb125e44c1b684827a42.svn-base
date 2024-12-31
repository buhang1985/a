package iih.bl.vv.cpnin.i;

import xap.mw.core.data.BizException;
import iih.bl.vv.cpnin.d.BlCpnInDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 优惠券入库数据维护服务
*/
public interface ICpninCudService {
	/**
	*  优惠券入库数据真删除
	*/
    public abstract void delete(BlCpnInDO[] aggdos) throws BizException;
    
    /**
	*  优惠券入库数据插入保存
	*/
	public abstract BlCpnInDO[] insert(BlCpnInDO[] aggdos) throws BizException;
	
    /**
	*  优惠券入库数据保存
	*/
	public abstract BlCpnInDO[] save(BlCpnInDO[] aggdos) throws BizException;
	
    /**
	*  优惠券入库数据更新
	*/
	public abstract BlCpnInDO[] update(BlCpnInDO[] aggdos) throws BizException;
	
	/**
	*  优惠券入库数据逻辑删除
	*/
	public abstract void logicDelete(BlCpnInDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlCpnInDO[] enableWithoutFilter(BlCpnInDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlCpnInDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlCpnInDO[] disableVOWithoutFilter(BlCpnInDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlCpnInDO[] dos) throws BizException ;
}
