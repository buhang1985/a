package iih.bd.srv.relmmbagtactics.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.relmmbagtactics.d.RelMmBagTacticsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 药品关联药袋费策略数据维护服务
*/
public interface IRelmmbagtacticsCudService {
	/**
	*  药品关联药袋费策略数据真删除
	*/
    public abstract void delete(RelMmBagTacticsDO[] aggdos) throws BizException;
    
    /**
	*  药品关联药袋费策略数据插入保存
	*/
	public abstract RelMmBagTacticsDO[] insert(RelMmBagTacticsDO[] aggdos) throws BizException;
	
    /**
	*  药品关联药袋费策略数据保存
	*/
	public abstract RelMmBagTacticsDO[] save(RelMmBagTacticsDO[] aggdos) throws BizException;
	
    /**
	*  药品关联药袋费策略数据更新
	*/
	public abstract RelMmBagTacticsDO[] update(RelMmBagTacticsDO[] aggdos) throws BizException;
	
	/**
	*  药品关联药袋费策略数据逻辑删除
	*/
	public abstract void logicDelete(RelMmBagTacticsDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public RelMmBagTacticsDO[] enableWithoutFilter(RelMmBagTacticsDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(RelMmBagTacticsDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public RelMmBagTacticsDO[] disableVOWithoutFilter(RelMmBagTacticsDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(RelMmBagTacticsDO[] dos) throws BizException ;
}
