package iih.bd.pp.incca.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.incca.d.IncCaDO;
import iih.bd.pp.incca.d.InccaAggDO;

/**
* 票据分类数据维护服务
*/
public interface IInccaCudService {
	/**
	*  票据分类数据真删除
	*/
    public abstract void delete(InccaAggDO[] aggdos) throws BizException;
    
    /**
	*  票据分类数据插入保存
	*/
	public abstract InccaAggDO[] insert(InccaAggDO[] aggdos) throws BizException;
	
    /**
	*  票据分类数据保存
	*/
	public abstract InccaAggDO[] save(InccaAggDO[] aggdos) throws BizException;
	
    /**
	*  票据分类数据更新
	*/
	public abstract InccaAggDO[] update(InccaAggDO[] aggdos) throws BizException;
	
	/**
	*  票据分类数据逻辑删除
	*/
	public abstract void logicDelete(InccaAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对票据分类数据真删除
	 */
	public abstract void deleteByParentDO(IncCaDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对票据分类数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(IncCaDO[] mainDos) throws BizException;
}
