package iih.pis.ivx.pisivxsrvmenu.i;

import xap.mw.core.data.BizException;
import iih.pis.ivx.pisivxsrvmenu.d.PisIvxSrvMenuDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 服务号菜单数据维护服务
*/
public interface IPisivxsrvmenuMDOCudService {
	/**
	*  服务号菜单数据真删除
	*/
    public abstract void delete(PisIvxSrvMenuDO[] aggdos) throws BizException;
    
    /**
	*  服务号菜单数据插入保存
	*/
	public abstract PisIvxSrvMenuDO[] insert(PisIvxSrvMenuDO[] aggdos) throws BizException;
	
    /**
	*  服务号菜单数据保存
	*/
	public abstract PisIvxSrvMenuDO[] save(PisIvxSrvMenuDO[] aggdos) throws BizException;
	
    /**
	*  服务号菜单数据更新
	*/
	public abstract PisIvxSrvMenuDO[] update(PisIvxSrvMenuDO[] aggdos) throws BizException;
	
	/**
	*  服务号菜单数据逻辑删除
	*/
	public abstract void logicDelete(PisIvxSrvMenuDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PisIvxSrvMenuDO[] enableWithoutFilter(PisIvxSrvMenuDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PisIvxSrvMenuDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PisIvxSrvMenuDO[] disableVOWithoutFilter(PisIvxSrvMenuDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PisIvxSrvMenuDO[] aggdos) throws BizException ;
	
}
