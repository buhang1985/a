package iih.nm.net.examtrapl.i;

import xap.mw.core.data.BizException;
import iih.nm.net.examtrapl.d.ExamtraplDO;
import iih.nm.net.examtrapl.d.ExamtraplAggDO;

/**
* 培训计划数据维护服务
*/
public interface IExamtraplCudService {
	/**
	*  培训计划数据真删除
	*/
    public abstract void delete(ExamtraplAggDO[] aggdos) throws BizException;
    
    /**
	*  培训计划数据插入保存
	*/
	public abstract ExamtraplAggDO[] insert(ExamtraplAggDO[] aggdos) throws BizException;
	
    /**
	*  培训计划数据保存
	*/
	public abstract ExamtraplAggDO[] save(ExamtraplAggDO[] aggdos) throws BizException;
	
    /**
	*  培训计划数据更新
	*/
	public abstract ExamtraplAggDO[] update(ExamtraplAggDO[] aggdos) throws BizException;
	
	/**
	*  培训计划数据逻辑删除
	*/
	public abstract void logicDelete(ExamtraplAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对培训计划数据真删除
	 */
	public abstract void deleteByParentDO(ExamtraplDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对培训计划数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ExamtraplDO[] mainDos) throws BizException;
}
