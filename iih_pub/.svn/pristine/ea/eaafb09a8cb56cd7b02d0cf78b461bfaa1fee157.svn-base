package iih.mc.po.settlement.i;

import xap.mw.core.data.BizException;
import iih.mc.po.settlement.d.McSettlementDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 采购发票结算数据维护服务
*/
public interface ISettlementMDOCudService {
	/**
	*  采购发票结算数据真删除
	*/
    public abstract void delete(McSettlementDO[] aggdos) throws BizException;
    
    /**
	*  采购发票结算数据插入保存
	*/
	public abstract McSettlementDO[] insert(McSettlementDO[] aggdos) throws BizException;
	
    /**
	*  采购发票结算数据保存
	*/
	public abstract McSettlementDO[] save(McSettlementDO[] aggdos) throws BizException;
	
    /**
	*  采购发票结算数据更新
	*/
	public abstract McSettlementDO[] update(McSettlementDO[] aggdos) throws BizException;
	
	/**
	*  采购发票结算数据逻辑删除
	*/
	public abstract void logicDelete(McSettlementDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public McSettlementDO[] enableWithoutFilter(McSettlementDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(McSettlementDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public McSettlementDO[] disableVOWithoutFilter(McSettlementDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(McSettlementDO[] aggdos) throws BizException ;
	
}
