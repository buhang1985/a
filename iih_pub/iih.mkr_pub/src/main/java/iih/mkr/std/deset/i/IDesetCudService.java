package iih.mkr.std.deset.i;

import xap.mw.core.data.BizException;
import iih.mkr.std.deset.d.DeDataSetDO;
import iih.mkr.std.deset.d.DesetAggDO;

/**
* 数据集数据维护服务
*/
public interface IDesetCudService {
	/**
	*  数据集数据真删除
	*/
    public abstract void delete(DesetAggDO[] aggdos) throws BizException;
    
    /**
	*  数据集数据插入保存
	*/
	public abstract DesetAggDO[] insert(DesetAggDO[] aggdos) throws BizException;
	
    /**
	*  数据集数据保存
	*/
	public abstract DesetAggDO[] save(DesetAggDO[] aggdos) throws BizException;
	
    /**
	*  数据集数据更新
	*/
	public abstract DesetAggDO[] update(DesetAggDO[] aggdos) throws BizException;
	
	/**
	*  数据集数据逻辑删除
	*/
	public abstract void logicDelete(DesetAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对数据集数据真删除
	 */
	public abstract void deleteByParentDO(DeDataSetDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对数据集数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(DeDataSetDO[] mainDos) throws BizException;
}
