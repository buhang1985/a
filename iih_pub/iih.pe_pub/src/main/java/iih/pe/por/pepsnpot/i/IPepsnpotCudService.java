package iih.pe.por.pepsnpot.i;

import xap.mw.core.data.BizException;
import iih.pe.por.pepsnpot.d.PePsnPotDO;
import iih.pe.por.pepsnpot.d.PepsnpotAggDO;

/**
* 体检潜在客户数据维护服务
*/
public interface IPepsnpotCudService {
	/**
	*  体检潜在客户数据真删除
	*/
    public abstract void delete(PepsnpotAggDO[] aggdos) throws BizException;
    
    /**
	*  体检潜在客户数据插入保存
	*/
	public abstract PepsnpotAggDO[] insert(PepsnpotAggDO[] aggdos) throws BizException;
	
    /**
	*  体检潜在客户数据保存
	*/
	public abstract PepsnpotAggDO[] save(PepsnpotAggDO[] aggdos) throws BizException;
	
    /**
	*  体检潜在客户数据更新
	*/
	public abstract PepsnpotAggDO[] update(PepsnpotAggDO[] aggdos) throws BizException;
	
	/**
	*  体检潜在客户数据逻辑删除
	*/
	public abstract void logicDelete(PepsnpotAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检潜在客户数据真删除
	 */
	public abstract void deleteByParentDO(PePsnPotDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检潜在客户数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PePsnPotDO[] mainDos) throws BizException;
}
