package iih.bl.st.blhperror.i;

import xap.mw.core.data.BizException;
import iih.bl.st.blhperror.d.BlHpErrorDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保异常交易记录数据维护服务
*/
public interface IBlhperrorCudService {
	/**
	*  医保异常交易记录数据真删除
	*/
    public abstract void delete(BlHpErrorDO[] aggdos) throws BizException;
    
    /**
	*  医保异常交易记录数据插入保存
	*/
	public abstract BlHpErrorDO[] insert(BlHpErrorDO[] aggdos) throws BizException;
	
    /**
	*  医保异常交易记录数据保存
	*/
	public abstract BlHpErrorDO[] save(BlHpErrorDO[] aggdos) throws BizException;
	
    /**
	*  医保异常交易记录数据更新
	*/
	public abstract BlHpErrorDO[] update(BlHpErrorDO[] aggdos) throws BizException;
	
	/**
	*  医保异常交易记录数据逻辑删除
	*/
	public abstract void logicDelete(BlHpErrorDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlHpErrorDO[] enableWithoutFilter(BlHpErrorDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlHpErrorDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlHpErrorDO[] disableVOWithoutFilter(BlHpErrorDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlHpErrorDO[] dos) throws BizException ;
}
