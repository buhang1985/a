package iih.bd.pp.prisrv.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.prisrv.d.PriSrvDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 本服务定价数据维护服务
*/
public interface IPrisrvCudService {
	/**
	*  本服务定价数据真删除
	*/
    public abstract void delete(PriSrvDO[] aggdos) throws BizException;
    
    /**
	*  本服务定价数据插入保存
	*/
	public abstract PriSrvDO[] insert(PriSrvDO[] aggdos) throws BizException;
	
    /**
	*  本服务定价数据保存
	*/
	public abstract PriSrvDO[] save(PriSrvDO[] aggdos) throws BizException;
	
    /**
	*  本服务定价数据更新
	*/
	public abstract PriSrvDO[] update(PriSrvDO[] aggdos) throws BizException;
	
	/**
	*  本服务定价数据逻辑删除
	*/
	public abstract void logicDelete(PriSrvDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PriSrvDO[] enableWithoutFilter(PriSrvDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PriSrvDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PriSrvDO[] disableVOWithoutFilter(PriSrvDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PriSrvDO[] dos) throws BizException ;
}
