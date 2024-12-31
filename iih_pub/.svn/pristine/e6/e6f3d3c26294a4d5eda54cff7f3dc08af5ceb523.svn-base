package iih.hp.cp.appele.i;

import xap.mw.core.data.BizException;
import iih.hp.cp.appele.d.HpCpAppDiagRuleDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 诊疗计划应用_元素数据维护服务
*/
public interface IHpCpAppDiagRuleDOCudService {
	/**
	*  诊疗计划应用_元素数据真删除
	*/
    public abstract void delete(HpCpAppDiagRuleDO[] aggdos) throws BizException;
    
    /**
	*  诊疗计划应用_元素数据插入保存
	*/
	public abstract HpCpAppDiagRuleDO[] insert(HpCpAppDiagRuleDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划应用_元素数据保存
	*/
	public abstract HpCpAppDiagRuleDO[] save(HpCpAppDiagRuleDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划应用_元素数据更新
	*/
	public abstract HpCpAppDiagRuleDO[] update(HpCpAppDiagRuleDO[] aggdos) throws BizException;
	
	/**
	*  诊疗计划应用_元素数据逻辑删除
	*/
	public abstract void logicDelete(HpCpAppDiagRuleDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpCpAppDiagRuleDO[] enableWithoutFilter(HpCpAppDiagRuleDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpCpAppDiagRuleDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpCpAppDiagRuleDO[] disableVOWithoutFilter(HpCpAppDiagRuleDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpCpAppDiagRuleDO[] aggdos) throws BizException ;
	
}
