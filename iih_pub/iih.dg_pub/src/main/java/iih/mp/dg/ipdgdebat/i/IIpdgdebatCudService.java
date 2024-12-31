package iih.mp.dg.ipdgdebat.i;

import xap.mw.core.data.BizException;
import iih.mp.dg.ipdgdebat.d.IpDgDeBatDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 住院药品批量发放数据维护服务
*/
public interface IIpdgdebatCudService {
	/**
	*  住院药品批量发放数据真删除
	*/
    public abstract void delete(IpDgDeBatDO[] aggdos) throws BizException;
    
    /**
	*  住院药品批量发放数据插入保存
	*/
	public abstract IpDgDeBatDO[] insert(IpDgDeBatDO[] aggdos) throws BizException;
	
    /**
	*  住院药品批量发放数据保存
	*/
	public abstract IpDgDeBatDO[] save(IpDgDeBatDO[] aggdos) throws BizException;
	
    /**
	*  住院药品批量发放数据更新
	*/
	public abstract IpDgDeBatDO[] update(IpDgDeBatDO[] aggdos) throws BizException;
	
	/**
	*  住院药品批量发放数据逻辑删除
	*/
	public abstract void logicDelete(IpDgDeBatDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public IpDgDeBatDO[] enableWithoutFilter(IpDgDeBatDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(IpDgDeBatDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public IpDgDeBatDO[] disableVOWithoutFilter(IpDgDeBatDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(IpDgDeBatDO[] dos) throws BizException ;
}
