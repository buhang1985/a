package iih.nm.net.examchkpl.i;

import xap.mw.core.data.BizException;
import iih.nm.net.examchkpl.d.ExamChkPlDO;
import iih.nm.net.examchkpl.d.ExamchkplAggDO;

/**
* 考核计划数据维护服务
*/
public interface IExamchkplCudService {
	/**
	*  考核计划数据真删除
	*/
    public abstract void delete(ExamchkplAggDO[] aggdos) throws BizException;
    
    /**
	*  考核计划数据插入保存
	*/
	public abstract ExamchkplAggDO[] insert(ExamchkplAggDO[] aggdos) throws BizException;
	
    /**
	*  考核计划数据保存
	*/
	public abstract ExamchkplAggDO[] save(ExamchkplAggDO[] aggdos) throws BizException;
	
    /**
	*  考核计划数据更新
	*/
	public abstract ExamchkplAggDO[] update(ExamchkplAggDO[] aggdos) throws BizException;
	
	/**
	*  考核计划数据逻辑删除
	*/
	public abstract void logicDelete(ExamchkplAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对考核计划数据真删除
	 */
	public abstract void deleteByParentDO(ExamChkPlDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对考核计划数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ExamChkPlDO[] mainDos) throws BizException;
}
