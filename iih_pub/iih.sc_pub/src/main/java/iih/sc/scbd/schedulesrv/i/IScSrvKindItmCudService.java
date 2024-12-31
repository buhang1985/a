package iih.sc.scbd.schedulesrv.i;

import xap.mw.core.data.BizException;
import iih.sc.scbd.schedulesrv.d.ScSrvKindItm;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 排班服务类别数据维护服务
*/
public interface IScSrvKindItmCudService {
	/**
	*  排班服务类别数据真删除
	*/
    public abstract void delete(ScSrvKindItm[] aggdos) throws BizException;
    
    /**
	*  排班服务类别数据插入保存
	*/
	public abstract ScSrvKindItm[] insert(ScSrvKindItm[] aggdos) throws BizException;
	
    /**
	*  排班服务类别数据保存
	*/
	public abstract ScSrvKindItm[] save(ScSrvKindItm[] aggdos) throws BizException;
	
    /**
	*  排班服务类别数据更新
	*/
	public abstract ScSrvKindItm[] update(ScSrvKindItm[] aggdos) throws BizException;
	
	/**
	*  排班服务类别数据逻辑删除
	*/
	public abstract void logicDelete(ScSrvKindItm[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScSrvKindItm[] enableWithoutFilter(ScSrvKindItm[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScSrvKindItm[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScSrvKindItm[] disableVOWithoutFilter(ScSrvKindItm[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScSrvKindItm[] aggdos) throws BizException ;
	
}
