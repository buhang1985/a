package iih.sc.apt.aptoptemp.i;

import xap.mw.core.data.BizException;
import iih.sc.apt.aptoptemp.d.ScAptOptEmpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 手术人员数据维护服务
*/
public interface IAptoptempCudService {
	/**
	*  手术人员数据真删除
	*/
    public abstract void delete(ScAptOptEmpDO[] aggdos) throws BizException;
    
    /**
	*  手术人员数据插入保存
	*/
	public abstract ScAptOptEmpDO[] insert(ScAptOptEmpDO[] aggdos) throws BizException;
	
    /**
	*  手术人员数据保存
	*/
	public abstract ScAptOptEmpDO[] save(ScAptOptEmpDO[] aggdos) throws BizException;
	
    /**
	*  手术人员数据更新
	*/
	public abstract ScAptOptEmpDO[] update(ScAptOptEmpDO[] aggdos) throws BizException;
	
	/**
	*  手术人员数据逻辑删除
	*/
	public abstract void logicDelete(ScAptOptEmpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScAptOptEmpDO[] enableWithoutFilter(ScAptOptEmpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScAptOptEmpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScAptOptEmpDO[] disableVOWithoutFilter(ScAptOptEmpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScAptOptEmpDO[] dos) throws BizException ;
}
