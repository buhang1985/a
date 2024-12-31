package iih.pe.pps.pecohort.i;

import xap.mw.core.data.BizException;
import iih.pe.pps.pecohort.d.PeCohortPsnDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检人群队列管理数据维护服务
*/
public interface IPeCohortPsnDOCudService {
	/**
	*  体检人群队列管理数据真删除
	*/
    public abstract void delete(PeCohortPsnDO[] aggdos) throws BizException;
    
    /**
	*  体检人群队列管理数据插入保存
	*/
	public abstract PeCohortPsnDO[] insert(PeCohortPsnDO[] aggdos) throws BizException;
	
    /**
	*  体检人群队列管理数据保存
	*/
	public abstract PeCohortPsnDO[] save(PeCohortPsnDO[] aggdos) throws BizException;
	
    /**
	*  体检人群队列管理数据更新
	*/
	public abstract PeCohortPsnDO[] update(PeCohortPsnDO[] aggdos) throws BizException;
	
	/**
	*  体检人群队列管理数据逻辑删除
	*/
	public abstract void logicDelete(PeCohortPsnDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeCohortPsnDO[] enableWithoutFilter(PeCohortPsnDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeCohortPsnDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeCohortPsnDO[] disableVOWithoutFilter(PeCohortPsnDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeCohortPsnDO[] aggdos) throws BizException ;
	
}
