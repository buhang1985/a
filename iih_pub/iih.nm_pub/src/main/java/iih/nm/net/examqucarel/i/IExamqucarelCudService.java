package iih.nm.net.examqucarel.i;

import xap.mw.core.data.BizException;
import iih.nm.net.examqucarel.d.ExamQuCaRelDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 试题类别与试题关系数据维护服务
*/
public interface IExamqucarelCudService {
	/**
	*  试题类别与试题关系数据真删除
	*/
    public abstract void delete(ExamQuCaRelDO[] aggdos) throws BizException;
    
    /**
	*  试题类别与试题关系数据插入保存
	*/
	public abstract ExamQuCaRelDO[] insert(ExamQuCaRelDO[] aggdos) throws BizException;
	
    /**
	*  试题类别与试题关系数据保存
	*/
	public abstract ExamQuCaRelDO[] save(ExamQuCaRelDO[] aggdos) throws BizException;
	
    /**
	*  试题类别与试题关系数据更新
	*/
	public abstract ExamQuCaRelDO[] update(ExamQuCaRelDO[] aggdos) throws BizException;
	
	/**
	*  试题类别与试题关系数据逻辑删除
	*/
	public abstract void logicDelete(ExamQuCaRelDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ExamQuCaRelDO[] enableWithoutFilter(ExamQuCaRelDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ExamQuCaRelDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ExamQuCaRelDO[] disableVOWithoutFilter(ExamQuCaRelDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ExamQuCaRelDO[] dos) throws BizException ;
}
