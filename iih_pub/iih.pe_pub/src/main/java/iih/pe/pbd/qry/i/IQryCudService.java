package iih.pe.pbd.qry.i;

import xap.mw.core.data.BizException;
import iih.pe.pbd.qry.d.QryDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 自助查询数据维护服务
*/
public interface IQryCudService {
	/**
	*  自助查询数据真删除
	*/
    public abstract void delete(QryDO[] aggdos) throws BizException;
    
    /**
	*  自助查询数据插入保存
	*/
	public abstract QryDO[] insert(QryDO[] aggdos) throws BizException;
	
    /**
	*  自助查询数据保存
	*/
	public abstract QryDO[] save(QryDO[] aggdos) throws BizException;
	
    /**
	*  自助查询数据更新
	*/
	public abstract QryDO[] update(QryDO[] aggdos) throws BizException;
	
	/**
	*  自助查询数据逻辑删除
	*/
	public abstract void logicDelete(QryDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public QryDO[] enableWithoutFilter(QryDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(QryDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public QryDO[] disableVOWithoutFilter(QryDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(QryDO[] dos) throws BizException ;
}
