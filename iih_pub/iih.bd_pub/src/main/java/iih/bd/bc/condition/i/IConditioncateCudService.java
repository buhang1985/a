package iih.bd.bc.condition.i;

import xap.mw.core.data.BizException;
import iih.bd.bc.condition.d.ConditionCateDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 条件指标分类数据维护服务
*/
public interface IConditioncateCudService {
	/**
	*  条件指标分类数据删除
	*/
    public abstract void delete(ConditionCateDO[] aggdos) throws BizException;
    
    /**
	*  条件指标分类数据插入保存
	*/
	public abstract ConditionCateDO[] insert(ConditionCateDO[] aggdos) throws BizException;
	
    /**
	*  条件指标分类数据保存
	*/
	public abstract ConditionCateDO[] save(ConditionCateDO[] aggdos) throws BizException;
	
    /**
	*  条件指标分类数据更新
	*/
	public abstract ConditionCateDO[] update(ConditionCateDO[] aggdos) throws BizException;
	
	/**
	*  条件指标分类数据真删
	*/
	public abstract void logicDelete(ConditionCateDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ConditionCateDO[] enableWithoutFilter(ConditionCateDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ConditionCateDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ConditionCateDO[] disableVOWithoutFilter(ConditionCateDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ConditionCateDO[] aggdos) throws BizException ;
}
