package iih.bd.srv.mrtaskrule.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleDO;
import iih.bd.srv.mrtaskrule.d.MrtaskruleAggDO;

/**
* 病历书写任务配置数据维护服务
*/
public interface IMrtaskruleCudService {
	/**
	*  病历书写任务配置数据真删除
	*/
    public abstract void delete(MrtaskruleAggDO[] aggdos) throws BizException;
    
    /**
	*  病历书写任务配置数据插入保存
	*/
	public abstract MrtaskruleAggDO[] insert(MrtaskruleAggDO[] aggdos) throws BizException;
	
    /**
	*  病历书写任务配置数据保存
	*/
	public abstract MrtaskruleAggDO[] save(MrtaskruleAggDO[] aggdos) throws BizException;
	
    /**
	*  病历书写任务配置数据更新
	*/
	public abstract MrtaskruleAggDO[] update(MrtaskruleAggDO[] aggdos) throws BizException;
	
	/**
	*  病历书写任务配置数据逻辑删除
	*/
	public abstract void logicDelete(MrtaskruleAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对病历书写任务配置数据真删除
	 */
	public abstract void deleteByParentDO(MrTaskRuleDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对病历书写任务配置数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MrTaskRuleDO[] mainDos) throws BizException;
}
