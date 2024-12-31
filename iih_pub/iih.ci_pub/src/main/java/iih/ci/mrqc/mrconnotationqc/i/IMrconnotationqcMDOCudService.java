package iih.ci.mrqc.mrconnotationqc.i;

import xap.mw.core.data.BizException;
import iih.ci.mrqc.mrconnotationqc.d.MrConnotationQcDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* mrconnotationqcdo数据维护服务
*/
public interface IMrconnotationqcMDOCudService {
	/**
	*  mrconnotationqcdo数据真删除
	*/
    public abstract void delete(MrConnotationQcDO[] aggdos) throws BizException;
    
    /**
	*  mrconnotationqcdo数据插入保存
	*/
	public abstract MrConnotationQcDO[] insert(MrConnotationQcDO[] aggdos) throws BizException;
	
    /**
	*  mrconnotationqcdo数据保存
	*/
	public abstract MrConnotationQcDO[] save(MrConnotationQcDO[] aggdos) throws BizException;
	
    /**
	*  mrconnotationqcdo数据更新
	*/
	public abstract MrConnotationQcDO[] update(MrConnotationQcDO[] aggdos) throws BizException;
	
	/**
	*  mrconnotationqcdo数据逻辑删除
	*/
	public abstract void logicDelete(MrConnotationQcDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MrConnotationQcDO[] enableWithoutFilter(MrConnotationQcDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MrConnotationQcDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MrConnotationQcDO[] disableVOWithoutFilter(MrConnotationQcDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MrConnotationQcDO[] aggdos) throws BizException ;
	
}
