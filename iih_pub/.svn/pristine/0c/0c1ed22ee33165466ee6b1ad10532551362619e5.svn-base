package iih.cssd.dpp.dfpcln.i;

import xap.mw.core.data.BizException;
import iih.cssd.dpp.dfpcln.d.CssdDfpClnDO;
import iih.cssd.dpp.dfpcln.d.DfpclnAggDO;

/**
* 消毒包清洗数据维护服务
*/
public interface IDfpclnCudService {
	/**
	*  消毒包清洗数据真删除
	*/
    public abstract void delete(DfpclnAggDO[] aggdos) throws BizException;
    
    /**
	*  消毒包清洗数据插入保存
	*/
	public abstract DfpclnAggDO[] insert(DfpclnAggDO[] aggdos) throws BizException;
	
    /**
	*  消毒包清洗数据保存
	*/
	public abstract DfpclnAggDO[] save(DfpclnAggDO[] aggdos) throws BizException;
	
    /**
	*  消毒包清洗数据更新
	*/
	public abstract DfpclnAggDO[] update(DfpclnAggDO[] aggdos) throws BizException;
	
	/**
	*  消毒包清洗数据逻辑删除
	*/
	public abstract void logicDelete(DfpclnAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对消毒包清洗数据真删除
	 */
	public abstract void deleteByParentDO(CssdDfpClnDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对消毒包清洗数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CssdDfpClnDO[] mainDos) throws BizException;
}
