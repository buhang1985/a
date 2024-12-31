package iih.bd.pp.bdhpsrvctr.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.bdhpsrvctr.d.BdHpSrvctrDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 付款策略_医保计划_控制策略数据维护服务
*/
public interface IBdhpsrvctrCudService {
	/**
	*  付款策略_医保计划_控制策略数据真删除
	*/
    public abstract void delete(BdHpSrvctrDO[] aggdos) throws BizException;
    
    /**
	*  付款策略_医保计划_控制策略数据插入保存
	*/
	public abstract BdHpSrvctrDO[] insert(BdHpSrvctrDO[] aggdos) throws BizException;
	
    /**
	*  付款策略_医保计划_控制策略数据保存
	*/
	public abstract BdHpSrvctrDO[] save(BdHpSrvctrDO[] aggdos) throws BizException;
	
    /**
	*  付款策略_医保计划_控制策略数据更新
	*/
	public abstract BdHpSrvctrDO[] update(BdHpSrvctrDO[] aggdos) throws BizException;
	
	/**
	*  付款策略_医保计划_控制策略数据逻辑删除
	*/
	public abstract void logicDelete(BdHpSrvctrDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdHpSrvctrDO[] enableWithoutFilter(BdHpSrvctrDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdHpSrvctrDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdHpSrvctrDO[] disableVOWithoutFilter(BdHpSrvctrDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdHpSrvctrDO[] dos) throws BizException ;
}
