package iih.bl.pay.blprepaypatacc.i;

import xap.mw.core.data.BizException;
import iih.bl.pay.blprepaypatacc.d.BlPrepayPatAccDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 预交金账目流水数据维护服务
*/
public interface IBlprepaypataccCudService {
	/**
	*  预交金账目流水数据真删除
	*/
    public abstract void delete(BlPrepayPatAccDO[] aggdos) throws BizException;
    
    /**
	*  预交金账目流水数据插入保存
	*/
	public abstract BlPrepayPatAccDO[] insert(BlPrepayPatAccDO[] aggdos) throws BizException;
	
    /**
	*  预交金账目流水数据保存
	*/
	public abstract BlPrepayPatAccDO[] save(BlPrepayPatAccDO[] aggdos) throws BizException;
	
    /**
	*  预交金账目流水数据更新
	*/
	public abstract BlPrepayPatAccDO[] update(BlPrepayPatAccDO[] aggdos) throws BizException;
	
	/**
	*  预交金账目流水数据逻辑删除
	*/
	public abstract void logicDelete(BlPrepayPatAccDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlPrepayPatAccDO[] enableWithoutFilter(BlPrepayPatAccDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlPrepayPatAccDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlPrepayPatAccDO[] disableVOWithoutFilter(BlPrepayPatAccDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlPrepayPatAccDO[] dos) throws BizException ;
}
