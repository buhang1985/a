package iih.mp.mpbd.mpskdfun.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.mpskdfun.d.MpSkdFunDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理任务执行功能数据维护服务
*/
public interface IMpskdfunCudService {
	/**
	*  护理任务执行功能数据真删除
	*/
    public abstract void delete(MpSkdFunDO[] aggdos) throws BizException;
    
    /**
	*  护理任务执行功能数据插入保存
	*/
	public abstract MpSkdFunDO[] insert(MpSkdFunDO[] aggdos) throws BizException;
	
    /**
	*  护理任务执行功能数据保存
	*/
	public abstract MpSkdFunDO[] save(MpSkdFunDO[] aggdos) throws BizException;
	
    /**
	*  护理任务执行功能数据更新
	*/
	public abstract MpSkdFunDO[] update(MpSkdFunDO[] aggdos) throws BizException;
	
	/**
	*  护理任务执行功能数据逻辑删除
	*/
	public abstract void logicDelete(MpSkdFunDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpSkdFunDO[] enableWithoutFilter(MpSkdFunDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpSkdFunDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpSkdFunDO[] disableVOWithoutFilter(MpSkdFunDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpSkdFunDO[] dos) throws BizException ;
}
