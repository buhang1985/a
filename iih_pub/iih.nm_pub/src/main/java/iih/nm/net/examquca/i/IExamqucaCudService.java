package iih.nm.net.examquca.i;

import xap.mw.core.data.BizException;
import iih.nm.net.examquca.d.ExamQuCaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 试题类别数据维护服务
*/
public interface IExamqucaCudService {
	/**
	*  试题类别数据真删除
	*/
    public abstract void delete(ExamQuCaDO[] aggdos) throws BizException;
    
    /**
	*  试题类别数据插入保存
	*/
	public abstract ExamQuCaDO[] insert(ExamQuCaDO[] aggdos) throws BizException;
	
    /**
	*  试题类别数据保存
	*/
	public abstract ExamQuCaDO[] save(ExamQuCaDO[] aggdos) throws BizException;
	
    /**
	*  试题类别数据更新
	*/
	public abstract ExamQuCaDO[] update(ExamQuCaDO[] aggdos) throws BizException;
	
	/**
	*  试题类别数据逻辑删除
	*/
	public abstract void logicDelete(ExamQuCaDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ExamQuCaDO[] enableWithoutFilter(ExamQuCaDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ExamQuCaDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ExamQuCaDO[] disableVOWithoutFilter(ExamQuCaDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ExamQuCaDO[] dos) throws BizException ;
}
