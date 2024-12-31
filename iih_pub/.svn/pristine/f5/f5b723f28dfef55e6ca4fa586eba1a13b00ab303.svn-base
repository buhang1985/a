package iih.bd.srv.itm.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.itm.d.ItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 质控项数据维护服务
*/
public interface IItmCudService {
	/**
	*  质控项数据真删除
	*/
    public abstract void delete(ItmDO[] aggdos) throws BizException;
    
    /**
	*  质控项数据插入保存
	*/
	public abstract ItmDO[] insert(ItmDO[] aggdos) throws BizException;
	
    /**
	*  质控项数据保存
	*/
	public abstract ItmDO[] save(ItmDO[] aggdos) throws BizException;
	
    /**
	*  质控项数据更新
	*/
	public abstract ItmDO[] update(ItmDO[] aggdos) throws BizException;
	
	/**
	*  质控项数据逻辑删除
	*/
	public abstract void logicDelete(ItmDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ItmDO[] enableWithoutFilter(ItmDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ItmDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ItmDO[] disableVOWithoutFilter(ItmDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ItmDO[] dos) throws BizException ;
}
