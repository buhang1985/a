package iih.ci.ord.orderchangeprn.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.orderchangeprn.d.CiOrChangePrnDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医嘱变更打印数据维护服务
*/
public interface IOrderchangeprnCudService {
	/**
	*  医嘱变更打印数据真删除
	*/
    public abstract void delete(CiOrChangePrnDO[] aggdos) throws BizException;
    
    /**
	*  医嘱变更打印数据插入保存
	*/
	public abstract CiOrChangePrnDO[] insert(CiOrChangePrnDO[] aggdos) throws BizException;
	
    /**
	*  医嘱变更打印数据保存
	*/
	public abstract CiOrChangePrnDO[] save(CiOrChangePrnDO[] aggdos) throws BizException;
	
    /**
	*  医嘱变更打印数据更新
	*/
	public abstract CiOrChangePrnDO[] update(CiOrChangePrnDO[] aggdos) throws BizException;
	
	/**
	*  医嘱变更打印数据逻辑删除
	*/
	public abstract void logicDelete(CiOrChangePrnDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiOrChangePrnDO[] enableWithoutFilter(CiOrChangePrnDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiOrChangePrnDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiOrChangePrnDO[] disableVOWithoutFilter(CiOrChangePrnDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiOrChangePrnDO[] dos) throws BizException ;
}
