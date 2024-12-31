package iih.nm.net.examchk.i;

import xap.mw.core.data.BizException;
import iih.nm.net.examchk.d.ExamChkDO;
import iih.nm.net.examchk.d.ExamchkAggDO;

/**
* 护理人员考核数据维护服务
*/
public interface IExamchkCudService {
	/**
	*  护理人员考核数据真删除
	*/
    public abstract void delete(ExamchkAggDO[] aggdos) throws BizException;
    
    /**
	*  护理人员考核数据插入保存
	*/
	public abstract ExamchkAggDO[] insert(ExamchkAggDO[] aggdos) throws BizException;
	
    /**
	*  护理人员考核数据保存
	*/
	public abstract ExamchkAggDO[] save(ExamchkAggDO[] aggdos) throws BizException;
	
    /**
	*  护理人员考核数据更新
	*/
	public abstract ExamchkAggDO[] update(ExamchkAggDO[] aggdos) throws BizException;
	
	/**
	*  护理人员考核数据逻辑删除
	*/
	public abstract void logicDelete(ExamchkAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护理人员考核数据真删除
	 */
	public abstract void deleteByParentDO(ExamChkDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护理人员考核数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ExamChkDO[] mainDos) throws BizException;
}
