package iih.hr.hsc.hscschedweek.i;

import xap.mw.core.data.BizException;
import iih.hr.hsc.hscschedweek.d.HscSchedWeekDO;
import iih.hr.hsc.hscschedweek.d.HscschedweekAggDO;

/**
* 排班周信息数据维护服务
*/
public interface IHscschedweekCudService {
	/**
	*  排班周信息数据真删除
	*/
    public abstract void delete(HscschedweekAggDO[] aggdos) throws BizException;
    
    /**
	*  排班周信息数据插入保存
	*/
	public abstract HscschedweekAggDO[] insert(HscschedweekAggDO[] aggdos) throws BizException;
	
    /**
	*  排班周信息数据保存
	*/
	public abstract HscschedweekAggDO[] save(HscschedweekAggDO[] aggdos) throws BizException;
	
    /**
	*  排班周信息数据更新
	*/
	public abstract HscschedweekAggDO[] update(HscschedweekAggDO[] aggdos) throws BizException;
	
	/**
	*  排班周信息数据逻辑删除
	*/
	public abstract void logicDelete(HscschedweekAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对排班周信息数据真删除
	 */
	public abstract void deleteByParentDO(HscSchedWeekDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对排班周信息数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(HscSchedWeekDO[] mainDos) throws BizException;
}
