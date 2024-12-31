package iih.ems.emcm.emrep.i;

import xap.mw.core.data.BizException;
import iih.ems.emcm.emrep.d.EmsRepairDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 设备维修数据维护服务
*/
public interface IEmrepCudService {
	/**
	*  设备维修数据真删除
	*/
    public abstract void delete(EmsRepairDO[] aggdos) throws BizException;
    
    /**
	*  设备维修数据插入保存
	*/
	public abstract EmsRepairDO[] insert(EmsRepairDO[] aggdos) throws BizException;
	
    /**
	*  设备维修数据保存
	*/
	public abstract EmsRepairDO[] save(EmsRepairDO[] aggdos) throws BizException;
	
    /**
	*  设备维修数据更新
	*/
	public abstract EmsRepairDO[] update(EmsRepairDO[] aggdos) throws BizException;
	
	/**
	*  设备维修数据逻辑删除
	*/
	public abstract void logicDelete(EmsRepairDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmsRepairDO[] enableWithoutFilter(EmsRepairDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmsRepairDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmsRepairDO[] disableVOWithoutFilter(EmsRepairDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmsRepairDO[] dos) throws BizException ;
}
