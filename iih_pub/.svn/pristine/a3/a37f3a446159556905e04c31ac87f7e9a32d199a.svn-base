package iih.mp.dg.ipshetp.i;

import xap.mw.core.data.BizException;
import iih.mp.dg.ipshetp.d.IpSheetTypeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 住院药单类型维护数据维护服务
*/
public interface IIpshetpCudService {
	/**
	*  住院药单类型维护数据真删除
	*/
    public abstract void delete(IpSheetTypeDO[] aggdos) throws BizException;
    
    /**
	*  住院药单类型维护数据插入保存
	*/
	public abstract IpSheetTypeDO[] insert(IpSheetTypeDO[] aggdos) throws BizException;
	
    /**
	*  住院药单类型维护数据保存
	*/
	public abstract IpSheetTypeDO[] save(IpSheetTypeDO[] aggdos) throws BizException;
	
    /**
	*  住院药单类型维护数据更新
	*/
	public abstract IpSheetTypeDO[] update(IpSheetTypeDO[] aggdos) throws BizException;
	
	/**
	*  住院药单类型维护数据逻辑删除
	*/
	public abstract void logicDelete(IpSheetTypeDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public IpSheetTypeDO[] enableWithoutFilter(IpSheetTypeDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(IpSheetTypeDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public IpSheetTypeDO[] disableVOWithoutFilter(IpSheetTypeDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(IpSheetTypeDO[] dos) throws BizException ;
}
