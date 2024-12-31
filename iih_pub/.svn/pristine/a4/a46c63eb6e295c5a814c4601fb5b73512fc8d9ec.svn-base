package iih.pe.pitm.perules.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.perules.d.PeRuleExclusiveDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 异常结果判定规则数据维护服务
*/
public interface IPeRuleExclusiveDOCudService {
	/**
	*  异常结果判定规则数据真删除
	*/
    public abstract void delete(PeRuleExclusiveDO[] aggdos) throws BizException;
    
    /**
	*  异常结果判定规则数据插入保存
	*/
	public abstract PeRuleExclusiveDO[] insert(PeRuleExclusiveDO[] aggdos) throws BizException;
	
    /**
	*  异常结果判定规则数据保存
	*/
	public abstract PeRuleExclusiveDO[] save(PeRuleExclusiveDO[] aggdos) throws BizException;
	
    /**
	*  异常结果判定规则数据更新
	*/
	public abstract PeRuleExclusiveDO[] update(PeRuleExclusiveDO[] aggdos) throws BizException;
	
	/**
	*  异常结果判定规则数据逻辑删除
	*/
	public abstract void logicDelete(PeRuleExclusiveDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeRuleExclusiveDO[] enableWithoutFilter(PeRuleExclusiveDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeRuleExclusiveDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeRuleExclusiveDO[] disableVOWithoutFilter(PeRuleExclusiveDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeRuleExclusiveDO[] aggdos) throws BizException ;
	
}
