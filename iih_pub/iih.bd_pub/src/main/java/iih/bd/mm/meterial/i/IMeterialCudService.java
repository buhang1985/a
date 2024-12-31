package iih.bd.mm.meterial.i;

import xap.mw.core.data.BizException;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.d.MeterialAggDO;

/**
* 医疗物品数据维护服务
*/
public interface IMeterialCudService {
	/**
	*  医疗物品数据真删除
	*/
    public abstract void delete(MeterialAggDO[] aggdos) throws BizException;
    
    /**
	*  医疗物品数据插入保存
	*/
	public abstract MeterialAggDO[] insert(MeterialAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗物品数据保存
	*/
	public abstract MeterialAggDO[] save(MeterialAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗物品数据更新
	*/
	public abstract MeterialAggDO[] update(MeterialAggDO[] aggdos) throws BizException;
	
	/**
	*  医疗物品数据逻辑删除
	*/
	public abstract void logicDelete(MeterialAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医疗物品数据真删除
	 */
	public abstract void deleteByParentDO(MeterialDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医疗物品数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MeterialDO[] mainDos) throws BizException;
}
