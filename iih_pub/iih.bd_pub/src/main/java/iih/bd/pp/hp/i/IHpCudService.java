package iih.bd.pp.hp.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.d.HpAggDO;

/**
* 医保计划数据维护服务
*/
public interface IHpCudService {
	/**
	*  医保计划数据真删除
	*/
    public abstract void delete(HpAggDO[] aggdos) throws BizException;
    
    /**
	*  医保计划数据插入保存
	*/
	public abstract HpAggDO[] insert(HpAggDO[] aggdos) throws BizException;
	
    /**
	*  医保计划数据保存
	*/
	public abstract HpAggDO[] save(HpAggDO[] aggdos) throws BizException;
	
    /**
	*  医保计划数据更新
	*/
	public abstract HpAggDO[] update(HpAggDO[] aggdos) throws BizException;
	
	/**
	*  医保计划数据逻辑删除
	*/
	public abstract void logicDelete(HpAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医保计划数据真删除
	 */
	public abstract void deleteByParentDO(HPDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医保计划数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(HPDO[] mainDos) throws BizException;
}
