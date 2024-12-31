package iih.mc.pl.mcstockplan.i;

import xap.mw.core.data.BizException;
import iih.mc.pl.mcstockplan.d.McStockPlanDO;
import iih.mc.pl.mcstockplan.d.McstockplanAggDO;

/**
* 耗材库存计划数据维护服务
*/
public interface IMcstockplanCudService {
	/**
	*  耗材库存计划数据真删除
	*/
    public abstract void delete(McstockplanAggDO[] aggdos) throws BizException;
    
    /**
	*  耗材库存计划数据插入保存
	*/
	public abstract McstockplanAggDO[] insert(McstockplanAggDO[] aggdos) throws BizException;
	
    /**
	*  耗材库存计划数据保存
	*/
	public abstract McstockplanAggDO[] save(McstockplanAggDO[] aggdos) throws BizException;
	
    /**
	*  耗材库存计划数据更新
	*/
	public abstract McstockplanAggDO[] update(McstockplanAggDO[] aggdos) throws BizException;
	
	/**
	*  耗材库存计划数据逻辑删除
	*/
	public abstract void logicDelete(McstockplanAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对耗材库存计划数据真删除
	 */
	public abstract void deleteByParentDO(McStockPlanDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对耗材库存计划数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(McStockPlanDO[] mainDos) throws BizException;
}
