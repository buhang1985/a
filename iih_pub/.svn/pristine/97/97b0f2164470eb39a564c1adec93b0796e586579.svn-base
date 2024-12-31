package iih.en.pv.inpatient.i;

import xap.mw.core.data.BizException;
import iih.en.pv.inpatient.d.InpatientDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 组件数据维护服务
*/
public interface IInpatientCudService {
	/**
	*  组件数据真删除
	*/
    public abstract void delete(InpatientDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract InpatientDO[] insert(InpatientDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract InpatientDO[] save(InpatientDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract InpatientDO[] update(InpatientDO[] aggdos) throws BizException;
	
	/**
	*  组件数据逻辑删除
	*/
	public abstract void logicDelete(InpatientDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public InpatientDO[] enableWithoutFilter(InpatientDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(InpatientDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public InpatientDO[] disableVOWithoutFilter(InpatientDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(InpatientDO[] dos) throws BizException ;
}
