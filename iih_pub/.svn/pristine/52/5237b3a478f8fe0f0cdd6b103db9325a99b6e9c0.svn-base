package iih.ci.rcm.trackafterexposure.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.trackafterexposure.d.TrackAfterExposureDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 暴露后追踪记录登记表数据维护服务
*/
public interface ITrackafterexposureMDOCudService {
	/**
	*  暴露后追踪记录登记表数据真删除
	*/
    public abstract void delete(TrackAfterExposureDO[] aggdos) throws BizException;
    
    /**
	*  暴露后追踪记录登记表数据插入保存
	*/
	public abstract TrackAfterExposureDO[] insert(TrackAfterExposureDO[] aggdos) throws BizException;
	
    /**
	*  暴露后追踪记录登记表数据保存
	*/
	public abstract TrackAfterExposureDO[] save(TrackAfterExposureDO[] aggdos) throws BizException;
	
    /**
	*  暴露后追踪记录登记表数据更新
	*/
	public abstract TrackAfterExposureDO[] update(TrackAfterExposureDO[] aggdos) throws BizException;
	
	/**
	*  暴露后追踪记录登记表数据逻辑删除
	*/
	public abstract void logicDelete(TrackAfterExposureDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public TrackAfterExposureDO[] enableWithoutFilter(TrackAfterExposureDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(TrackAfterExposureDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public TrackAfterExposureDO[] disableVOWithoutFilter(TrackAfterExposureDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(TrackAfterExposureDO[] aggdos) throws BizException ;
	
}
