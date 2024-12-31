package iih.cssd.dpbd.apptmpl.i;

import xap.mw.core.data.BizException;
import iih.cssd.dpbd.apptmpl.d.DfpAppTmplDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 消毒包科室请领模板数据维护服务
*/
public interface IApptmplMDOCudService {
	/**
	*  消毒包科室请领模板数据真删除
	*/
    public abstract void delete(DfpAppTmplDO[] aggdos) throws BizException;
    
    /**
	*  消毒包科室请领模板数据插入保存
	*/
	public abstract DfpAppTmplDO[] insert(DfpAppTmplDO[] aggdos) throws BizException;
	
    /**
	*  消毒包科室请领模板数据保存
	*/
	public abstract DfpAppTmplDO[] save(DfpAppTmplDO[] aggdos) throws BizException;
	
    /**
	*  消毒包科室请领模板数据更新
	*/
	public abstract DfpAppTmplDO[] update(DfpAppTmplDO[] aggdos) throws BizException;
	
	/**
	*  消毒包科室请领模板数据逻辑删除
	*/
	public abstract void logicDelete(DfpAppTmplDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DfpAppTmplDO[] enableWithoutFilter(DfpAppTmplDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DfpAppTmplDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DfpAppTmplDO[] disableVOWithoutFilter(DfpAppTmplDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DfpAppTmplDO[] aggdos) throws BizException ;
	
}
