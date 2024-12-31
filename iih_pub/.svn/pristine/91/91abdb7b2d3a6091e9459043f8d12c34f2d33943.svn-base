package iih.ci.mr.nu.hemodialycare.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.hemodialycare.d.HemodialycareinfoDO;
import iih.ci.mr.nu.hemodialycare.d.HemodialycaredoAggDO;

/**
* 血液透析护理记录单数据维护服务
*/
public interface IHemodialycaredoCudService {
	/**
	*  血液透析护理记录单数据真删除
	*/
    public abstract void delete(HemodialycaredoAggDO[] aggdos) throws BizException;
    
    /**
	*  血液透析护理记录单数据插入保存
	*/
	public abstract HemodialycaredoAggDO[] insert(HemodialycaredoAggDO[] aggdos) throws BizException;
	
    /**
	*  血液透析护理记录单数据保存
	*/
	public abstract HemodialycaredoAggDO[] save(HemodialycaredoAggDO[] aggdos) throws BizException;
	
    /**
	*  血液透析护理记录单数据更新
	*/
	public abstract HemodialycaredoAggDO[] update(HemodialycaredoAggDO[] aggdos) throws BizException;
	
	/**
	*  血液透析护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(HemodialycaredoAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对血液透析护理记录单数据真删除
	 */
	public abstract void deleteByParentDO(HemodialycareinfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对血液透析护理记录单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(HemodialycareinfoDO[] mainDos) throws BizException;
}
