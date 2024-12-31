package iih.mp.mpbd.tcstyle.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.tcstyle.d.TcstyleDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体温单样式数据维护服务
*/
public interface ITcstyleMDOCudService {
	/**
	*  体温单样式数据真删除
	*/
    public abstract void delete(TcstyleDO[] aggdos) throws BizException;
    
    /**
	*  体温单样式数据插入保存
	*/
	public abstract TcstyleDO[] insert(TcstyleDO[] aggdos) throws BizException;
	
    /**
	*  体温单样式数据保存
	*/
	public abstract TcstyleDO[] save(TcstyleDO[] aggdos) throws BizException;
	
    /**
	*  体温单样式数据更新
	*/
	public abstract TcstyleDO[] update(TcstyleDO[] aggdos) throws BizException;
	
	/**
	*  体温单样式数据逻辑删除
	*/
	public abstract void logicDelete(TcstyleDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public TcstyleDO[] enableWithoutFilter(TcstyleDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(TcstyleDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public TcstyleDO[] disableVOWithoutFilter(TcstyleDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(TcstyleDO[] aggdos) throws BizException ;
	
}
