package iih.mp.nr.crisisval.i;

import xap.mw.core.data.BizException;
import iih.mp.nr.crisisval.d.CrisisValObsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 危急值数据维护服务
*/
public interface ICrisisValObsDOCudService {
	/**
	*  危急值数据真删除
	*/
    public abstract void delete(CrisisValObsDO[] aggdos) throws BizException;
    
    /**
	*  危急值数据插入保存
	*/
	public abstract CrisisValObsDO[] insert(CrisisValObsDO[] aggdos) throws BizException;
	
    /**
	*  危急值数据保存
	*/
	public abstract CrisisValObsDO[] save(CrisisValObsDO[] aggdos) throws BizException;
	
    /**
	*  危急值数据更新
	*/
	public abstract CrisisValObsDO[] update(CrisisValObsDO[] aggdos) throws BizException;
	
	/**
	*  危急值数据逻辑删除
	*/
	public abstract void logicDelete(CrisisValObsDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CrisisValObsDO[] enableWithoutFilter(CrisisValObsDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CrisisValObsDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CrisisValObsDO[] disableVOWithoutFilter(CrisisValObsDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CrisisValObsDO[] aggdos) throws BizException ;
	
}
