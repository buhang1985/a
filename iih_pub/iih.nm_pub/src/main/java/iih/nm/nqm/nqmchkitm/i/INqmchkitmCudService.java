package iih.nm.nqm.nqmchkitm.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nqmchkitm.d.NmNqmChkitmcaDo;
import iih.nm.nqm.nqmchkitm.d.NqmchkitmAggDO;

/**
* 护理管理_评分项目数据维护服务
*/
public interface INqmchkitmCudService {
	/**
	*  护理管理_评分项目数据真删除
	*/
    public abstract void delete(NqmchkitmAggDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_评分项目数据插入保存
	*/
	public abstract NqmchkitmAggDO[] insert(NqmchkitmAggDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_评分项目数据保存
	*/
	public abstract NqmchkitmAggDO[] save(NqmchkitmAggDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_评分项目数据更新
	*/
	public abstract NqmchkitmAggDO[] update(NqmchkitmAggDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_评分项目数据逻辑删除
	*/
	public abstract void logicDelete(NqmchkitmAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护理管理_评分项目数据真删除
	 */
	public abstract void deleteByParentDO(NmNqmChkitmcaDo[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护理管理_评分项目数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmNqmChkitmcaDo[] mainDos) throws BizException;
}
