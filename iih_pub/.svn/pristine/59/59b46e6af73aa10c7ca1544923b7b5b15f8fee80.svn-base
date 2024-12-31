package iih.bd.bc.condition.i;

import xap.mw.core.data.BizException;
import iih.bd.bc.condition.d.ConditionDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 条件指标数据维护服务
*/
public interface IConditionCudService {
	/**
	*  条件指标数据删除
	*/
    public abstract void delete(ConditionDO[] aggdos) throws BizException;
    
    /**
	*  条件指标数据插入保存
	*/
	public abstract ConditionDO[] insert(ConditionDO[] aggdos) throws BizException;
	
    /**
	*  条件指标数据保存
	*/
	public abstract ConditionDO[] save(ConditionDO[] aggdos) throws BizException;
	
    /**
	*  条件指标数据更新
	*/
	public abstract ConditionDO[] update(ConditionDO[] aggdos) throws BizException;
	
	/**
	*  条件指标数据真删
	*/
	public abstract void logicDelete(ConditionDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ConditionDO[] enableWithoutFilter(ConditionDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ConditionDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ConditionDO[] disableVOWithoutFilter(ConditionDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ConditionDO[] aggdos) throws BizException ;
}
