package iih.hp.cp.ele.i;

import xap.mw.core.data.BizException;
import iih.hp.cp.ele.d.HpCpElemOrderDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 诊疗计划元素数据维护服务
*/
public interface IHpCpElemOrderDOCudService {
	/**
	*  诊疗计划元素数据真删除
	*/
    public abstract void delete(HpCpElemOrderDO[] aggdos) throws BizException;
    
    /**
	*  诊疗计划元素数据插入保存
	*/
	public abstract HpCpElemOrderDO[] insert(HpCpElemOrderDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划元素数据保存
	*/
	public abstract HpCpElemOrderDO[] save(HpCpElemOrderDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划元素数据更新
	*/
	public abstract HpCpElemOrderDO[] update(HpCpElemOrderDO[] aggdos) throws BizException;
	
	/**
	*  诊疗计划元素数据逻辑删除
	*/
	public abstract void logicDelete(HpCpElemOrderDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpCpElemOrderDO[] enableWithoutFilter(HpCpElemOrderDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpCpElemOrderDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpCpElemOrderDO[] disableVOWithoutFilter(HpCpElemOrderDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpCpElemOrderDO[] aggdos) throws BizException ;
	
}
