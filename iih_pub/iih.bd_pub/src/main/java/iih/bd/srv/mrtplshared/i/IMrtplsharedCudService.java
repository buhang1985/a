package iih.bd.srv.mrtplshared.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrtplshared.d.MrtplSharedDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病历模板共享数据维护服务
*/
public interface IMrtplsharedCudService {
	/**
	*  病历模板共享数据真删除
	*/
    public abstract void delete(MrtplSharedDO[] aggdos) throws BizException;
    
    /**
	*  病历模板共享数据插入保存
	*/
	public abstract MrtplSharedDO[] insert(MrtplSharedDO[] aggdos) throws BizException;
	
    /**
	*  病历模板共享数据保存
	*/
	public abstract MrtplSharedDO[] save(MrtplSharedDO[] aggdos) throws BizException;
	
    /**
	*  病历模板共享数据更新
	*/
	public abstract MrtplSharedDO[] update(MrtplSharedDO[] aggdos) throws BizException;
	
	/**
	*  病历模板共享数据逻辑删除
	*/
	public abstract void logicDelete(MrtplSharedDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MrtplSharedDO[] enableWithoutFilter(MrtplSharedDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MrtplSharedDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MrtplSharedDO[] disableVOWithoutFilter(MrtplSharedDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MrtplSharedDO[] dos) throws BizException ;
}
