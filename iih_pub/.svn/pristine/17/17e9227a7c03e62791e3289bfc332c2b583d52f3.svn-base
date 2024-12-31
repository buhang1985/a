package iih.nmr.common.hecptp.i;

import xap.mw.core.data.BizException;
import iih.nmr.common.hecptp.d.HeduPlanTpDO;
import iih.nmr.common.hecptp.d.HecptpAggDO;

/**
* 健康教育计划单据类型数据维护服务
*/
public interface IHecptpCudService {
	/**
	*  健康教育计划单据类型数据真删除
	*/
    public abstract void delete(HecptpAggDO[] aggdos) throws BizException;
    
    /**
	*  健康教育计划单据类型数据插入保存
	*/
	public abstract HecptpAggDO[] insert(HecptpAggDO[] aggdos) throws BizException;
	
    /**
	*  健康教育计划单据类型数据保存
	*/
	public abstract HecptpAggDO[] save(HecptpAggDO[] aggdos) throws BizException;
	
    /**
	*  健康教育计划单据类型数据更新
	*/
	public abstract HecptpAggDO[] update(HecptpAggDO[] aggdos) throws BizException;
	
	/**
	*  健康教育计划单据类型数据逻辑删除
	*/
	public abstract void logicDelete(HecptpAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对健康教育计划单据类型数据真删除
	 */
	public abstract void deleteByParentDO(HeduPlanTpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对健康教育计划单据类型数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(HeduPlanTpDO[] mainDos) throws BizException;
}
