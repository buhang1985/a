package iih.mi.mibd.mis.i;

import xap.mw.core.data.BizException;
import iih.mi.mibd.mis.d.MisDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保平台_医保系统数据维护服务
*/
public interface IMisCudService {
	/**
	*  医保平台_医保系统数据真删除
	*/
    public abstract void delete(MisDO[] aggdos) throws BizException;
    
    /**
	*  医保平台_医保系统数据插入保存
	*/
	public abstract MisDO[] insert(MisDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_医保系统数据保存
	*/
	public abstract MisDO[] save(MisDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_医保系统数据更新
	*/
	public abstract MisDO[] update(MisDO[] aggdos) throws BizException;
	
	/**
	*  医保平台_医保系统数据逻辑删除
	*/
	public abstract void logicDelete(MisDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MisDO[] enableWithoutFilter(MisDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MisDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MisDO[] disableVOWithoutFilter(MisDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MisDO[] dos) throws BizException ;
}
