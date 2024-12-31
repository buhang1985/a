package iih.nm.nom.nomrnd.i;

import xap.mw.core.data.BizException;
import iih.nm.nom.nomrnd.d.NomRndDO;
import iih.nm.nom.nomrnd.d.NomrndAggDO;

/**
* 护理查房记录数据维护服务
*/
public interface INomrndCudService {
	/**
	*  护理查房记录数据真删除
	*/
    public abstract void delete(NomrndAggDO[] aggdos) throws BizException;
    
    /**
	*  护理查房记录数据插入保存
	*/
	public abstract NomrndAggDO[] insert(NomrndAggDO[] aggdos) throws BizException;
	
    /**
	*  护理查房记录数据保存
	*/
	public abstract NomrndAggDO[] save(NomrndAggDO[] aggdos) throws BizException;
	
    /**
	*  护理查房记录数据更新
	*/
	public abstract NomrndAggDO[] update(NomrndAggDO[] aggdos) throws BizException;
	
	/**
	*  护理查房记录数据逻辑删除
	*/
	public abstract void logicDelete(NomrndAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护理查房记录数据真删除
	 */
	public abstract void deleteByParentDO(NomRndDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护理查房记录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NomRndDO[] mainDos) throws BizException;
}
