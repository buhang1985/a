package iih.nm.net.examqu.i;

import xap.mw.core.data.BizException;
import iih.nm.net.examqu.d.ExamQuAnsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 试题数据维护服务
*/
public interface IExamQuAnsDOCudService {
	/**
	*  试题数据真删除
	*/
    public abstract void delete(ExamQuAnsDO[] aggdos) throws BizException;
    
    /**
	*  试题数据插入保存
	*/
	public abstract ExamQuAnsDO[] insert(ExamQuAnsDO[] aggdos) throws BizException;
	
    /**
	*  试题数据保存
	*/
	public abstract ExamQuAnsDO[] save(ExamQuAnsDO[] aggdos) throws BizException;
	
    /**
	*  试题数据更新
	*/
	public abstract ExamQuAnsDO[] update(ExamQuAnsDO[] aggdos) throws BizException;
	
	/**
	*  试题数据逻辑删除
	*/
	public abstract void logicDelete(ExamQuAnsDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ExamQuAnsDO[] enableWithoutFilter(ExamQuAnsDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ExamQuAnsDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ExamQuAnsDO[] disableVOWithoutFilter(ExamQuAnsDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ExamQuAnsDO[] aggdos) throws BizException ;
	
}
