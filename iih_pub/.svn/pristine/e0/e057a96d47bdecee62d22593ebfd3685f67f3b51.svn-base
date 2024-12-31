package iih.ems.einv.eminsp.i;

import xap.mw.core.data.BizException;
import iih.ems.einv.eminsp.d.EmsInspItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 大型设备验收数据维护服务
*/
public interface IEmsInspItmDOCudService {
	/**
	*  大型设备验收数据真删除
	*/
    public abstract void delete(EmsInspItmDO[] aggdos) throws BizException;
    
    /**
	*  大型设备验收数据插入保存
	*/
	public abstract EmsInspItmDO[] insert(EmsInspItmDO[] aggdos) throws BizException;
	
    /**
	*  大型设备验收数据保存
	*/
	public abstract EmsInspItmDO[] save(EmsInspItmDO[] aggdos) throws BizException;
	
    /**
	*  大型设备验收数据更新
	*/
	public abstract EmsInspItmDO[] update(EmsInspItmDO[] aggdos) throws BizException;
	
	/**
	*  大型设备验收数据逻辑删除
	*/
	public abstract void logicDelete(EmsInspItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmsInspItmDO[] enableWithoutFilter(EmsInspItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmsInspItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmsInspItmDO[] disableVOWithoutFilter(EmsInspItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmsInspItmDO[] aggdos) throws BizException ;
	
}
