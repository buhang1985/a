package iih.en.pv.enclin.i;

import xap.mw.core.data.BizException;
import iih.en.pv.enclin.d.EntStateDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 就诊状况数据维护服务
*/
public interface IEntstateCudService {
	/**
	*  就诊状况数据真删除
	*/
    public abstract void delete(EntStateDO[] aggdos) throws BizException;
    
    /**
	*  就诊状况数据插入保存
	*/
	public abstract EntStateDO[] insert(EntStateDO[] aggdos) throws BizException;
	
    /**
	*  就诊状况数据保存
	*/
	public abstract EntStateDO[] save(EntStateDO[] aggdos) throws BizException;
	
    /**
	*  就诊状况数据更新
	*/
	public abstract EntStateDO[] update(EntStateDO[] aggdos) throws BizException;
	
	/**
	*  就诊状况数据逻辑删除
	*/
	public abstract void logicDelete(EntStateDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EntStateDO[] enableWithoutFilter(EntStateDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EntStateDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EntStateDO[] disableVOWithoutFilter(EntStateDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EntStateDO[] dos) throws BizException ;
}
