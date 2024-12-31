package iih.bd.bs.workcalendar.i;

import xap.mw.core.data.BizException;
import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import iih.bd.bs.workcalendar.d.WorkcalendarAggDO;

/**
* 工作日历数据维护服务
*/
public interface IWorkcalendarCudService {
	/**
	*  工作日历数据真删除
	*/
    public abstract void delete(WorkcalendarAggDO[] aggdos) throws BizException;
    
    /**
	*  工作日历数据插入保存
	*/
	public abstract WorkcalendarAggDO[] insert(WorkcalendarAggDO[] aggdos) throws BizException;
	
    /**
	*  工作日历数据保存
	*/
	public abstract WorkcalendarAggDO[] save(WorkcalendarAggDO[] aggdos) throws BizException;
	
    /**
	*  工作日历数据更新
	*/
	public abstract WorkcalendarAggDO[] update(WorkcalendarAggDO[] aggdos) throws BizException;
	
	/**
	*  工作日历数据逻辑删除
	*/
	public abstract void logicDelete(WorkcalendarAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对工作日历数据真删除
	 */
	public abstract void deleteByParentDO(WorkCalendarDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对工作日历数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(WorkCalendarDO[] mainDos) throws BizException;
}
