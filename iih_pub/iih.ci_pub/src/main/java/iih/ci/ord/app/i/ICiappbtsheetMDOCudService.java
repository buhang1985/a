package iih.ci.ord.app.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.app.d.CiAppBtSheetDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 备血打印申请单数据维护服务
*/
public interface ICiappbtsheetMDOCudService {
	/**
	*  备血打印申请单数据真删除
	*/
    public abstract void delete(CiAppBtSheetDO[] aggdos) throws BizException;
    
    /**
	*  备血打印申请单数据插入保存
	*/
	public abstract CiAppBtSheetDO[] insert(CiAppBtSheetDO[] aggdos) throws BizException;
	
    /**
	*  备血打印申请单数据保存
	*/
	public abstract CiAppBtSheetDO[] save(CiAppBtSheetDO[] aggdos) throws BizException;
	
    /**
	*  备血打印申请单数据更新
	*/
	public abstract CiAppBtSheetDO[] update(CiAppBtSheetDO[] aggdos) throws BizException;
	
	/**
	*  备血打印申请单数据逻辑删除
	*/
	public abstract void logicDelete(CiAppBtSheetDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiAppBtSheetDO[] enableWithoutFilter(CiAppBtSheetDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiAppBtSheetDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiAppBtSheetDO[] disableVOWithoutFilter(CiAppBtSheetDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiAppBtSheetDO[] aggdos) throws BizException ;
	
}
