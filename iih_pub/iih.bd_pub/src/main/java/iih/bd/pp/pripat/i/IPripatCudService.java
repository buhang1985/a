package iih.bd.pp.pripat.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.pripat.d.PriPatDO;
import iih.bd.pp.pripat.d.PripatAggDO;

/**
* 患者价格分类数据维护服务
*/
public interface IPripatCudService {
	/**
	*  患者价格分类数据真删除
	*/
    public abstract void delete(PripatAggDO[] aggdos) throws BizException;
    
    /**
	*  患者价格分类数据插入保存
	*/
	public abstract PripatAggDO[] insert(PripatAggDO[] aggdos) throws BizException;
	
    /**
	*  患者价格分类数据保存
	*/
	public abstract PripatAggDO[] save(PripatAggDO[] aggdos) throws BizException;
	
    /**
	*  患者价格分类数据更新
	*/
	public abstract PripatAggDO[] update(PripatAggDO[] aggdos) throws BizException;
	
	/**
	*  患者价格分类数据逻辑删除
	*/
	public abstract void logicDelete(PripatAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对患者价格分类数据真删除
	 */
	public abstract void deleteByParentDO(PriPatDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对患者价格分类数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PriPatDO[] mainDos) throws BizException;
}
