package iih.nm.nqm.nmnqmkpi.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nmnqmkpi.d.NmNqmKpiDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 标准指标数据维护服务
*/
public interface INmnqmkpiMDOCudService {
	/**
	*  标准指标数据真删除
	*/
    public abstract void delete(NmNqmKpiDO[] aggdos) throws BizException;
    
    /**
	*  标准指标数据插入保存
	*/
	public abstract NmNqmKpiDO[] insert(NmNqmKpiDO[] aggdos) throws BizException;
	
    /**
	*  标准指标数据保存
	*/
	public abstract NmNqmKpiDO[] save(NmNqmKpiDO[] aggdos) throws BizException;
	
    /**
	*  标准指标数据更新
	*/
	public abstract NmNqmKpiDO[] update(NmNqmKpiDO[] aggdos) throws BizException;
	
	/**
	*  标准指标数据逻辑删除
	*/
	public abstract void logicDelete(NmNqmKpiDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNqmKpiDO[] enableWithoutFilter(NmNqmKpiDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNqmKpiDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNqmKpiDO[] disableVOWithoutFilter(NmNqmKpiDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNqmKpiDO[] aggdos) throws BizException ;
	
}
