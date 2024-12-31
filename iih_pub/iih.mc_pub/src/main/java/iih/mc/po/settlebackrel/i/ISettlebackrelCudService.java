package iih.mc.po.settlebackrel.i;

import xap.mw.core.data.BizException;
import iih.mc.po.settlebackrel.d.SettleBackRelDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 采购结算回冲关联关系数据维护服务
*/
public interface ISettlebackrelCudService {
	/**
	*  采购结算回冲关联关系数据真删除
	*/
    public abstract void delete(SettleBackRelDO[] aggdos) throws BizException;
    
    /**
	*  采购结算回冲关联关系数据插入保存
	*/
	public abstract SettleBackRelDO[] insert(SettleBackRelDO[] aggdos) throws BizException;
	
    /**
	*  采购结算回冲关联关系数据保存
	*/
	public abstract SettleBackRelDO[] save(SettleBackRelDO[] aggdos) throws BizException;
	
    /**
	*  采购结算回冲关联关系数据更新
	*/
	public abstract SettleBackRelDO[] update(SettleBackRelDO[] aggdos) throws BizException;
	
	/**
	*  采购结算回冲关联关系数据逻辑删除
	*/
	public abstract void logicDelete(SettleBackRelDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SettleBackRelDO[] enableWithoutFilter(SettleBackRelDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SettleBackRelDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SettleBackRelDO[] disableVOWithoutFilter(SettleBackRelDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SettleBackRelDO[] dos) throws BizException ;
}
