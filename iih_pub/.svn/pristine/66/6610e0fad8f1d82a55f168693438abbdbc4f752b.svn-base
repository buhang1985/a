package iih.nm.net.exampp.i;

import xap.mw.core.data.BizException;
import iih.nm.net.exampp.d.ExamppDO;
import iih.nm.net.exampp.d.ExamppAggDO;

/**
* 试卷数据维护服务
*/
public interface IExamppCudService {
	/**
	*  试卷数据真删除
	*/
    public abstract void delete(ExamppAggDO[] aggdos) throws BizException;
    
    /**
	*  试卷数据插入保存
	*/
	public abstract ExamppAggDO[] insert(ExamppAggDO[] aggdos) throws BizException;
	
    /**
	*  试卷数据保存
	*/
	public abstract ExamppAggDO[] save(ExamppAggDO[] aggdos) throws BizException;
	
    /**
	*  试卷数据更新
	*/
	public abstract ExamppAggDO[] update(ExamppAggDO[] aggdos) throws BizException;
	
	/**
	*  试卷数据逻辑删除
	*/
	public abstract void logicDelete(ExamppAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对试卷数据真删除
	 */
	public abstract void deleteByParentDO(ExamppDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对试卷数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ExamppDO[] mainDos) throws BizException;
}
