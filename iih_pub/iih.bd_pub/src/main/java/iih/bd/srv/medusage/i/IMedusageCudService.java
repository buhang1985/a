package iih.bd.srv.medusage.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.medusage.d.MedUsageDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 用法数据维护服务
*/
public interface IMedusageCudService {
	/**
	*  用法数据真删除
	*/
    public abstract void delete(MedUsageDO[] aggdos) throws BizException;
    
    /**
	*  用法数据插入保存
	*/
	public abstract MedUsageDO[] insert(MedUsageDO[] aggdos) throws BizException;
	
    /**
	*  用法数据保存
	*/
	public abstract MedUsageDO[] save(MedUsageDO[] aggdos) throws BizException;
	
    /**
	*  用法数据更新
	*/
	public abstract MedUsageDO[] update(MedUsageDO[] aggdos) throws BizException;
	
	/**
	*  用法数据逻辑删除
	*/
	public abstract void logicDelete(MedUsageDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MedUsageDO[] enableWithoutFilter(MedUsageDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MedUsageDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MedUsageDO[] disableVOWithoutFilter(MedUsageDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MedUsageDO[] dos) throws BizException ;
}
