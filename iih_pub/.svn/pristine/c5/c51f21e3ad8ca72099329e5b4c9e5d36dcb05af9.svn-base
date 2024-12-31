package iih.mc.st.trreqapimpl.i;

import xap.mw.core.data.BizException;
import iih.mc.st.trreqapimpl.d.McTrReqApImplDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 调拨单数据维护服务
*/
public interface ITrreqapimplMDOCudService {
	/**
	*  调拨单数据真删除
	*/
    public abstract void delete(McTrReqApImplDO[] aggdos) throws BizException;
    
    /**
	*  调拨单数据插入保存
	*/
	public abstract McTrReqApImplDO[] insert(McTrReqApImplDO[] aggdos) throws BizException;
	
    /**
	*  调拨单数据保存
	*/
	public abstract McTrReqApImplDO[] save(McTrReqApImplDO[] aggdos) throws BizException;
	
    /**
	*  调拨单数据更新
	*/
	public abstract McTrReqApImplDO[] update(McTrReqApImplDO[] aggdos) throws BizException;
	
	/**
	*  调拨单数据逻辑删除
	*/
	public abstract void logicDelete(McTrReqApImplDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public McTrReqApImplDO[] enableWithoutFilter(McTrReqApImplDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(McTrReqApImplDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public McTrReqApImplDO[] disableVOWithoutFilter(McTrReqApImplDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(McTrReqApImplDO[] aggdos) throws BizException ;
	
}
