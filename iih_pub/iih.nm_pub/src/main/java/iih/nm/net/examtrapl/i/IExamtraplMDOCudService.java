package iih.nm.net.examtrapl.i;

import xap.mw.core.data.BizException;
import iih.nm.net.examtrapl.d.ExamtraplDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 培训计划数据维护服务
*/
public interface IExamtraplMDOCudService {
	/**
	*  培训计划数据真删除
	*/
    public abstract void delete(ExamtraplDO[] aggdos) throws BizException;
    
    /**
	*  培训计划数据插入保存
	*/
	public abstract ExamtraplDO[] insert(ExamtraplDO[] aggdos) throws BizException;
	
    /**
	*  培训计划数据保存
	*/
	public abstract ExamtraplDO[] save(ExamtraplDO[] aggdos) throws BizException;
	
    /**
	*  培训计划数据更新
	*/
	public abstract ExamtraplDO[] update(ExamtraplDO[] aggdos) throws BizException;
	
	/**
	*  培训计划数据逻辑删除
	*/
	public abstract void logicDelete(ExamtraplDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ExamtraplDO[] enableWithoutFilter(ExamtraplDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ExamtraplDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ExamtraplDO[] disableVOWithoutFilter(ExamtraplDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ExamtraplDO[] aggdos) throws BizException ;
	
}
