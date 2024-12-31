package iih.ci.rcm.trackafterexposure.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.trackafterexposure.d.TrackAfterExposureDO;
import iih.ci.rcm.trackafterexposure.d.TrackafterexposureAggDO;

/**
* 暴露后追踪记录登记表数据维护服务
*/
public interface ITrackafterexposureCudService {
	/**
	*  暴露后追踪记录登记表数据真删除
	*/
    public abstract void delete(TrackafterexposureAggDO[] aggdos) throws BizException;
    
    /**
	*  暴露后追踪记录登记表数据插入保存
	*/
	public abstract TrackafterexposureAggDO[] insert(TrackafterexposureAggDO[] aggdos) throws BizException;
	
    /**
	*  暴露后追踪记录登记表数据保存
	*/
	public abstract TrackafterexposureAggDO[] save(TrackafterexposureAggDO[] aggdos) throws BizException;
	
    /**
	*  暴露后追踪记录登记表数据更新
	*/
	public abstract TrackafterexposureAggDO[] update(TrackafterexposureAggDO[] aggdos) throws BizException;
	
	/**
	*  暴露后追踪记录登记表数据逻辑删除
	*/
	public abstract void logicDelete(TrackafterexposureAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对暴露后追踪记录登记表数据真删除
	 */
	public abstract void deleteByParentDO(TrackAfterExposureDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对暴露后追踪记录登记表数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(TrackAfterExposureDO[] mainDos) throws BizException;
}
