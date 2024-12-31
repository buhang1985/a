package iih.bl.hp.hpcheckaccount.i;

import xap.mw.core.data.BizException;
import iih.bl.hp.hpcheckaccount.d.BlHpCheckAccountDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保医疗费统计查询对账日志数据维护服务
*/
public interface IHpcheckaccountCudService {
	/**
	*  医保医疗费统计查询对账日志数据真删除
	*/
    public abstract void delete(BlHpCheckAccountDO[] aggdos) throws BizException;
    
    /**
	*  医保医疗费统计查询对账日志数据插入保存
	*/
	public abstract BlHpCheckAccountDO[] insert(BlHpCheckAccountDO[] aggdos) throws BizException;
	
    /**
	*  医保医疗费统计查询对账日志数据保存
	*/
	public abstract BlHpCheckAccountDO[] save(BlHpCheckAccountDO[] aggdos) throws BizException;
	
    /**
	*  医保医疗费统计查询对账日志数据更新
	*/
	public abstract BlHpCheckAccountDO[] update(BlHpCheckAccountDO[] aggdos) throws BizException;
	
	/**
	*  医保医疗费统计查询对账日志数据逻辑删除
	*/
	public abstract void logicDelete(BlHpCheckAccountDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlHpCheckAccountDO[] enableWithoutFilter(BlHpCheckAccountDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlHpCheckAccountDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlHpCheckAccountDO[] disableVOWithoutFilter(BlHpCheckAccountDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlHpCheckAccountDO[] dos) throws BizException ;
}
