package iih.bd.srv.medsrv.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.medsrv.d.MedSrvrelFuncDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医疗服务数据维护服务
*/
public interface IMedSrvrelFuncDOCudService {
	/**
	*  医疗服务数据删除
	*/
    public abstract void delete(MedSrvrelFuncDO[] aggdos) throws BizException;
    
    /**
	*  医疗服务数据插入保存
	*/
	public abstract MedSrvrelFuncDO[] insert(MedSrvrelFuncDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务数据保存
	*/
	public abstract MedSrvrelFuncDO[] save(MedSrvrelFuncDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务数据更新
	*/
	public abstract MedSrvrelFuncDO[] update(MedSrvrelFuncDO[] aggdos) throws BizException;
	
	/**
	*  医疗服务数据真删
	*/
	public abstract void logicDelete(MedSrvrelFuncDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MedSrvrelFuncDO[] enableWithoutFilter(MedSrvrelFuncDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MedSrvrelFuncDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MedSrvrelFuncDO[] disableVOWithoutFilter(MedSrvrelFuncDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MedSrvrelFuncDO[] aggdos) throws BizException ;
	
}
