package iih.pe.phm.pehmfollowup.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pehmfollowup.d.PeHmFollowupDO;
import iih.pe.phm.pehmfollowup.d.PehmfollowupAggDO;

/**
* 健康管理随访记录数据维护服务
*/
public interface IPehmfollowupCudService {
	/**
	*  健康管理随访记录数据真删除
	*/
    public abstract void delete(PehmfollowupAggDO[] aggdos) throws BizException;
    
    /**
	*  健康管理随访记录数据插入保存
	*/
	public abstract PehmfollowupAggDO[] insert(PehmfollowupAggDO[] aggdos) throws BizException;
	
    /**
	*  健康管理随访记录数据保存
	*/
	public abstract PehmfollowupAggDO[] save(PehmfollowupAggDO[] aggdos) throws BizException;
	
    /**
	*  健康管理随访记录数据更新
	*/
	public abstract PehmfollowupAggDO[] update(PehmfollowupAggDO[] aggdos) throws BizException;
	
	/**
	*  健康管理随访记录数据逻辑删除
	*/
	public abstract void logicDelete(PehmfollowupAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对健康管理随访记录数据真删除
	 */
	public abstract void deleteByParentDO(PeHmFollowupDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对健康管理随访记录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeHmFollowupDO[] mainDos) throws BizException;
}
