package iih.pe.pitm.penarraterecipe.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.penarraterecipe.d.PeNarrateRecipeDO;
import iih.pe.pitm.penarraterecipe.d.PenarraterecipeAggDO;

/**
* 体检叙述型营养处方数据维护服务
*/
public interface IPenarraterecipeCudService {
	/**
	*  体检叙述型营养处方数据真删除
	*/
    public abstract void delete(PenarraterecipeAggDO[] aggdos) throws BizException;
    
    /**
	*  体检叙述型营养处方数据插入保存
	*/
	public abstract PenarraterecipeAggDO[] insert(PenarraterecipeAggDO[] aggdos) throws BizException;
	
    /**
	*  体检叙述型营养处方数据保存
	*/
	public abstract PenarraterecipeAggDO[] save(PenarraterecipeAggDO[] aggdos) throws BizException;
	
    /**
	*  体检叙述型营养处方数据更新
	*/
	public abstract PenarraterecipeAggDO[] update(PenarraterecipeAggDO[] aggdos) throws BizException;
	
	/**
	*  体检叙述型营养处方数据逻辑删除
	*/
	public abstract void logicDelete(PenarraterecipeAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检叙述型营养处方数据真删除
	 */
	public abstract void deleteByParentDO(PeNarrateRecipeDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检叙述型营养处方数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeNarrateRecipeDO[] mainDos) throws BizException;
}
