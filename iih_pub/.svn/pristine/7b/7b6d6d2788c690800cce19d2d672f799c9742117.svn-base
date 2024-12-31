package iih.ci.rcm.trackafterexposure.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.trackafterexposure.d.TrackCheckResAfExpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 暴露后追踪记录登记表数据维护服务
*/
public interface ITrackCheckResAfExpDOCudService {
	/**
	*  暴露后追踪记录登记表数据真删除
	*/
    public abstract void delete(TrackCheckResAfExpDO[] aggdos) throws BizException;
    
    /**
	*  暴露后追踪记录登记表数据插入保存
	*/
	public abstract TrackCheckResAfExpDO[] insert(TrackCheckResAfExpDO[] aggdos) throws BizException;
	
    /**
	*  暴露后追踪记录登记表数据保存
	*/
	public abstract TrackCheckResAfExpDO[] save(TrackCheckResAfExpDO[] aggdos) throws BizException;
	
    /**
	*  暴露后追踪记录登记表数据更新
	*/
	public abstract TrackCheckResAfExpDO[] update(TrackCheckResAfExpDO[] aggdos) throws BizException;
	
	/**
	*  暴露后追踪记录登记表数据逻辑删除
	*/
	public abstract void logicDelete(TrackCheckResAfExpDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public TrackCheckResAfExpDO[] enableWithoutFilter(TrackCheckResAfExpDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(TrackCheckResAfExpDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public TrackCheckResAfExpDO[] disableVOWithoutFilter(TrackCheckResAfExpDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(TrackCheckResAfExpDO[] aggdos) throws BizException ;
	
}
