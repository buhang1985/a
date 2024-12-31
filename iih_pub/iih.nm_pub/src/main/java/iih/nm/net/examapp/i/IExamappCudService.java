package iih.nm.net.examapp.i;

import xap.mw.core.data.BizException;
import iih.nm.net.examapp.d.ExamAppDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 人员考试数据维护服务
*/
public interface IExamappCudService {
	/**
	*  人员考试数据真删除
	*/
    public abstract void delete(ExamAppDO[] aggdos) throws BizException;
    
    /**
	*  人员考试数据插入保存
	*/
	public abstract ExamAppDO[] insert(ExamAppDO[] aggdos) throws BizException;
	
    /**
	*  人员考试数据保存
	*/
	public abstract ExamAppDO[] save(ExamAppDO[] aggdos) throws BizException;
	
    /**
	*  人员考试数据更新
	*/
	public abstract ExamAppDO[] update(ExamAppDO[] aggdos) throws BizException;
	
	/**
	*  人员考试数据逻辑删除
	*/
	public abstract void logicDelete(ExamAppDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ExamAppDO[] enableWithoutFilter(ExamAppDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ExamAppDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ExamAppDO[] disableVOWithoutFilter(ExamAppDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ExamAppDO[] dos) throws BizException ;
}
