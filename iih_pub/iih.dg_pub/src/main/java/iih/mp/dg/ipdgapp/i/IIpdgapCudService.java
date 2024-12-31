package iih.mp.dg.ipdgapp.i;

import xap.mw.core.data.BizException;
import iih.mp.dg.ipdgapp.d.IpDgApDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 住院药品请领数据维护服务
*/
public interface IIpdgapCudService {
	/**
	*  住院药品请领数据删除
	*/
    public abstract void logicDelete(IpDgApDO[] aggdos) throws BizException;
    
    /**
	*  住院药品请领数据插入保存
	*/
	public abstract IpDgApDO[] insert(IpDgApDO[] aggdos) throws BizException;
	
    /**
	*  住院药品请领数据保存
	*/
	public abstract IpDgApDO[] save(IpDgApDO[] aggdos) throws BizException;
	
    /**
	*  住院药品请领数据更新
	*/
	public abstract IpDgApDO[] update(IpDgApDO[] aggdos) throws BizException;
	
	/**
	*  住院药品请领数据真删
	*/
	public abstract void delete(IpDgApDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public IpDgApDO[] enableWithoutFilter(IpDgApDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(IpDgApDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public IpDgApDO[] disableVOWithoutFilter(IpDgApDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(IpDgApDO[] aggdos) throws BizException ;
}
