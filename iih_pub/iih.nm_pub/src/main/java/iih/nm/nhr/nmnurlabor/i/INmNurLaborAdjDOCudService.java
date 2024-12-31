package iih.nm.nhr.nmnurlabor.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnurlabor.d.NmNurLaborAdjDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 工时调整数据维护服务
*/
public interface INmNurLaborAdjDOCudService {
	/**
	*  工时调整数据真删除
	*/
    public abstract void delete(NmNurLaborAdjDO[] aggdos) throws BizException;
    
    /**
	*  工时调整数据插入保存
	*/
	public abstract NmNurLaborAdjDO[] insert(NmNurLaborAdjDO[] aggdos) throws BizException;
	
    /**
	*  工时调整数据保存
	*/
	public abstract NmNurLaborAdjDO[] save(NmNurLaborAdjDO[] aggdos) throws BizException;
	
    /**
	*  工时调整数据更新
	*/
	public abstract NmNurLaborAdjDO[] update(NmNurLaborAdjDO[] aggdos) throws BizException;
	
	/**
	*  工时调整数据逻辑删除
	*/
	public abstract void logicDelete(NmNurLaborAdjDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNurLaborAdjDO[] enableWithoutFilter(NmNurLaborAdjDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNurLaborAdjDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNurLaborAdjDO[] disableVOWithoutFilter(NmNurLaborAdjDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNurLaborAdjDO[] aggdos) throws BizException ;
	
}
