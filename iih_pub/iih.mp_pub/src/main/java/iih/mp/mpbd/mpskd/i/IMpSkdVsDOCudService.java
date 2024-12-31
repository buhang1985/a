package iih.mp.mpbd.mpskd.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.mpskd.d.MpSkdVsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护理任务定义数据维护服务
*/
public interface IMpSkdVsDOCudService {
	/**
	*  护理任务定义数据真删除
	*/
    public abstract void delete(MpSkdVsDO[] aggdos) throws BizException;
    
    /**
	*  护理任务定义数据插入保存
	*/
	public abstract MpSkdVsDO[] insert(MpSkdVsDO[] aggdos) throws BizException;
	
    /**
	*  护理任务定义数据保存
	*/
	public abstract MpSkdVsDO[] save(MpSkdVsDO[] aggdos) throws BizException;
	
    /**
	*  护理任务定义数据更新
	*/
	public abstract MpSkdVsDO[] update(MpSkdVsDO[] aggdos) throws BizException;
	
	/**
	*  护理任务定义数据逻辑删除
	*/
	public abstract void logicDelete(MpSkdVsDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpSkdVsDO[] enableWithoutFilter(MpSkdVsDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpSkdVsDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpSkdVsDO[] disableVOWithoutFilter(MpSkdVsDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpSkdVsDO[] aggdos) throws BizException ;
	
}
