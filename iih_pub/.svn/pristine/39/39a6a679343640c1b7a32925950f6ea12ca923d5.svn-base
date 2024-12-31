package iih.ci.mr.cimrvs.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.cimrvs.d.CiMrVsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 临床生命体征测量数据维护服务
*/
public interface ICimrvsMDOCudService {
	/**
	*  临床生命体征测量数据真删除
	*/
    public abstract void delete(CiMrVsDO[] aggdos) throws BizException;
    
    /**
	*  临床生命体征测量数据插入保存
	*/
	public abstract CiMrVsDO[] insert(CiMrVsDO[] aggdos) throws BizException;
	
    /**
	*  临床生命体征测量数据保存
	*/
	public abstract CiMrVsDO[] save(CiMrVsDO[] aggdos) throws BizException;
	
    /**
	*  临床生命体征测量数据更新
	*/
	public abstract CiMrVsDO[] update(CiMrVsDO[] aggdos) throws BizException;
	
	/**
	*  临床生命体征测量数据逻辑删除
	*/
	public abstract void logicDelete(CiMrVsDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrVsDO[] enableWithoutFilter(CiMrVsDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrVsDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrVsDO[] disableVOWithoutFilter(CiMrVsDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrVsDO[] aggdos) throws BizException ;
	
}
