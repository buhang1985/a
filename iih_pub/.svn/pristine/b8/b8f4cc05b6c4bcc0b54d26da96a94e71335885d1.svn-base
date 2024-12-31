package iih.nm.net.examqu.i;

import xap.mw.core.data.BizException;
import iih.nm.net.examqu.d.ExamQuDO;
import iih.nm.net.examqu.d.ExamquAggDO;

/**
* 试题数据维护服务
*/
public interface IExamquCudService {
	/**
	*  试题数据真删除
	*/
    public abstract void delete(ExamquAggDO[] aggdos) throws BizException;
    
    /**
	*  试题数据插入保存
	*/
	public abstract ExamquAggDO[] insert(ExamquAggDO[] aggdos) throws BizException;
	
    /**
	*  试题数据保存
	*/
	public abstract ExamquAggDO[] save(ExamquAggDO[] aggdos) throws BizException;
	
    /**
	*  试题数据更新
	*/
	public abstract ExamquAggDO[] update(ExamquAggDO[] aggdos) throws BizException;
	
	/**
	*  试题数据逻辑删除
	*/
	public abstract void logicDelete(ExamquAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对试题数据真删除
	 */
	public abstract void deleteByParentDO(ExamQuDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对试题数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ExamQuDO[] mainDos) throws BizException;
}
