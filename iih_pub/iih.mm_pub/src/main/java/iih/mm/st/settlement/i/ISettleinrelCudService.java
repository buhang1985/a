package iih.mm.st.settlement.i;

import xap.mw.core.data.BizException;
import iih.mm.st.settlement.d.SettlementInRelDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 结算回冲关系数据维护服务
*/
public interface ISettleinrelCudService {
	/**
	*  结算回冲关系数据删除
	*/
    public abstract void logicDelete(SettlementInRelDO[] aggdos) throws BizException;
    
    /**
	*  结算回冲关系数据插入保存
	*/
	public abstract SettlementInRelDO[] insert(SettlementInRelDO[] aggdos) throws BizException;
	
    /**
	*  结算回冲关系数据保存
	*/
	public abstract SettlementInRelDO[] save(SettlementInRelDO[] aggdos) throws BizException;
	
    /**
	*  结算回冲关系数据更新
	*/
	public abstract SettlementInRelDO[] update(SettlementInRelDO[] aggdos) throws BizException;
	
	/**
	*  结算回冲关系数据真删
	*/
	public abstract void delete(SettlementInRelDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SettlementInRelDO[] enableWithoutFilter(SettlementInRelDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SettlementInRelDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SettlementInRelDO[] disableVOWithoutFilter(SettlementInRelDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SettlementInRelDO[] dos) throws BizException ;
}
