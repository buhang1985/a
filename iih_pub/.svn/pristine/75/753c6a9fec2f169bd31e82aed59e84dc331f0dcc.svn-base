package iih.mp.nr.hdvview.i;

import xap.mw.core.data.BizException;
import iih.mp.nr.hdvview.d.HdvDO;
import iih.mp.nr.hdvview.d.HdvviewAggDO;

/**
* 交班汇总数据维护服务
*/
public interface IHdvviewCudService {
	/**
	*  交班汇总数据真删除
	*/
    public abstract void delete(HdvviewAggDO[] aggdos) throws BizException;
    
    /**
	*  交班汇总数据插入保存
	*/
	public abstract HdvviewAggDO[] insert(HdvviewAggDO[] aggdos) throws BizException;
	
    /**
	*  交班汇总数据保存
	*/
	public abstract HdvviewAggDO[] save(HdvviewAggDO[] aggdos) throws BizException;
	
    /**
	*  交班汇总数据更新
	*/
	public abstract HdvviewAggDO[] update(HdvviewAggDO[] aggdos) throws BizException;
	
	/**
	*  交班汇总数据逻辑删除
	*/
	public abstract void logicDelete(HdvviewAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对交班汇总数据真删除
	 */
	public abstract void deleteByParentDO(HdvDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对交班汇总数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(HdvDO[] mainDos) throws BizException;
}
