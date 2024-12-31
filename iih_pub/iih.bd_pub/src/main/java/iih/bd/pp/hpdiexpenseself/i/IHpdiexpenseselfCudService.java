package iih.bd.pp.hpdiexpenseself.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保计划自费诊断数据维护服务
*/
public interface IHpdiexpenseselfCudService {
	/**
	*  医保计划自费诊断数据真删除
	*/
    public abstract void delete(BdHpDiExpenseSelfDO[] aggdos) throws BizException;
    
    /**
	*  医保计划自费诊断数据插入保存
	*/
	public abstract BdHpDiExpenseSelfDO[] insert(BdHpDiExpenseSelfDO[] aggdos) throws BizException;
	
    /**
	*  医保计划自费诊断数据保存
	*/
	public abstract BdHpDiExpenseSelfDO[] save(BdHpDiExpenseSelfDO[] aggdos) throws BizException;
	
    /**
	*  医保计划自费诊断数据更新
	*/
	public abstract BdHpDiExpenseSelfDO[] update(BdHpDiExpenseSelfDO[] aggdos) throws BizException;
	
	/**
	*  医保计划自费诊断数据逻辑删除
	*/
	public abstract void logicDelete(BdHpDiExpenseSelfDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdHpDiExpenseSelfDO[] enableWithoutFilter(BdHpDiExpenseSelfDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdHpDiExpenseSelfDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdHpDiExpenseSelfDO[] disableVOWithoutFilter(BdHpDiExpenseSelfDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdHpDiExpenseSelfDO[] dos) throws BizException ;
}
