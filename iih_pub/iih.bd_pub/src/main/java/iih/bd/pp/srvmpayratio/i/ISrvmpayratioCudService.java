package iih.bd.pp.srvmpayratio.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.srvmpayratio.d.SrvMPayRatioDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保计划_服务多支付比例数据维护服务
*/
public interface ISrvmpayratioCudService {
	/**
	*  医保计划_服务多支付比例数据真删除
	*/
    public abstract void delete(SrvMPayRatioDO[] aggdos) throws BizException;
    
    /**
	*  医保计划_服务多支付比例数据插入保存
	*/
	public abstract SrvMPayRatioDO[] insert(SrvMPayRatioDO[] aggdos) throws BizException;
	
    /**
	*  医保计划_服务多支付比例数据保存
	*/
	public abstract SrvMPayRatioDO[] save(SrvMPayRatioDO[] aggdos) throws BizException;
	
    /**
	*  医保计划_服务多支付比例数据更新
	*/
	public abstract SrvMPayRatioDO[] update(SrvMPayRatioDO[] aggdos) throws BizException;
	
	/**
	*  医保计划_服务多支付比例数据逻辑删除
	*/
	public abstract void logicDelete(SrvMPayRatioDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SrvMPayRatioDO[] enableWithoutFilter(SrvMPayRatioDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SrvMPayRatioDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SrvMPayRatioDO[] disableVOWithoutFilter(SrvMPayRatioDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SrvMPayRatioDO[] dos) throws BizException ;
}
