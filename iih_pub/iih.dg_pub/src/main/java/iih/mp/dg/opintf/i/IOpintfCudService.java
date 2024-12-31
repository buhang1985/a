package iih.mp.dg.opintf.i;

import xap.mw.core.data.BizException;
import iih.mp.dg.opintf.d.OpPresStatusIntfDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 国药用处方获取数据维护服务
*/
public interface IOpintfCudService {
	/**
	*  国药用处方获取数据真删除
	*/
    public abstract void delete(OpPresStatusIntfDO[] aggdos) throws BizException;
    
    /**
	*  国药用处方获取数据插入保存
	*/
	public abstract OpPresStatusIntfDO[] insert(OpPresStatusIntfDO[] aggdos) throws BizException;
	
    /**
	*  国药用处方获取数据保存
	*/
	public abstract OpPresStatusIntfDO[] save(OpPresStatusIntfDO[] aggdos) throws BizException;
	
    /**
	*  国药用处方获取数据更新
	*/
	public abstract OpPresStatusIntfDO[] update(OpPresStatusIntfDO[] aggdos) throws BizException;
	
	/**
	*  国药用处方获取数据逻辑删除
	*/
	public abstract void logicDelete(OpPresStatusIntfDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OpPresStatusIntfDO[] enableWithoutFilter(OpPresStatusIntfDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OpPresStatusIntfDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OpPresStatusIntfDO[] disableVOWithoutFilter(OpPresStatusIntfDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OpPresStatusIntfDO[] dos) throws BizException ;
}
