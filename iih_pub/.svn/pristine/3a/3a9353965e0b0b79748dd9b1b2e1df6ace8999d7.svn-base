package iih.nm.net.examppqurule.i;

import xap.mw.core.data.BizException;
import iih.nm.net.examppqurule.d.ExamppQuruleDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 试卷试题抽取规则数据维护服务
*/
public interface IExamppquruleCudService {
	/**
	*  试卷试题抽取规则数据真删除
	*/
    public abstract void delete(ExamppQuruleDO[] aggdos) throws BizException;
    
    /**
	*  试卷试题抽取规则数据插入保存
	*/
	public abstract ExamppQuruleDO[] insert(ExamppQuruleDO[] aggdos) throws BizException;
	
    /**
	*  试卷试题抽取规则数据保存
	*/
	public abstract ExamppQuruleDO[] save(ExamppQuruleDO[] aggdos) throws BizException;
	
    /**
	*  试卷试题抽取规则数据更新
	*/
	public abstract ExamppQuruleDO[] update(ExamppQuruleDO[] aggdos) throws BizException;
	
	/**
	*  试卷试题抽取规则数据逻辑删除
	*/
	public abstract void logicDelete(ExamppQuruleDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ExamppQuruleDO[] enableWithoutFilter(ExamppQuruleDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ExamppQuruleDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ExamppQuruleDO[] disableVOWithoutFilter(ExamppQuruleDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ExamppQuruleDO[] dos) throws BizException ;
}
