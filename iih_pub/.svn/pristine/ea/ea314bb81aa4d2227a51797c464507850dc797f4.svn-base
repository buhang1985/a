package iih.en.er.op.i;

import xap.mw.core.data.BizException;
import iih.en.er.op.d.EnEntOpErDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 门诊_急诊数据维护服务
*/
public interface IEnentoperCudService {
	/**
	*  门诊_急诊数据真删除
	*/
    public abstract void delete(EnEntOpErDO[] aggdos) throws BizException;
    
    /**
	*  门诊_急诊数据插入保存
	*/
	public abstract EnEntOpErDO[] insert(EnEntOpErDO[] aggdos) throws BizException;
	
    /**
	*  门诊_急诊数据保存
	*/
	public abstract EnEntOpErDO[] save(EnEntOpErDO[] aggdos) throws BizException;
	
    /**
	*  门诊_急诊数据更新
	*/
	public abstract EnEntOpErDO[] update(EnEntOpErDO[] aggdos) throws BizException;
	
	/**
	*  门诊_急诊数据逻辑删除
	*/
	public abstract void logicDelete(EnEntOpErDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnEntOpErDO[] enableWithoutFilter(EnEntOpErDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnEntOpErDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnEntOpErDO[] disableVOWithoutFilter(EnEntOpErDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnEntOpErDO[] dos) throws BizException ;
}
