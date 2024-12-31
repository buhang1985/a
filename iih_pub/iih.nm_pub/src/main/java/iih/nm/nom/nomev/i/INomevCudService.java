package iih.nm.nom.nomev.i;

import xap.mw.core.data.BizException;
import iih.nm.nom.nomev.d.NomEvDO;
import iih.nm.nom.nomev.d.NomevAggDO;

/**
* 护理部大事记数据维护服务
*/
public interface INomevCudService {
	/**
	*  护理部大事记数据真删除
	*/
    public abstract void delete(NomevAggDO[] aggdos) throws BizException;
    
    /**
	*  护理部大事记数据插入保存
	*/
	public abstract NomevAggDO[] insert(NomevAggDO[] aggdos) throws BizException;
	
    /**
	*  护理部大事记数据保存
	*/
	public abstract NomevAggDO[] save(NomevAggDO[] aggdos) throws BizException;
	
    /**
	*  护理部大事记数据更新
	*/
	public abstract NomevAggDO[] update(NomevAggDO[] aggdos) throws BizException;
	
	/**
	*  护理部大事记数据逻辑删除
	*/
	public abstract void logicDelete(NomevAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护理部大事记数据真删除
	 */
	public abstract void deleteByParentDO(NomEvDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护理部大事记数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NomEvDO[] mainDos) throws BizException;
}
