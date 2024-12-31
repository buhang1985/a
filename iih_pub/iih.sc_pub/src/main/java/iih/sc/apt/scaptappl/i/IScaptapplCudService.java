package iih.sc.apt.scaptappl.i;

import xap.mw.core.data.BizException;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.d.ScaptapplAggDO;

/**
* 计划排班_预约_申请数据维护服务
*/
public interface IScaptapplCudService {
	/**
	*  计划排班_预约_申请数据真删除
	*/
    public abstract void delete(ScaptapplAggDO[] aggdos) throws BizException;
    
    /**
	*  计划排班_预约_申请数据插入保存
	*/
	public abstract ScaptapplAggDO[] insert(ScaptapplAggDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_预约_申请数据保存
	*/
	public abstract ScaptapplAggDO[] save(ScaptapplAggDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_预约_申请数据更新
	*/
	public abstract ScaptapplAggDO[] update(ScaptapplAggDO[] aggdos) throws BizException;
	
	/**
	*  计划排班_预约_申请数据逻辑删除
	*/
	public abstract void logicDelete(ScaptapplAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对计划排班_预约_申请数据真删除
	 */
	public abstract void deleteByParentDO(ScAptApplDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对计划排班_预约_申请数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ScAptApplDO[] mainDos) throws BizException;
}
