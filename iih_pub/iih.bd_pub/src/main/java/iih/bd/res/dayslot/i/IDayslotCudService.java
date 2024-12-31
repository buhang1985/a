package iih.bd.res.dayslot.i;

import xap.mw.core.data.BizException;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.d.DayslotAggDO;

/**
* 日期分组数据维护服务
*/
public interface IDayslotCudService {
	/**
	*  日期分组数据真删除
	*/
    public abstract void delete(DayslotAggDO[] aggdos) throws BizException;
    
    /**
	*  日期分组数据插入保存
	*/
	public abstract DayslotAggDO[] insert(DayslotAggDO[] aggdos) throws BizException;
	
    /**
	*  日期分组数据保存
	*/
	public abstract DayslotAggDO[] save(DayslotAggDO[] aggdos) throws BizException;
	
    /**
	*  日期分组数据更新
	*/
	public abstract DayslotAggDO[] update(DayslotAggDO[] aggdos) throws BizException;
	
	/**
	*  日期分组数据逻辑删除
	*/
	public abstract void logicDelete(DayslotAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对日期分组数据真删除
	 */
	public abstract void deleteByParentDO(DaysLotDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对日期分组数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(DaysLotDO[] mainDos) throws BizException;
}
