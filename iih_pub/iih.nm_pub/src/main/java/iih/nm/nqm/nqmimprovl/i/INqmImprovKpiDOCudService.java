package iih.nm.nqm.nqmimprovl.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nqmimprovl.d.NqmImprovKpiDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 持续改进数据维护服务
*/
public interface INqmImprovKpiDOCudService {
	/**
	*  持续改进数据真删除
	*/
    public abstract void delete(NqmImprovKpiDO[] aggdos) throws BizException;
    
    /**
	*  持续改进数据插入保存
	*/
	public abstract NqmImprovKpiDO[] insert(NqmImprovKpiDO[] aggdos) throws BizException;
	
    /**
	*  持续改进数据保存
	*/
	public abstract NqmImprovKpiDO[] save(NqmImprovKpiDO[] aggdos) throws BizException;
	
    /**
	*  持续改进数据更新
	*/
	public abstract NqmImprovKpiDO[] update(NqmImprovKpiDO[] aggdos) throws BizException;
	
	/**
	*  持续改进数据逻辑删除
	*/
	public abstract void logicDelete(NqmImprovKpiDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NqmImprovKpiDO[] enableWithoutFilter(NqmImprovKpiDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NqmImprovKpiDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NqmImprovKpiDO[] disableVOWithoutFilter(NqmImprovKpiDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NqmImprovKpiDO[] aggdos) throws BizException ;
	
}
