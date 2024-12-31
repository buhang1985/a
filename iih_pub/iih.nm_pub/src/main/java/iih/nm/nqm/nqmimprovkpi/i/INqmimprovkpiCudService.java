package iih.nm.nqm.nqmimprovkpi.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nqmimprovkpi.d.NqmImprovKpiDO;
import iih.nm.nqm.nqmimprovkpi.d.NqmimprovkpiAggDO;

/**
* 护理管理_持续改进项目数据维护服务
*/
public interface INqmimprovkpiCudService {
	/**
	*  护理管理_持续改进项目数据真删除
	*/
    public abstract void delete(NqmimprovkpiAggDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_持续改进项目数据插入保存
	*/
	public abstract NqmimprovkpiAggDO[] insert(NqmimprovkpiAggDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_持续改进项目数据保存
	*/
	public abstract NqmimprovkpiAggDO[] save(NqmimprovkpiAggDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_持续改进项目数据更新
	*/
	public abstract NqmimprovkpiAggDO[] update(NqmimprovkpiAggDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_持续改进项目数据逻辑删除
	*/
	public abstract void logicDelete(NqmimprovkpiAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护理管理_持续改进项目数据真删除
	 */
	public abstract void deleteByParentDO(NqmImprovKpiDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护理管理_持续改进项目数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NqmImprovKpiDO[] mainDos) throws BizException;
}
