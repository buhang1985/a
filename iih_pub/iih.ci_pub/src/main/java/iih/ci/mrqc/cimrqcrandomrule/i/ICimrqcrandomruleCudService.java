package iih.ci.mrqc.cimrqcrandomrule.i;

import xap.mw.core.data.BizException;
import iih.ci.mrqc.cimrqcrandomrule.d.CiMrQcRandomRuleDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 质控抽查设置规则数据维护服务
*/
public interface ICimrqcrandomruleCudService {
	/**
	*  质控抽查设置规则数据真删除
	*/
    public abstract void delete(CiMrQcRandomRuleDO[] aggdos) throws BizException;
    
    /**
	*  质控抽查设置规则数据插入保存
	*/
	public abstract CiMrQcRandomRuleDO[] insert(CiMrQcRandomRuleDO[] aggdos) throws BizException;
	
    /**
	*  质控抽查设置规则数据保存
	*/
	public abstract CiMrQcRandomRuleDO[] save(CiMrQcRandomRuleDO[] aggdos) throws BizException;
	
    /**
	*  质控抽查设置规则数据更新
	*/
	public abstract CiMrQcRandomRuleDO[] update(CiMrQcRandomRuleDO[] aggdos) throws BizException;
	
	/**
	*  质控抽查设置规则数据逻辑删除
	*/
	public abstract void logicDelete(CiMrQcRandomRuleDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrQcRandomRuleDO[] enableWithoutFilter(CiMrQcRandomRuleDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrQcRandomRuleDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrQcRandomRuleDO[] disableVOWithoutFilter(CiMrQcRandomRuleDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrQcRandomRuleDO[] dos) throws BizException ;
}
