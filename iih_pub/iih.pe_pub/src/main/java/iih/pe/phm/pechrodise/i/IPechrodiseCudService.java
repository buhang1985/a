package iih.pe.phm.pechrodise.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pechrodise.d.PeChroDiseDO;
import iih.pe.phm.pechrodise.d.PechrodiseAggDO;

/**
* 体检慢性病风险评估数据维护服务
*/
public interface IPechrodiseCudService {
	/**
	*  体检慢性病风险评估数据真删除
	*/
    public abstract void delete(PechrodiseAggDO[] aggdos) throws BizException;
    
    /**
	*  体检慢性病风险评估数据插入保存
	*/
	public abstract PechrodiseAggDO[] insert(PechrodiseAggDO[] aggdos) throws BizException;
	
    /**
	*  体检慢性病风险评估数据保存
	*/
	public abstract PechrodiseAggDO[] save(PechrodiseAggDO[] aggdos) throws BizException;
	
    /**
	*  体检慢性病风险评估数据更新
	*/
	public abstract PechrodiseAggDO[] update(PechrodiseAggDO[] aggdos) throws BizException;
	
	/**
	*  体检慢性病风险评估数据逻辑删除
	*/
	public abstract void logicDelete(PechrodiseAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检慢性病风险评估数据真删除
	 */
	public abstract void deleteByParentDO(PeChroDiseDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检慢性病风险评估数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeChroDiseDO[] mainDos) throws BizException;
}
