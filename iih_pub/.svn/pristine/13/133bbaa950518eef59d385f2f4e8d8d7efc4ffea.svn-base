package iih.sc.scbd.schedulesrv.i;

import xap.mw.core.data.BizException;
import iih.sc.scbd.schedulesrv.d.ScSrvKindDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 排班服务类别数据维护服务
*/
public interface IScsrvkinddoMDOCudService {
	/**
	*  排班服务类别数据真删除
	*/
    public abstract void delete(ScSrvKindDO[] aggdos) throws BizException;
    
    /**
	*  排班服务类别数据插入保存
	*/
	public abstract ScSrvKindDO[] insert(ScSrvKindDO[] aggdos) throws BizException;
	
    /**
	*  排班服务类别数据保存
	*/
	public abstract ScSrvKindDO[] save(ScSrvKindDO[] aggdos) throws BizException;
	
    /**
	*  排班服务类别数据更新
	*/
	public abstract ScSrvKindDO[] update(ScSrvKindDO[] aggdos) throws BizException;
	
	/**
	*  排班服务类别数据逻辑删除
	*/
	public abstract void logicDelete(ScSrvKindDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScSrvKindDO[] enableWithoutFilter(ScSrvKindDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScSrvKindDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScSrvKindDO[] disableVOWithoutFilter(ScSrvKindDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScSrvKindDO[] aggdos) throws BizException ;
	
}
