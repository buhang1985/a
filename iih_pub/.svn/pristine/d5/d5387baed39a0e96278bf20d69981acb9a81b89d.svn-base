package iih.nm.nhr.nhrsched.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nhrsched.d.NhrSchedDO;
import iih.nm.nhr.nhrsched.d.NhrschedAggDO;

/**
* 人员排班数据维护服务
*/
public interface INhrschedCudService {
	/**
	*  人员排班数据真删除
	*/
    public abstract void delete(NhrschedAggDO[] aggdos) throws BizException;
    
    /**
	*  人员排班数据插入保存
	*/
	public abstract NhrschedAggDO[] insert(NhrschedAggDO[] aggdos) throws BizException;
	
    /**
	*  人员排班数据保存
	*/
	public abstract NhrschedAggDO[] save(NhrschedAggDO[] aggdos) throws BizException;
	
    /**
	*  人员排班数据更新
	*/
	public abstract NhrschedAggDO[] update(NhrschedAggDO[] aggdos) throws BizException;
	
	/**
	*  人员排班数据逻辑删除
	*/
	public abstract void logicDelete(NhrschedAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对人员排班数据真删除
	 */
	public abstract void deleteByParentDO(NhrSchedDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对人员排班数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NhrSchedDO[] mainDos) throws BizException;
}
