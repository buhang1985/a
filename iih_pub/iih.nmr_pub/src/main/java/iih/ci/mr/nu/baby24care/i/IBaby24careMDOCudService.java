package iih.ci.mr.nu.baby24care.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.baby24care.d.Baby24InfoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 新生儿24小时护理记录单数据维护服务
*/
public interface IBaby24careMDOCudService {
	/**
	*  新生儿24小时护理记录单数据真删除
	*/
    public abstract void delete(Baby24InfoDO[] aggdos) throws BizException;
    
    /**
	*  新生儿24小时护理记录单数据插入保存
	*/
	public abstract Baby24InfoDO[] insert(Baby24InfoDO[] aggdos) throws BizException;
	
    /**
	*  新生儿24小时护理记录单数据保存
	*/
	public abstract Baby24InfoDO[] save(Baby24InfoDO[] aggdos) throws BizException;
	
    /**
	*  新生儿24小时护理记录单数据更新
	*/
	public abstract Baby24InfoDO[] update(Baby24InfoDO[] aggdos) throws BizException;
	
	/**
	*  新生儿24小时护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(Baby24InfoDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public Baby24InfoDO[] enableWithoutFilter(Baby24InfoDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(Baby24InfoDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public Baby24InfoDO[] disableVOWithoutFilter(Baby24InfoDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(Baby24InfoDO[] aggdos) throws BizException ;
	
}
