package iih.bd.pp.itmpaynoonline.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.itmpaynoonline.d.ItmpaynoonlineDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 非线上收费项目数据维护服务
*/
public interface IItmpaynoonlineCudService {
	/**
	*  非线上收费项目数据真删除
	*/
    public abstract void delete(ItmpaynoonlineDO[] aggdos) throws BizException;
    
    /**
	*  非线上收费项目数据插入保存
	*/
	public abstract ItmpaynoonlineDO[] insert(ItmpaynoonlineDO[] aggdos) throws BizException;
	
    /**
	*  非线上收费项目数据保存
	*/
	public abstract ItmpaynoonlineDO[] save(ItmpaynoonlineDO[] aggdos) throws BizException;
	
    /**
	*  非线上收费项目数据更新
	*/
	public abstract ItmpaynoonlineDO[] update(ItmpaynoonlineDO[] aggdos) throws BizException;
	
	/**
	*  非线上收费项目数据逻辑删除
	*/
	public abstract void logicDelete(ItmpaynoonlineDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ItmpaynoonlineDO[] enableWithoutFilter(ItmpaynoonlineDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ItmpaynoonlineDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ItmpaynoonlineDO[] disableVOWithoutFilter(ItmpaynoonlineDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ItmpaynoonlineDO[] dos) throws BizException ;
}
