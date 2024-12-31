package iih.sc.scp.scplweek.i;

import xap.mw.core.data.BizException;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;

/**
* 计划排班_计划_周数据维护服务
*/
public interface IScplweekCudService {
	/**
	*  计划排班_计划_周数据真删除
	*/
    public abstract void delete(ScplweekAggDO[] aggdos) throws BizException;
    
    /**
	*  计划排班_计划_周数据插入保存
	*/
	public abstract ScplweekAggDO[] insert(ScplweekAggDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_计划_周数据保存
	*/
	public abstract ScplweekAggDO[] save(ScplweekAggDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_计划_周数据更新
	*/
	public abstract ScplweekAggDO[] update(ScplweekAggDO[] aggdos) throws BizException;
	
	/**
	*  计划排班_计划_周数据逻辑删除
	*/
	public abstract void logicDelete(ScplweekAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对计划排班_计划_周数据真删除
	 */
	public abstract void deleteByParentDO(ScPlanWeekDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对计划排班_计划_周数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ScPlanWeekDO[] mainDos) throws BizException;
}
