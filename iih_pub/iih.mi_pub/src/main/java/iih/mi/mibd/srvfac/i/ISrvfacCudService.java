package iih.mi.mibd.srvfac.i;

import xap.mw.core.data.BizException;
import iih.mi.mibd.srvfac.d.SrvfacDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保平台_服务设施数据维护服务
*/
public interface ISrvfacCudService {
	/**
	*  医保平台_服务设施数据真删除
	*/
    public abstract void delete(SrvfacDO[] aggdos) throws BizException;
    
    /**
	*  医保平台_服务设施数据插入保存
	*/
	public abstract SrvfacDO[] insert(SrvfacDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_服务设施数据保存
	*/
	public abstract SrvfacDO[] save(SrvfacDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_服务设施数据更新
	*/
	public abstract SrvfacDO[] update(SrvfacDO[] aggdos) throws BizException;
	
	/**
	*  医保平台_服务设施数据逻辑删除
	*/
	public abstract void logicDelete(SrvfacDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SrvfacDO[] enableWithoutFilter(SrvfacDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SrvfacDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SrvfacDO[] disableVOWithoutFilter(SrvfacDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SrvfacDO[] dos) throws BizException ;
}
