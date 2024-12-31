package iih.nm.net.examppscorelvl.i;

import xap.mw.core.data.BizException;
import iih.nm.net.examppscorelvl.d.ExamppScoreLvlDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 试卷评分等级数据维护服务
*/
public interface IExamppscorelvlCudService {
	/**
	*  试卷评分等级数据真删除
	*/
    public abstract void delete(ExamppScoreLvlDO[] aggdos) throws BizException;
    
    /**
	*  试卷评分等级数据插入保存
	*/
	public abstract ExamppScoreLvlDO[] insert(ExamppScoreLvlDO[] aggdos) throws BizException;
	
    /**
	*  试卷评分等级数据保存
	*/
	public abstract ExamppScoreLvlDO[] save(ExamppScoreLvlDO[] aggdos) throws BizException;
	
    /**
	*  试卷评分等级数据更新
	*/
	public abstract ExamppScoreLvlDO[] update(ExamppScoreLvlDO[] aggdos) throws BizException;
	
	/**
	*  试卷评分等级数据逻辑删除
	*/
	public abstract void logicDelete(ExamppScoreLvlDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ExamppScoreLvlDO[] enableWithoutFilter(ExamppScoreLvlDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ExamppScoreLvlDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ExamppScoreLvlDO[] disableVOWithoutFilter(ExamppScoreLvlDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ExamppScoreLvlDO[] dos) throws BizException ;
}
