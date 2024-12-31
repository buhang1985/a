package iih.bl.st.blstproxyhp.i;

import xap.mw.core.data.BizException;
import iih.bl.st.blstproxyhp.d.BlStProxyhpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 代报结算_门急诊转住院数据维护服务
*/
public interface IBlstproxyhpMDOCudService {
	/**
	*  代报结算_门急诊转住院数据真删除
	*/
    public abstract void delete(BlStProxyhpDO[] aggdos) throws BizException;
    
    /**
	*  代报结算_门急诊转住院数据插入保存
	*/
	public abstract BlStProxyhpDO[] insert(BlStProxyhpDO[] aggdos) throws BizException;
	
    /**
	*  代报结算_门急诊转住院数据保存
	*/
	public abstract BlStProxyhpDO[] save(BlStProxyhpDO[] aggdos) throws BizException;
	
    /**
	*  代报结算_门急诊转住院数据更新
	*/
	public abstract BlStProxyhpDO[] update(BlStProxyhpDO[] aggdos) throws BizException;
	
	/**
	*  代报结算_门急诊转住院数据逻辑删除
	*/
	public abstract void logicDelete(BlStProxyhpDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlStProxyhpDO[] enableWithoutFilter(BlStProxyhpDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlStProxyhpDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlStProxyhpDO[] disableVOWithoutFilter(BlStProxyhpDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlStProxyhpDO[] aggdos) throws BizException ;
	
}
