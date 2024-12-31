package iih.pe.papt.pebarcode.i;

import xap.mw.core.data.BizException;
import iih.pe.papt.pebarcode.d.PeBarcodeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检接口_LIS团体条码数据维护服务
*/
public interface IPebarcodeCudService {
	/**
	*  体检接口_LIS团体条码数据真删除
	*/
    public abstract void delete(PeBarcodeDO[] aggdos) throws BizException;
    
    /**
	*  体检接口_LIS团体条码数据插入保存
	*/
	public abstract PeBarcodeDO[] insert(PeBarcodeDO[] aggdos) throws BizException;
	
    /**
	*  体检接口_LIS团体条码数据保存
	*/
	public abstract PeBarcodeDO[] save(PeBarcodeDO[] aggdos) throws BizException;
	
    /**
	*  体检接口_LIS团体条码数据更新
	*/
	public abstract PeBarcodeDO[] update(PeBarcodeDO[] aggdos) throws BizException;
	
	/**
	*  体检接口_LIS团体条码数据逻辑删除
	*/
	public abstract void logicDelete(PeBarcodeDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeBarcodeDO[] enableWithoutFilter(PeBarcodeDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeBarcodeDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeBarcodeDO[] disableVOWithoutFilter(PeBarcodeDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeBarcodeDO[] dos) throws BizException ;
}
