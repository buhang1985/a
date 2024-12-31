package iih.nm.nhr.nmnurlabor.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnurlabor.d.NmNurLaborDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 工时调整数据维护服务
*/
public interface INmnurlaborMDOCudService {
	/**
	*  工时调整数据真删除
	*/
    public abstract void delete(NmNurLaborDO[] aggdos) throws BizException;
    
    /**
	*  工时调整数据插入保存
	*/
	public abstract NmNurLaborDO[] insert(NmNurLaborDO[] aggdos) throws BizException;
	
    /**
	*  工时调整数据保存
	*/
	public abstract NmNurLaborDO[] save(NmNurLaborDO[] aggdos) throws BizException;
	
    /**
	*  工时调整数据更新
	*/
	public abstract NmNurLaborDO[] update(NmNurLaborDO[] aggdos) throws BizException;
	
	/**
	*  工时调整数据逻辑删除
	*/
	public abstract void logicDelete(NmNurLaborDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNurLaborDO[] enableWithoutFilter(NmNurLaborDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNurLaborDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNurLaborDO[] disableVOWithoutFilter(NmNurLaborDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNurLaborDO[] aggdos) throws BizException ;
	
}
