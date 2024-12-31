package iih.bd.srv.srvreact.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.srvreact.d.SrvReactItemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 服务互斥数据维护服务
*/
public interface ISrvReactItemDOCudService {
	/**
	*  服务互斥数据真删除
	*/
    public abstract void delete(SrvReactItemDO[] aggdos) throws BizException;
    
    /**
	*  服务互斥数据插入保存
	*/
	public abstract SrvReactItemDO[] insert(SrvReactItemDO[] aggdos) throws BizException;
	
    /**
	*  服务互斥数据保存
	*/
	public abstract SrvReactItemDO[] save(SrvReactItemDO[] aggdos) throws BizException;
	
    /**
	*  服务互斥数据更新
	*/
	public abstract SrvReactItemDO[] update(SrvReactItemDO[] aggdos) throws BizException;
	
	/**
	*  服务互斥数据逻辑删除
	*/
	public abstract void logicDelete(SrvReactItemDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SrvReactItemDO[] enableWithoutFilter(SrvReactItemDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SrvReactItemDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SrvReactItemDO[] disableVOWithoutFilter(SrvReactItemDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SrvReactItemDO[] aggdos) throws BizException ;
	
}
