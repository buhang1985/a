package iih.bl.st.blpaypatip.i;

import xap.mw.core.data.BizException;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 住院患者结算收付款数据维护服务
*/
public interface IBlPayItmPatIpDOCudService {
	/**
	*  住院患者结算收付款数据真删除
	*/
    public abstract void delete(BlPayItmPatIpDO[] aggdos) throws BizException;
    
    /**
	*  住院患者结算收付款数据插入保存
	*/
	public abstract BlPayItmPatIpDO[] insert(BlPayItmPatIpDO[] aggdos) throws BizException;
	
    /**
	*  住院患者结算收付款数据保存
	*/
	public abstract BlPayItmPatIpDO[] save(BlPayItmPatIpDO[] aggdos) throws BizException;
	
    /**
	*  住院患者结算收付款数据更新
	*/
	public abstract BlPayItmPatIpDO[] update(BlPayItmPatIpDO[] aggdos) throws BizException;
	
	/**
	*  住院患者结算收付款数据逻辑删除
	*/
	public abstract void logicDelete(BlPayItmPatIpDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlPayItmPatIpDO[] enableWithoutFilter(BlPayItmPatIpDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlPayItmPatIpDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlPayItmPatIpDO[] disableVOWithoutFilter(BlPayItmPatIpDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlPayItmPatIpDO[] aggdos) throws BizException ;
	
}
