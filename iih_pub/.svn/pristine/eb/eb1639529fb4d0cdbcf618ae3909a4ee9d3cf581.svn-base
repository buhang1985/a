package iih.nm.nqm.nmnqmkpi.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nmnqmkpi.d.NmNqmKpiDO;
import iih.nm.nqm.nmnqmkpi.d.NmnqmkpiAggDO;

/**
* 标准指标数据维护服务
*/
public interface INmnqmkpiCudService {
	/**
	*  标准指标数据真删除
	*/
    public abstract void delete(NmnqmkpiAggDO[] aggdos) throws BizException;
    
    /**
	*  标准指标数据插入保存
	*/
	public abstract NmnqmkpiAggDO[] insert(NmnqmkpiAggDO[] aggdos) throws BizException;
	
    /**
	*  标准指标数据保存
	*/
	public abstract NmnqmkpiAggDO[] save(NmnqmkpiAggDO[] aggdos) throws BizException;
	
    /**
	*  标准指标数据更新
	*/
	public abstract NmnqmkpiAggDO[] update(NmnqmkpiAggDO[] aggdos) throws BizException;
	
	/**
	*  标准指标数据逻辑删除
	*/
	public abstract void logicDelete(NmnqmkpiAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对标准指标数据真删除
	 */
	public abstract void deleteByParentDO(NmNqmKpiDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对标准指标数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmNqmKpiDO[] mainDos) throws BizException;
}
