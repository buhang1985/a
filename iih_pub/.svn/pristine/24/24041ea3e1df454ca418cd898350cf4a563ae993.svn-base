package iih.bd.pp.prisrvsetmu.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.prisrvsetmu.d.PriSrvSetMuDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 服务套数量加收数据维护服务
*/
public interface IPrisrvsetmuCudService {
	/**
	*  服务套数量加收数据删除
	*/
    public abstract void delete(PriSrvSetMuDO[] aggdos) throws BizException;
    
    /**
	*  服务套数量加收数据插入保存
	*/
	public abstract PriSrvSetMuDO[] insert(PriSrvSetMuDO[] aggdos) throws BizException;
	
    /**
	*  服务套数量加收数据保存
	*/
	public abstract PriSrvSetMuDO[] save(PriSrvSetMuDO[] aggdos) throws BizException;
	
    /**
	*  服务套数量加收数据更新
	*/
	public abstract PriSrvSetMuDO[] update(PriSrvSetMuDO[] aggdos) throws BizException;
	
	/**
	*  服务套数量加收数据逻辑删除
	*/
	public abstract void logicDelete(PriSrvSetMuDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PriSrvSetMuDO[] enableWithoutFilter(PriSrvSetMuDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PriSrvSetMuDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PriSrvSetMuDO[] disableVOWithoutFilter(PriSrvSetMuDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PriSrvSetMuDO[] aggdos) throws BizException ;
}
