package iih.bd.pp.bdprewarn.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.bdprewarn.d.BdPreWarnDO;
import iih.bd.pp.bdprewarn.d.BdprewarnAggDO;

/**
* 预交金警告策略数据维护服务
*/
public interface IBdprewarnCudService {
	/**
	*  预交金警告策略数据真删除
	*/
    public abstract void delete(BdprewarnAggDO[] aggdos) throws BizException;
    
    /**
	*  预交金警告策略数据插入保存
	*/
	public abstract BdprewarnAggDO[] insert(BdprewarnAggDO[] aggdos) throws BizException;
	
    /**
	*  预交金警告策略数据保存
	*/
	public abstract BdprewarnAggDO[] save(BdprewarnAggDO[] aggdos) throws BizException;
	
    /**
	*  预交金警告策略数据更新
	*/
	public abstract BdprewarnAggDO[] update(BdprewarnAggDO[] aggdos) throws BizException;
	
	/**
	*  预交金警告策略数据逻辑删除
	*/
	public abstract void logicDelete(BdprewarnAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对预交金警告策略数据真删除
	 */
	public abstract void deleteByParentDO(BdPreWarnDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对预交金警告策略数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BdPreWarnDO[] mainDos) throws BizException;
}
