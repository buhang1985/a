package iih.syn.common.userinit.i;

import xap.mw.core.data.BizException;
import iih.syn.common.userinit.d.SYnUserInitRespDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 用户同步初始化数据维护服务
*/
public interface ISYnUserInitRespDOCudService {
	/**
	*  用户同步初始化数据真删除
	*/
    public abstract void delete(SYnUserInitRespDO[] aggdos) throws BizException;
    
    /**
	*  用户同步初始化数据插入保存
	*/
	public abstract SYnUserInitRespDO[] insert(SYnUserInitRespDO[] aggdos) throws BizException;
	
    /**
	*  用户同步初始化数据保存
	*/
	public abstract SYnUserInitRespDO[] save(SYnUserInitRespDO[] aggdos) throws BizException;
	
    /**
	*  用户同步初始化数据更新
	*/
	public abstract SYnUserInitRespDO[] update(SYnUserInitRespDO[] aggdos) throws BizException;
	
	/**
	*  用户同步初始化数据逻辑删除
	*/
	public abstract void logicDelete(SYnUserInitRespDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SYnUserInitRespDO[] enableWithoutFilter(SYnUserInitRespDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SYnUserInitRespDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SYnUserInitRespDO[] disableVOWithoutFilter(SYnUserInitRespDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SYnUserInitRespDO[] aggdos) throws BizException ;
	
}
