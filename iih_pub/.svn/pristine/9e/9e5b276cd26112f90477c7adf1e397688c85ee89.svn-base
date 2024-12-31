package iih.hp.cp.app.i;

import xap.mw.core.data.BizException;
import iih.hp.cp.app.d.HpCpAppDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 诊疗计划应用数据维护服务
*/
public interface IHpcpappMDOCudService {
	/**
	*  诊疗计划应用数据真删除
	*/
    public abstract void delete(HpCpAppDO[] aggdos) throws BizException;
    
    /**
	*  诊疗计划应用数据插入保存
	*/
	public abstract HpCpAppDO[] insert(HpCpAppDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划应用数据保存
	*/
	public abstract HpCpAppDO[] save(HpCpAppDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划应用数据更新
	*/
	public abstract HpCpAppDO[] update(HpCpAppDO[] aggdos) throws BizException;
	
	/**
	*  诊疗计划应用数据逻辑删除
	*/
	public abstract void logicDelete(HpCpAppDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpCpAppDO[] enableWithoutFilter(HpCpAppDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpCpAppDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpCpAppDO[] disableVOWithoutFilter(HpCpAppDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpCpAppDO[] aggdos) throws BizException ;
	
}
