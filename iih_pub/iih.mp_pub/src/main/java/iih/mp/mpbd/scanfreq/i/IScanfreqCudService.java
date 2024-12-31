package iih.mp.mpbd.scanfreq.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.scanfreq.d.ScanFreqDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 扫码频次统计数据维护服务
*/
public interface IScanfreqCudService {
	/**
	*  扫码频次统计数据真删除
	*/
    public abstract void delete(ScanFreqDO[] aggdos) throws BizException;
    
    /**
	*  扫码频次统计数据插入保存
	*/
	public abstract ScanFreqDO[] insert(ScanFreqDO[] aggdos) throws BizException;
	
    /**
	*  扫码频次统计数据保存
	*/
	public abstract ScanFreqDO[] save(ScanFreqDO[] aggdos) throws BizException;
	
    /**
	*  扫码频次统计数据更新
	*/
	public abstract ScanFreqDO[] update(ScanFreqDO[] aggdos) throws BizException;
	
	/**
	*  扫码频次统计数据逻辑删除
	*/
	public abstract void logicDelete(ScanFreqDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScanFreqDO[] enableWithoutFilter(ScanFreqDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScanFreqDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScanFreqDO[] disableVOWithoutFilter(ScanFreqDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScanFreqDO[] dos) throws BizException ;
}