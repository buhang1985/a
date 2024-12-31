package iih.bd.pp.bdhpspec.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.bdhpspec.d.BdHpSpecDO;
import iih.bd.pp.bdhpspec.d.BdhpspecAggDO;

/**
* 医保特殊病数据维护服务
*/
public interface IBdhpspecCudService {
	/**
	*  医保特殊病数据真删除
	*/
    public abstract void delete(BdhpspecAggDO[] aggdos) throws BizException;
    
    /**
	*  医保特殊病数据插入保存
	*/
	public abstract BdhpspecAggDO[] insert(BdhpspecAggDO[] aggdos) throws BizException;
	
    /**
	*  医保特殊病数据保存
	*/
	public abstract BdhpspecAggDO[] save(BdhpspecAggDO[] aggdos) throws BizException;
	
    /**
	*  医保特殊病数据更新
	*/
	public abstract BdhpspecAggDO[] update(BdhpspecAggDO[] aggdos) throws BizException;
	
	/**
	*  医保特殊病数据逻辑删除
	*/
	public abstract void logicDelete(BdhpspecAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医保特殊病数据真删除
	 */
	public abstract void deleteByParentDO(BdHpSpecDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医保特殊病数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BdHpSpecDO[] mainDos) throws BizException;
}
