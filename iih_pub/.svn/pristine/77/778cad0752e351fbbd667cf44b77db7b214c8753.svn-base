package iih.mkr.std.dedg.i;

import xap.mw.core.data.BizException;
import iih.mkr.std.dedg.d.DeDataGrpDO;
import iih.mkr.std.dedg.d.DedgAggDO;

/**
* 数据组数据维护服务
*/
public interface IDedgCudService {
	/**
	*  数据组数据真删除
	*/
    public abstract void delete(DedgAggDO[] aggdos) throws BizException;
    
    /**
	*  数据组数据插入保存
	*/
	public abstract DedgAggDO[] insert(DedgAggDO[] aggdos) throws BizException;
	
    /**
	*  数据组数据保存
	*/
	public abstract DedgAggDO[] save(DedgAggDO[] aggdos) throws BizException;
	
    /**
	*  数据组数据更新
	*/
	public abstract DedgAggDO[] update(DedgAggDO[] aggdos) throws BizException;
	
	/**
	*  数据组数据逻辑删除
	*/
	public abstract void logicDelete(DedgAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对数据组数据真删除
	 */
	public abstract void deleteByParentDO(DeDataGrpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对数据组数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(DeDataGrpDO[] mainDos) throws BizException;
}
