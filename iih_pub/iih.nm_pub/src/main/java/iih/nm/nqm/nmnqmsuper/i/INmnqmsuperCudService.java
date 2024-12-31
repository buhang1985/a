package iih.nm.nqm.nmnqmsuper.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nmnqmsuper.d.NmNqmSuperDO;
import iih.nm.nqm.nmnqmsuper.d.NmnqmsuperAggDO;

/**
* 护理管理_督导项数据维护服务
*/
public interface INmnqmsuperCudService {
	/**
	*  护理管理_督导项数据真删除
	*/
    public abstract void delete(NmnqmsuperAggDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_督导项数据插入保存
	*/
	public abstract NmnqmsuperAggDO[] insert(NmnqmsuperAggDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_督导项数据保存
	*/
	public abstract NmnqmsuperAggDO[] save(NmnqmsuperAggDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_督导项数据更新
	*/
	public abstract NmnqmsuperAggDO[] update(NmnqmsuperAggDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_督导项数据逻辑删除
	*/
	public abstract void logicDelete(NmnqmsuperAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护理管理_督导项数据真删除
	 */
	public abstract void deleteByParentDO(NmNqmSuperDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护理管理_督导项数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmNqmSuperDO[] mainDos) throws BizException;
}
