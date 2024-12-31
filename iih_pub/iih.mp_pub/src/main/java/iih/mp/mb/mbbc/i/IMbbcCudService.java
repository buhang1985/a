package iih.mp.mb.mbbc.i;

import xap.mw.core.data.BizException;
import iih.mp.mb.mbbc.d.MbBcDO;
import iih.mp.mb.mbbc.d.MbbcAggDO;

/**
* 条码对照数据维护服务
*/
public interface IMbbcCudService {
	/**
	*  条码对照数据真删除
	*/
    public abstract void delete(MbbcAggDO[] aggdos) throws BizException;
    
    /**
	*  条码对照数据插入保存
	*/
	public abstract MbbcAggDO[] insert(MbbcAggDO[] aggdos) throws BizException;
	
    /**
	*  条码对照数据保存
	*/
	public abstract MbbcAggDO[] save(MbbcAggDO[] aggdos) throws BizException;
	
    /**
	*  条码对照数据更新
	*/
	public abstract MbbcAggDO[] update(MbbcAggDO[] aggdos) throws BizException;
	
	/**
	*  条码对照数据逻辑删除
	*/
	public abstract void logicDelete(MbbcAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对条码对照数据真删除
	 */
	public abstract void deleteByParentDO(MbBcDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对条码对照数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MbBcDO[] mainDos) throws BizException;
}
