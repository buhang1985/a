package iih.bd.srv.fs.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.fs.d.MrtplFSDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 组件数据维护服务
*/
public interface IMrtplfsCudService {
	/**
	*  组件数据删除
	*/
    public abstract void logicDelete(MrtplFSDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract MrtplFSDO[] insert(MrtplFSDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract MrtplFSDO[] save(MrtplFSDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract MrtplFSDO[] update(MrtplFSDO[] aggdos) throws BizException;
	
	/**
	*  组件数据真删
	*/
	public abstract void delete(MrtplFSDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MrtplFSDO[] enableWithoutFilter(MrtplFSDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MrtplFSDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MrtplFSDO[] disableVOWithoutFilter(MrtplFSDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MrtplFSDO[] aggdos) throws BizException ;
}
