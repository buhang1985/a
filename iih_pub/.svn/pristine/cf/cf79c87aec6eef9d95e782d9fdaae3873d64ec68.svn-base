package iih.bd.fc.querule.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.querule.d.QueRuleDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 队列规则数据维护服务
*/
public interface IQueruleMDOCudService {
	/**
	*  队列规则数据真删除
	*/
    public abstract void delete(QueRuleDO[] aggdos) throws BizException;
    
    /**
	*  队列规则数据插入保存
	*/
	public abstract QueRuleDO[] insert(QueRuleDO[] aggdos) throws BizException;
	
    /**
	*  队列规则数据保存
	*/
	public abstract QueRuleDO[] save(QueRuleDO[] aggdos) throws BizException;
	
    /**
	*  队列规则数据更新
	*/
	public abstract QueRuleDO[] update(QueRuleDO[] aggdos) throws BizException;
	
	/**
	*  队列规则数据逻辑删除
	*/
	public abstract void logicDelete(QueRuleDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public QueRuleDO[] enableWithoutFilter(QueRuleDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(QueRuleDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public QueRuleDO[] disableVOWithoutFilter(QueRuleDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(QueRuleDO[] aggdos) throws BizException ;
	
}
