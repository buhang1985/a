package iih.ems.embd.eminfo.i;

import xap.mw.core.data.BizException;
import iih.ems.embd.eminfo.d.EmsInfoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 设备基本信息数据维护服务
*/
public interface IEminfoCudService {
	/**
	*  设备基本信息数据真删除
	*/
    public abstract void delete(EmsInfoDO[] aggdos) throws BizException;
    
    /**
	*  设备基本信息数据插入保存
	*/
	public abstract EmsInfoDO[] insert(EmsInfoDO[] aggdos) throws BizException;
	
    /**
	*  设备基本信息数据保存
	*/
	public abstract EmsInfoDO[] save(EmsInfoDO[] aggdos) throws BizException;
	
    /**
	*  设备基本信息数据更新
	*/
	public abstract EmsInfoDO[] update(EmsInfoDO[] aggdos) throws BizException;
	
	/**
	*  设备基本信息数据逻辑删除
	*/
	public abstract void logicDelete(EmsInfoDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmsInfoDO[] enableWithoutFilter(EmsInfoDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmsInfoDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmsInfoDO[] disableVOWithoutFilter(EmsInfoDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmsInfoDO[] dos) throws BizException ;
}
