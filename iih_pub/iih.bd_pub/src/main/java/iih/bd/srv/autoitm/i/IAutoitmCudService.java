package iih.bd.srv.autoitm.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.autoitm.d.AutoItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 自动质控控制表bd数据维护服务
*/
public interface IAutoitmCudService {
	/**
	*  自动质控控制表bd数据真删除
	*/
    public abstract void delete(AutoItmDO[] aggdos) throws BizException;
    
    /**
	*  自动质控控制表bd数据插入保存
	*/
	public abstract AutoItmDO[] insert(AutoItmDO[] aggdos) throws BizException;
	
    /**
	*  自动质控控制表bd数据保存
	*/
	public abstract AutoItmDO[] save(AutoItmDO[] aggdos) throws BizException;
	
    /**
	*  自动质控控制表bd数据更新
	*/
	public abstract AutoItmDO[] update(AutoItmDO[] aggdos) throws BizException;
	
	/**
	*  自动质控控制表bd数据逻辑删除
	*/
	public abstract void logicDelete(AutoItmDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public AutoItmDO[] enableWithoutFilter(AutoItmDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(AutoItmDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public AutoItmDO[] disableVOWithoutFilter(AutoItmDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(AutoItmDO[] dos) throws BizException ;
}
