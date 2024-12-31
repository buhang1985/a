package iih.nm.nbd.nbdkpi.i;

import xap.mw.core.data.BizException;
import iih.nm.nbd.nbdkpi.d.NbdKpiDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 指标定义数据维护服务
*/
public interface INbdkpiCudService {
	/**
	*  指标定义数据真删除
	*/
    public abstract void delete(NbdKpiDO[] aggdos) throws BizException;
    
    /**
	*  指标定义数据插入保存
	*/
	public abstract NbdKpiDO[] insert(NbdKpiDO[] aggdos) throws BizException;
	
    /**
	*  指标定义数据保存
	*/
	public abstract NbdKpiDO[] save(NbdKpiDO[] aggdos) throws BizException;
	
    /**
	*  指标定义数据更新
	*/
	public abstract NbdKpiDO[] update(NbdKpiDO[] aggdos) throws BizException;
	
	/**
	*  指标定义数据逻辑删除
	*/
	public abstract void logicDelete(NbdKpiDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NbdKpiDO[] enableWithoutFilter(NbdKpiDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NbdKpiDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NbdKpiDO[] disableVOWithoutFilter(NbdKpiDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NbdKpiDO[] dos) throws BizException ;
}
