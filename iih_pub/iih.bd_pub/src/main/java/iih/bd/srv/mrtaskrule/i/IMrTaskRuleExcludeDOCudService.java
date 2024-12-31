package iih.bd.srv.mrtaskrule.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleExcludeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 病历书写任务配置数据维护服务
*/
public interface IMrTaskRuleExcludeDOCudService {
	/**
	*  病历书写任务配置数据真删除
	*/
    public abstract void delete(MrTaskRuleExcludeDO[] aggdos) throws BizException;
    
    /**
	*  病历书写任务配置数据插入保存
	*/
	public abstract MrTaskRuleExcludeDO[] insert(MrTaskRuleExcludeDO[] aggdos) throws BizException;
	
    /**
	*  病历书写任务配置数据保存
	*/
	public abstract MrTaskRuleExcludeDO[] save(MrTaskRuleExcludeDO[] aggdos) throws BizException;
	
    /**
	*  病历书写任务配置数据更新
	*/
	public abstract MrTaskRuleExcludeDO[] update(MrTaskRuleExcludeDO[] aggdos) throws BizException;
	
	/**
	*  病历书写任务配置数据逻辑删除
	*/
	public abstract void logicDelete(MrTaskRuleExcludeDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MrTaskRuleExcludeDO[] enableWithoutFilter(MrTaskRuleExcludeDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MrTaskRuleExcludeDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MrTaskRuleExcludeDO[] disableVOWithoutFilter(MrTaskRuleExcludeDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MrTaskRuleExcludeDO[] aggdos) throws BizException ;
	
}
