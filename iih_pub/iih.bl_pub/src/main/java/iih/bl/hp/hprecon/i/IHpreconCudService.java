package iih.bl.hp.hprecon.i;

import xap.mw.core.data.BizException;
import iih.bl.hp.hprecon.d.BlHpReconciliationDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保对账下载数据数据维护服务
*/
public interface IHpreconCudService {
	/**
	*  医保对账下载数据数据真删除
	*/
    public abstract void delete(BlHpReconciliationDO[] aggdos) throws BizException;
    
    /**
	*  医保对账下载数据数据插入保存
	*/
	public abstract BlHpReconciliationDO[] insert(BlHpReconciliationDO[] aggdos) throws BizException;
	
    /**
	*  医保对账下载数据数据保存
	*/
	public abstract BlHpReconciliationDO[] save(BlHpReconciliationDO[] aggdos) throws BizException;
	
    /**
	*  医保对账下载数据数据更新
	*/
	public abstract BlHpReconciliationDO[] update(BlHpReconciliationDO[] aggdos) throws BizException;
	
	/**
	*  医保对账下载数据数据逻辑删除
	*/
	public abstract void logicDelete(BlHpReconciliationDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlHpReconciliationDO[] enableWithoutFilter(BlHpReconciliationDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlHpReconciliationDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlHpReconciliationDO[] disableVOWithoutFilter(BlHpReconciliationDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlHpReconciliationDO[] dos) throws BizException ;
}
