package iih.mm.qy.settlementquery.i;

import xap.mw.core.data.BizException;
import iih.mm.qy.settlementquery.d.SettlementQueryView;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 采购结算查询数据维护服务
*/
public interface ISettlementqueryCudService {
	/**
	*  采购结算查询数据真删除
	*/
    public abstract void delete(SettlementQueryView[] aggdos) throws BizException;
    
    /**
	*  采购结算查询数据插入保存
	*/
	public abstract SettlementQueryView[] insert(SettlementQueryView[] aggdos) throws BizException;
	
    /**
	*  采购结算查询数据保存
	*/
	public abstract SettlementQueryView[] save(SettlementQueryView[] aggdos) throws BizException;
	
    /**
	*  采购结算查询数据更新
	*/
	public abstract SettlementQueryView[] update(SettlementQueryView[] aggdos) throws BizException;
	
	/**
	*  采购结算查询数据逻辑删除
	*/
	public abstract void logicDelete(SettlementQueryView[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SettlementQueryView[] enableWithoutFilter(SettlementQueryView[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SettlementQueryView[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SettlementQueryView[] disableVOWithoutFilter(SettlementQueryView[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SettlementQueryView[] dos) throws BizException ;
}
