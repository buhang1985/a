package iih.mp.nr.crisisval.i;

import xap.mw.core.data.BizException;
import iih.mp.nr.crisisval.d.CrisisValDO;
import iih.mp.nr.crisisval.d.CrisisvalAggDO;

/**
* 危急值数据维护服务
*/
public interface ICrisisvalCudService {
	/**
	*  危急值数据真删除
	*/
    public abstract void delete(CrisisvalAggDO[] aggdos) throws BizException;
    
    /**
	*  危急值数据插入保存
	*/
	public abstract CrisisvalAggDO[] insert(CrisisvalAggDO[] aggdos) throws BizException;
	
    /**
	*  危急值数据保存
	*/
	public abstract CrisisvalAggDO[] save(CrisisvalAggDO[] aggdos) throws BizException;
	
    /**
	*  危急值数据更新
	*/
	public abstract CrisisvalAggDO[] update(CrisisvalAggDO[] aggdos) throws BizException;
	
	/**
	*  危急值数据逻辑删除
	*/
	public abstract void logicDelete(CrisisvalAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对危急值数据真删除
	 */
	public abstract void deleteByParentDO(CrisisValDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对危急值数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CrisisValDO[] mainDos) throws BizException;
}
