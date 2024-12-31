package iih.ci.rcm.catheter.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.catheter.d.CatheterDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* ICU病例监测_导管数据维护服务
*/
public interface ICatheterCudService {
	/**
	*  ICU病例监测_导管数据真删除
	*/
    public abstract void delete(CatheterDO[] aggdos) throws BizException;
    
    /**
	*  ICU病例监测_导管数据插入保存
	*/
	public abstract CatheterDO[] insert(CatheterDO[] aggdos) throws BizException;
	
    /**
	*  ICU病例监测_导管数据保存
	*/
	public abstract CatheterDO[] save(CatheterDO[] aggdos) throws BizException;
	
    /**
	*  ICU病例监测_导管数据更新
	*/
	public abstract CatheterDO[] update(CatheterDO[] aggdos) throws BizException;
	
	/**
	*  ICU病例监测_导管数据逻辑删除
	*/
	public abstract void logicDelete(CatheterDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CatheterDO[] enableWithoutFilter(CatheterDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CatheterDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CatheterDO[] disableVOWithoutFilter(CatheterDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CatheterDO[] dos) throws BizException ;
}
