package iih.ci.mrm.healthsystem.i;

import xap.mw.core.data.BizException;
import iih.ci.mrm.healthsystem.d.ContrastClassifyDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 对照分类数据维护服务
*/
public interface IHealthsystemMDOCudService {
	/**
	*  对照分类数据真删除
	*/
    public abstract void delete(ContrastClassifyDO[] aggdos) throws BizException;
    
    /**
	*  对照分类数据插入保存
	*/
	public abstract ContrastClassifyDO[] insert(ContrastClassifyDO[] aggdos) throws BizException;
	
    /**
	*  对照分类数据保存
	*/
	public abstract ContrastClassifyDO[] save(ContrastClassifyDO[] aggdos) throws BizException;
	
    /**
	*  对照分类数据更新
	*/
	public abstract ContrastClassifyDO[] update(ContrastClassifyDO[] aggdos) throws BizException;
	
	/**
	*  对照分类数据逻辑删除
	*/
	public abstract void logicDelete(ContrastClassifyDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ContrastClassifyDO[] enableWithoutFilter(ContrastClassifyDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ContrastClassifyDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ContrastClassifyDO[] disableVOWithoutFilter(ContrastClassifyDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ContrastClassifyDO[] aggdos) throws BizException ;
	
}
