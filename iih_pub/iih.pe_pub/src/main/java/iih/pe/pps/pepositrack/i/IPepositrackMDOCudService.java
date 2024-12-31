package iih.pe.pps.pepositrack.i;

import xap.mw.core.data.BizException;
import iih.pe.pps.pepositrack.d.PePosiTrackDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检阳性结果追踪数据维护服务
*/
public interface IPepositrackMDOCudService {
	/**
	*  体检阳性结果追踪数据真删除
	*/
    public abstract void delete(PePosiTrackDO[] aggdos) throws BizException;
    
    /**
	*  体检阳性结果追踪数据插入保存
	*/
	public abstract PePosiTrackDO[] insert(PePosiTrackDO[] aggdos) throws BizException;
	
    /**
	*  体检阳性结果追踪数据保存
	*/
	public abstract PePosiTrackDO[] save(PePosiTrackDO[] aggdos) throws BizException;
	
    /**
	*  体检阳性结果追踪数据更新
	*/
	public abstract PePosiTrackDO[] update(PePosiTrackDO[] aggdos) throws BizException;
	
	/**
	*  体检阳性结果追踪数据逻辑删除
	*/
	public abstract void logicDelete(PePosiTrackDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PePosiTrackDO[] enableWithoutFilter(PePosiTrackDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PePosiTrackDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PePosiTrackDO[] disableVOWithoutFilter(PePosiTrackDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PePosiTrackDO[] aggdos) throws BizException ;
	
}
