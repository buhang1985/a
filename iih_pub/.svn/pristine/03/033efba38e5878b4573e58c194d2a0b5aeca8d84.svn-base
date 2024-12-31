package iih.nm.nit.nitevaluate.i;

import xap.mw.core.data.BizException;
import iih.nm.nit.nitevaluate.d.NitevaluateDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 实习评定数据维护服务
*/
public interface INitevaluateCudService {
	/**
	*  实习评定数据真删除
	*/
    public abstract void delete(NitevaluateDO[] aggdos) throws BizException;
    
    /**
	*  实习评定数据插入保存
	*/
	public abstract NitevaluateDO[] insert(NitevaluateDO[] aggdos) throws BizException;
	
    /**
	*  实习评定数据保存
	*/
	public abstract NitevaluateDO[] save(NitevaluateDO[] aggdos) throws BizException;
	
    /**
	*  实习评定数据更新
	*/
	public abstract NitevaluateDO[] update(NitevaluateDO[] aggdos) throws BizException;
	
	/**
	*  实习评定数据逻辑删除
	*/
	public abstract void logicDelete(NitevaluateDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NitevaluateDO[] enableWithoutFilter(NitevaluateDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NitevaluateDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NitevaluateDO[] disableVOWithoutFilter(NitevaluateDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NitevaluateDO[] dos) throws BizException ;
}
