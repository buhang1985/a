package iih.ci.ord.ciaphvconsumables.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.ciaphvconsumables.d.CiApHvconsumblesDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医嘱高值耗材申请 数据维护服务
*/
public interface ICiaphvconsumablesMDOCudService {
	/**
	*  医嘱高值耗材申请 数据真删除
	*/
    public abstract void delete(CiApHvconsumblesDO[] aggdos) throws BizException;
    
    /**
	*  医嘱高值耗材申请 数据插入保存
	*/
	public abstract CiApHvconsumblesDO[] insert(CiApHvconsumblesDO[] aggdos) throws BizException;
	
    /**
	*  医嘱高值耗材申请 数据保存
	*/
	public abstract CiApHvconsumblesDO[] save(CiApHvconsumblesDO[] aggdos) throws BizException;
	
    /**
	*  医嘱高值耗材申请 数据更新
	*/
	public abstract CiApHvconsumblesDO[] update(CiApHvconsumblesDO[] aggdos) throws BizException;
	
	/**
	*  医嘱高值耗材申请 数据逻辑删除
	*/
	public abstract void logicDelete(CiApHvconsumblesDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiApHvconsumblesDO[] enableWithoutFilter(CiApHvconsumblesDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiApHvconsumblesDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiApHvconsumblesDO[] disableVOWithoutFilter(CiApHvconsumblesDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiApHvconsumblesDO[] aggdos) throws BizException ;
	
}
