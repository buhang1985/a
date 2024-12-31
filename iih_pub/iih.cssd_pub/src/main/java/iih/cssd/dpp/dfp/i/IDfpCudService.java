package iih.cssd.dpp.dfp.i;

import xap.mw.core.data.BizException;
import iih.cssd.dpp.dfp.d.CssdDfpDO;
import iih.cssd.dpp.dfp.d.DfpAggDO;

/**
* 消毒包生产数据维护服务
*/
public interface IDfpCudService {
	/**
	*  消毒包生产数据真删除
	*/
    public abstract void delete(DfpAggDO[] aggdos) throws BizException;
    
    /**
	*  消毒包生产数据插入保存
	*/
	public abstract DfpAggDO[] insert(DfpAggDO[] aggdos) throws BizException;
	
    /**
	*  消毒包生产数据保存
	*/
	public abstract DfpAggDO[] save(DfpAggDO[] aggdos) throws BizException;
	
    /**
	*  消毒包生产数据更新
	*/
	public abstract DfpAggDO[] update(DfpAggDO[] aggdos) throws BizException;
	
	/**
	*  消毒包生产数据逻辑删除
	*/
	public abstract void logicDelete(DfpAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对消毒包生产数据真删除
	 */
	public abstract void deleteByParentDO(CssdDfpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对消毒包生产数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CssdDfpDO[] mainDos) throws BizException;
}
