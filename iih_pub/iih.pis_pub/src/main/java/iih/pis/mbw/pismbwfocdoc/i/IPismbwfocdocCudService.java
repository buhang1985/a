package iih.pis.mbw.pismbwfocdoc.i;

import xap.mw.core.data.BizException;
import iih.pis.mbw.pismbwfocdoc.d.PisMbwFocdocDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 关注医生数据维护服务
*/
public interface IPismbwfocdocCudService {
	/**
	*  关注医生数据真删除
	*/
    public abstract void delete(PisMbwFocdocDO[] aggdos) throws BizException;
    
    /**
	*  关注医生数据插入保存
	*/
	public abstract PisMbwFocdocDO[] insert(PisMbwFocdocDO[] aggdos) throws BizException;
	
    /**
	*  关注医生数据保存
	*/
	public abstract PisMbwFocdocDO[] save(PisMbwFocdocDO[] aggdos) throws BizException;
	
    /**
	*  关注医生数据更新
	*/
	public abstract PisMbwFocdocDO[] update(PisMbwFocdocDO[] aggdos) throws BizException;
	
	/**
	*  关注医生数据逻辑删除
	*/
	public abstract void logicDelete(PisMbwFocdocDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PisMbwFocdocDO[] enableWithoutFilter(PisMbwFocdocDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PisMbwFocdocDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PisMbwFocdocDO[] disableVOWithoutFilter(PisMbwFocdocDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PisMbwFocdocDO[] dos) throws BizException ;
}