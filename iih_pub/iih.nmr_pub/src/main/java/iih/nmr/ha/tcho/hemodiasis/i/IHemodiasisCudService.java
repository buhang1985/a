package iih.nmr.ha.tcho.hemodiasis.i;

import xap.mw.core.data.BizException;
import iih.nmr.ha.tcho.hemodiasis.d.HemodialysisDO;
import iih.nmr.ha.tcho.hemodiasis.d.HemodiasisAggDO;

/**
* 血液透析护理记录数据维护服务
*/
public interface IHemodiasisCudService {
	/**
	*  血液透析护理记录数据真删除
	*/
    public abstract void delete(HemodiasisAggDO[] aggdos) throws BizException;
    
    /**
	*  血液透析护理记录数据插入保存
	*/
	public abstract HemodiasisAggDO[] insert(HemodiasisAggDO[] aggdos) throws BizException;
	
    /**
	*  血液透析护理记录数据保存
	*/
	public abstract HemodiasisAggDO[] save(HemodiasisAggDO[] aggdos) throws BizException;
	
    /**
	*  血液透析护理记录数据更新
	*/
	public abstract HemodiasisAggDO[] update(HemodiasisAggDO[] aggdos) throws BizException;
	
	/**
	*  血液透析护理记录数据逻辑删除
	*/
	public abstract void logicDelete(HemodiasisAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对血液透析护理记录数据真删除
	 */
	public abstract void deleteByParentDO(HemodialysisDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对血液透析护理记录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(HemodialysisDO[] mainDos) throws BizException;
}
