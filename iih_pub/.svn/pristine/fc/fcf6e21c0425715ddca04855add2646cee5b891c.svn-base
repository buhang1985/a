package iih.mm.pl.trapimpl.i;

import xap.mw.core.data.BizException;
import iih.mm.pl.trapimpl.d.TrapImplDO;
import iih.mm.pl.trapimpl.d.TrapimplAggDO;

/**
* 调拨单数据维护服务
*/
public interface ITrapimplCudService {
	/**
	*  调拨单数据真删除
	*/
    public abstract void delete(TrapimplAggDO[] aggdos) throws BizException;
    
    /**
	*  调拨单数据插入保存
	*/
	public abstract TrapimplAggDO[] insert(TrapimplAggDO[] aggdos) throws BizException;
	
    /**
	*  调拨单数据保存
	*/
	public abstract TrapimplAggDO[] save(TrapimplAggDO[] aggdos) throws BizException;
	
    /**
	*  调拨单数据更新
	*/
	public abstract TrapimplAggDO[] update(TrapimplAggDO[] aggdos) throws BizException;
	
	/**
	*  调拨单数据逻辑删除
	*/
	public abstract void logicDelete(TrapimplAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对调拨单数据真删除
	 */
	public abstract void deleteByParentDO(TrapImplDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对调拨单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(TrapImplDO[] mainDos) throws BizException;
}
