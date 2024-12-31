package iih.ems.einv.emin.i;

import xap.mw.core.data.BizException;
import iih.ems.einv.emin.d.EmsInDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 设备入库数据维护服务
*/
public interface IEminMDOCudService {
	/**
	*  设备入库数据真删除
	*/
    public abstract void delete(EmsInDO[] aggdos) throws BizException;
    
    /**
	*  设备入库数据插入保存
	*/
	public abstract EmsInDO[] insert(EmsInDO[] aggdos) throws BizException;
	
    /**
	*  设备入库数据保存
	*/
	public abstract EmsInDO[] save(EmsInDO[] aggdos) throws BizException;
	
    /**
	*  设备入库数据更新
	*/
	public abstract EmsInDO[] update(EmsInDO[] aggdos) throws BizException;
	
	/**
	*  设备入库数据逻辑删除
	*/
	public abstract void logicDelete(EmsInDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmsInDO[] enableWithoutFilter(EmsInDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmsInDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmsInDO[] disableVOWithoutFilter(EmsInDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmsInDO[] aggdos) throws BizException ;
	
}