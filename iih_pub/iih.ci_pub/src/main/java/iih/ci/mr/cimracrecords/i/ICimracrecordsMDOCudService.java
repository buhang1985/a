package iih.ci.mr.cimracrecords.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.cimracrecords.d.CiMrACBaseDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 产程数据记录数据维护服务
*/
public interface ICimracrecordsMDOCudService {
	/**
	*  产程数据记录数据真删除
	*/
    public abstract void delete(CiMrACBaseDO[] aggdos) throws BizException;
    
    /**
	*  产程数据记录数据插入保存
	*/
	public abstract CiMrACBaseDO[] insert(CiMrACBaseDO[] aggdos) throws BizException;
	
    /**
	*  产程数据记录数据保存
	*/
	public abstract CiMrACBaseDO[] save(CiMrACBaseDO[] aggdos) throws BizException;
	
    /**
	*  产程数据记录数据更新
	*/
	public abstract CiMrACBaseDO[] update(CiMrACBaseDO[] aggdos) throws BizException;
	
	/**
	*  产程数据记录数据逻辑删除
	*/
	public abstract void logicDelete(CiMrACBaseDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrACBaseDO[] enableWithoutFilter(CiMrACBaseDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrACBaseDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrACBaseDO[] disableVOWithoutFilter(CiMrACBaseDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrACBaseDO[] aggdos) throws BizException ;
	
}