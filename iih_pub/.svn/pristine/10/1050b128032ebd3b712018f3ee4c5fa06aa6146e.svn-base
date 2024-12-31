package iih.mi.mibd.dosage.i;

import xap.mw.core.data.BizException;
import iih.mi.mibd.dosage.d.DosageDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保平台_剂型数据维护服务
*/
public interface IDosageCudService {
	/**
	*  医保平台_剂型数据真删除
	*/
    public abstract void delete(DosageDO[] aggdos) throws BizException;
    
    /**
	*  医保平台_剂型数据插入保存
	*/
	public abstract DosageDO[] insert(DosageDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_剂型数据保存
	*/
	public abstract DosageDO[] save(DosageDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_剂型数据更新
	*/
	public abstract DosageDO[] update(DosageDO[] aggdos) throws BizException;
	
	/**
	*  医保平台_剂型数据逻辑删除
	*/
	public abstract void logicDelete(DosageDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DosageDO[] enableWithoutFilter(DosageDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DosageDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DosageDO[] disableVOWithoutFilter(DosageDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DosageDO[] dos) throws BizException ;
}
