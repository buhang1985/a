package iih.cssd.dpp.stz.i;

import xap.mw.core.data.BizException;
import iih.cssd.dpp.stz.d.CssddfpstzDO;
import iih.cssd.dpp.stz.d.StzAggDO;

/**
* 包灭菌数据维护服务
*/
public interface IStzCudService {
	/**
	*  包灭菌数据真删除
	*/
    public abstract void delete(StzAggDO[] aggdos) throws BizException;
    
    /**
	*  包灭菌数据插入保存
	*/
	public abstract StzAggDO[] insert(StzAggDO[] aggdos) throws BizException;
	
    /**
	*  包灭菌数据保存
	*/
	public abstract StzAggDO[] save(StzAggDO[] aggdos) throws BizException;
	
    /**
	*  包灭菌数据更新
	*/
	public abstract StzAggDO[] update(StzAggDO[] aggdos) throws BizException;
	
	/**
	*  包灭菌数据逻辑删除
	*/
	public abstract void logicDelete(StzAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对包灭菌数据真删除
	 */
	public abstract void deleteByParentDO(CssddfpstzDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对包灭菌数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CssddfpstzDO[] mainDos) throws BizException;
}
