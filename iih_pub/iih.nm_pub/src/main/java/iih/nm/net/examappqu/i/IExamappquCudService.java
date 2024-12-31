package iih.nm.net.examappqu.i;

import xap.mw.core.data.BizException;
import iih.nm.net.examappqu.d.NmExamAppQuDO;
import iih.nm.net.examappqu.d.ExamappquAggDO;

/**
* 人员考试题目数据维护服务
*/
public interface IExamappquCudService {
	/**
	*  人员考试题目数据真删除
	*/
    public abstract void delete(ExamappquAggDO[] aggdos) throws BizException;
    
    /**
	*  人员考试题目数据插入保存
	*/
	public abstract ExamappquAggDO[] insert(ExamappquAggDO[] aggdos) throws BizException;
	
    /**
	*  人员考试题目数据保存
	*/
	public abstract ExamappquAggDO[] save(ExamappquAggDO[] aggdos) throws BizException;
	
    /**
	*  人员考试题目数据更新
	*/
	public abstract ExamappquAggDO[] update(ExamappquAggDO[] aggdos) throws BizException;
	
	/**
	*  人员考试题目数据逻辑删除
	*/
	public abstract void logicDelete(ExamappquAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对人员考试题目数据真删除
	 */
	public abstract void deleteByParentDO(NmExamAppQuDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对人员考试题目数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmExamAppQuDO[] mainDos) throws BizException;
}
