package iih.mc.pl.trrequestap.i;

import xap.mw.core.data.BizException;
import iih.mc.pl.trrequestap.d.McTrReqApOrderDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 调拨申请单数据维护服务
*/
public interface ITrrequestapMDOCudService {
	/**
	*  调拨申请单数据真删除
	*/
    public abstract void delete(McTrReqApOrderDO[] aggdos) throws BizException;
    
    /**
	*  调拨申请单数据插入保存
	*/
	public abstract McTrReqApOrderDO[] insert(McTrReqApOrderDO[] aggdos) throws BizException;
	
    /**
	*  调拨申请单数据保存
	*/
	public abstract McTrReqApOrderDO[] save(McTrReqApOrderDO[] aggdos) throws BizException;
	
    /**
	*  调拨申请单数据更新
	*/
	public abstract McTrReqApOrderDO[] update(McTrReqApOrderDO[] aggdos) throws BizException;
	
	/**
	*  调拨申请单数据逻辑删除
	*/
	public abstract void logicDelete(McTrReqApOrderDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public McTrReqApOrderDO[] enableWithoutFilter(McTrReqApOrderDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(McTrReqApOrderDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public McTrReqApOrderDO[] disableVOWithoutFilter(McTrReqApOrderDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(McTrReqApOrderDO[] aggdos) throws BizException ;
	
}
