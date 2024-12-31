package iih.mi.mc.mimctacticsrule.i;

import xap.mw.core.data.BizException;
import iih.mi.mc.mimctacticsrule.d.MiMcTacticsRuleDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保规则数据维护服务
*/
public interface IMimctacticsruleCudService {
	/**
	*  医保规则数据真删除
	*/
    public abstract void delete(MiMcTacticsRuleDO[] aggdos) throws BizException;
    
    /**
	*  医保规则数据插入保存
	*/
	public abstract MiMcTacticsRuleDO[] insert(MiMcTacticsRuleDO[] aggdos) throws BizException;
	
    /**
	*  医保规则数据保存
	*/
	public abstract MiMcTacticsRuleDO[] save(MiMcTacticsRuleDO[] aggdos) throws BizException;
	
    /**
	*  医保规则数据更新
	*/
	public abstract MiMcTacticsRuleDO[] update(MiMcTacticsRuleDO[] aggdos) throws BizException;
	
	/**
	*  医保规则数据逻辑删除
	*/
	public abstract void logicDelete(MiMcTacticsRuleDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MiMcTacticsRuleDO[] enableWithoutFilter(MiMcTacticsRuleDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MiMcTacticsRuleDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MiMcTacticsRuleDO[] disableVOWithoutFilter(MiMcTacticsRuleDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MiMcTacticsRuleDO[] dos) throws BizException ;
}
