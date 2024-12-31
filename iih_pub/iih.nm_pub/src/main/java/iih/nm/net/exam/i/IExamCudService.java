package iih.nm.net.exam.i;

import xap.mw.core.data.BizException;
import iih.nm.net.exam.d.ExamDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 考试数据维护服务
*/
public interface IExamCudService {
	/**
	*  考试数据真删除
	*/
    public abstract void delete(ExamDO[] aggdos) throws BizException;
    
    /**
	*  考试数据插入保存
	*/
	public abstract ExamDO[] insert(ExamDO[] aggdos) throws BizException;
	
    /**
	*  考试数据保存
	*/
	public abstract ExamDO[] save(ExamDO[] aggdos) throws BizException;
	
    /**
	*  考试数据更新
	*/
	public abstract ExamDO[] update(ExamDO[] aggdos) throws BizException;
	
	/**
	*  考试数据逻辑删除
	*/
	public abstract void logicDelete(ExamDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ExamDO[] enableWithoutFilter(ExamDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ExamDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ExamDO[] disableVOWithoutFilter(ExamDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ExamDO[] dos) throws BizException ;
}
